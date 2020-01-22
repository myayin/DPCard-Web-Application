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
    @Autowired
    private AuthenticationEntryPoint authEntryPoint;

    private final String USERS_QUERY = "SELECT employee_email, employee_password, employee_status FROM employee WHERE employee.employee_email = ?";
    private final String CM_QUERY = "SELECT contracted_merchant_email, contracted_merchant_password, contracted_merchant_status FROM contracted_merchant WHERE contracted_merchant.contracted_merchant_email = ?";

    private final String AUTHORITIES_QUERY = "SELECT employee.employee_email, " +
            "authority.authority " +
            "FROM authority left join employee on authority.employeeid = employee.employeeid  " +
            "WHERE employee.employee_email = ? ";
    private final String AUTHORITIES_QUERY_CM = "SELECT contracted_merchant.contracted_merchant_email, " +
            "authority.authority " +
            "FROM authority left join contracted_merchant on authority.contracted_merchantid = contracted_merchant.contracted_merchantid  " +
            "WHERE contracted_merchant.contracted_merchant_email = ? ";


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(USERS_QUERY)
                .authoritiesByUsernameQuery(AUTHORITIES_QUERY)
                .passwordEncoder(new BCryptPasswordEncoder());
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(CM_QUERY)
                .authoritiesByUsernameQuery(AUTHORITIES_QUERY_CM)
                .passwordEncoder(new BCryptPasswordEncoder());
     /*   auth.inMemoryAuthentication()
                .withUser("tim").password("123").roles("ADMIN")
                .and()
                .withUser("joe").password("234").roles("User");*/
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
                .and()*

   *//*  .httpBasic();
     /*   http.authorizeRequests()
                .antMatchers("/").permitAll()
                //.antMatchers("/vehicle").permitAll()
                .antMatchers("/vehicle/add")
                .hasAuthority("USER")
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .disable()
                ;*/
      http.
                csrf().disable()
                .authorizeRequests()
                .antMatchers("/vehicle/add").hasAuthority("User")
             .antMatchers("/employee/register").hasAuthority("Merchant")
                .anyRequest().authenticated()
                .and().httpBasic();
        /* http.csrf().disable().authorizeRequests()
                .antMatchers("/vehicle/add").hasAuthority(Email)//USER role can access /users/**
                //.antMatchers("/admin/**").has("ADMIN")//ADMIN role can access /admin/**
               // .antMatchers("/quests/**").permitAll()// anyone can access /quests/**
                .anyRequest().authenticated();//any other request just need authentication
                //enable form login

      /*  http.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "User")
                .and()
                .httpBasic(); // Authenticate users with HTTP basic authentication*/
    }




   /* @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/employee/register",
                        "contractedMerchant/**",
                        "/restaurantHistory/**",
                        "/employee/confirm-register",
                        "/confirmation/send-token",
                        "/employee/confirm-reset-password",
                        "/error");
    }
*/
}



