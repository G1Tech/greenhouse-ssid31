package cc.g1cloud.greenhousessid31.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configurable
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .inMemoryAuthentication()
                .withUser("module-01")
                .password("{noop}XbU#M")
                .roles("WEB_USER")
                .and()
                .withUser("admin-R1")
                .password("{noop}XbU#M'Ykav~N4:vF")
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/telemetry/**").access("hasRole('WEB_USER')")
                .antMatchers("/*").denyAll()
                .anyRequest().permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable()
                .cors().disable()
                .formLogin().disable();
    }


}