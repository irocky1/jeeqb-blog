package com.jeeqb.zblog.config;

import com.jeeqb.zblog.auth.CustomAuthenticationProvider;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * FILE: com.jeeqb.zblog.config.WebSecurityAdapter.java
 */
@Configuration
@EnableWebSecurity
public class WebSecurityAdapter extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/","/blog/**","/tag/**","friend","/login/**","/login/auth").permitAll()
                .antMatchers("/admin/**").authenticated()
                .and().rememberMe().tokenValiditySeconds(3600)
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/admin/article/list").permitAll()
                .and().logout().logoutUrl("/admin/loginOut").permitAll();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/**/*.*");
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        AuthenticationProvider authenticationProvider=new CustomAuthenticationProvider();
        return authenticationProvider;
    }
}
