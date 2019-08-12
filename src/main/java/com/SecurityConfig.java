package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/", "/static/", "/resources/css/",
                "/resources/js/", "/resources/images/**", "/resources/bootstrap/**", "/resources/fonts/");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/index", "/login", "/register", "/static/**").permitAll()
//                .antMatchers("/", "/greeting", "/login", "/bank-list**").permitAll()
//                .antMatchers("/admin**").access("hasRole('ADMIN')")
//                .antMatchers("/bank**").hasAnyRole("BANK", "ADMIN")
//                .antMatchers("/client**").hasAnyRole("CLIENT", "BANK", "ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/admin", true)
                .permitAll()
                .and()
                .logout()
                .permitAll();

    }


    @Autowired
    DataSource dataSource;

    @Autowired
    public void config(AuthenticationManagerBuilder auth) throws Exception {


        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select users.name, users.password, users.active from users where users.name=?")
                .authoritiesByUsernameQuery(
                        "select users.name, role.type FROM users, role where role.id = users.role and users.name=?").passwordEncoder(new BCryptPasswordEncoder());

    }


}