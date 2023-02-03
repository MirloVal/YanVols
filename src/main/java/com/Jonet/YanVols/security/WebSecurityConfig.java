package com.Jonet.YanVols.security;


import com.Jonet.YanVols.filters.JwtRequestFilter;
import com.Jonet.YanVols.utils.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfiguration {

    @Bean
    public MyUserDetailsService getMyUserDetails() {
        return new MyUserDetailsService();
    }
    @Bean
    public JwtRequestFilter getJwtRequestFilter( ) {
        return new JwtRequestFilter(getMyUserDetails(), new JwtUtil());
    }
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http)
            throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(getMyUserDetails())
                .passwordEncoder(getPasswordEncoder())
                .and()
                .build();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeHttpRequests()
                .anyRequest()
                .permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(getJwtRequestFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

}

