package com;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/", "/static/", "/resources/css/",
                "/resources/js/", "/resources/images/**","/resources/bootstrap/**","/resources/fonts/");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/greeting", "/login", "/bank-list**").permitAll()
                .antMatchers("/client**").hasAnyRole("CLIENT", "BANK", "ADMIN")
                .antMatchers("/bank**").hasAnyRole("BANK", "ADMIN")
                .antMatchers("/admin**").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("client")
                .password(encoder.encode("3"))
                .roles("CLIENT")
                .and()
                .withUser("bank")
                .password(encoder.encode("2"))
                .roles("BANK")
                .and()
                .withUser("admin")
                .password(encoder.encode("1"))
                .roles("ADMIN");
    }

}
