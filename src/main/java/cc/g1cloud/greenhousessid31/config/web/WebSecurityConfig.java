package cc.g1cloud.greenhousessid31.config.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .inMemoryAuthentication()
                .withUser("module-01")
                .password("{bcrypt}$2a$10$JdiiMxvGECMXOfPnFFu/YeNtQxzmeNgCvv25MO4n0llMZLf78DVu6")
                .roles("WEB_USER")
                .and()
                .withUser("admin-R1")
                .password("{bcrypt}$2a$10$uE62WEn6kIvJZLntDnIWtOq0uNVYPdLRTeiDrsCyAOnCK.OLe5NUa")
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers("/telemetry/**").access("hasRole('WEB_USER')")
                .antMatchers("/v2/telemetry/**").access("hasRole('WEB_USER')")
                .anyRequest().permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable()
//                .cors().disable()
                .formLogin().disable();
    }


}