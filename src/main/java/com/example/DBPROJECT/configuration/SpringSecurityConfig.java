package com.example.DBPROJECT.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    private final String USERS_QUERY = "SELECT u.employee_email, " +
            "u.employee_password, " +
            "FROM employee AS u " +
            "WHERE u.employee_email = ? ";

    private final String AUTHORITIES_QUERY = "SELECT employee.employee_email, " +
            "authority.authority " +
            "FROM authority left join employee on authority.employeeid = employee.employeeid  " +
            "WHERE employee.employee_email = ? ";

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(USERS_QUERY)
                .authoritiesByUsernameQuery(AUTHORITIES_QUERY)
                .passwordEncoder(new BCryptPasswordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

      /*  http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers()
                .hasRole("User")
                .anyRequest()
                .permitAll()
                .and()
             .httpBasic();*/
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/employee/add_vehicle").permitAll()
                .antMatchers("/**")
                .hasAuthority("USER")
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .disable()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/")
                .usernameParameter("employeeEmail")
                .passwordParameter("employeePassword")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied");

    }
    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/employee/register",
                        "/employee/confirm-register",
                        "/confirmation/send-token",
                        "/employee/confirm-reset-password",
                        "/error");
    }

}



