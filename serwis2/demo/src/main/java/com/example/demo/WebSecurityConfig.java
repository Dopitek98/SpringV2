package com.example.demo;

import com.example.demo.Service.UserDetailsServiceImplementation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private UserDetailsServiceImplementation userDetailsService;

    public WebSecurityConfig(UserDetailsServiceImplementation userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/hello").authenticated()
               // .antMatchers("/upload").hasAuthority("ROLE_ADMIN")
                 .antMatchers("/upload").authenticated()
                .antMatchers("/AdminGui").hasAuthority("ROLE_ADMIN")
                .antMatchers("/imagelist").hasAuthority("ROLE_ADMIN")
                .antMatchers("/gallery").permitAll()

                 .and()
                .formLogin().defaultSuccessUrl("/hello")
                .and().csrf().disable().headers().frameOptions().disable().and()
                .headers().disable();
    }
}
