package com.real.realoasis.global.security;

import com.real.realoasis.global.filter.ExceptionHandlerFilter;
import com.real.realoasis.global.filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final ExceptionHandlerFilter exceptionHandlerFilter;

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http
                .cors();
        http
                .csrf().disable()
                .httpBasic().disable();
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS,"/**/*").permitAll()
                //auth
                .antMatchers(HttpMethod.PATCH,"/auth/refresh").permitAll()
                .antMatchers(HttpMethod.POST,"/auth/signup").permitAll()
                .antMatchers(HttpMethod.POST,"/auth/login").permitAll()
                .antMatchers(HttpMethod.PATCH, "/auth/logout").permitAll()
                .antMatchers(HttpMethod.GET,"/auth/search/id").permitAll()
                .antMatchers(HttpMethod.GET,"/auth/search/pw").permitAll()
                .antMatchers(HttpMethod.POST,"/auth/mailconfirm").permitAll()
                .antMatchers(HttpMethod.POST,"/auth/sendmail").permitAll()

                //user
                .antMatchers(HttpMethod.DELETE, "/user/withdrawal").authenticated()
                .antMatchers(HttpMethod.POST,"/user/connect/couple").authenticated()

                //user/setting
                .antMatchers(HttpMethod.GET,"/user/setting/").authenticated()
                .antMatchers(HttpMethod.PATCH,"/user/setting/change/nickname").authenticated()
                .antMatchers(HttpMethod.PATCH,"/user/setting/change/password").authenticated()
                .antMatchers(HttpMethod.PATCH,"/user/setting/change/questiontime").authenticated()
                .antMatchers(HttpMethod.PATCH,"/user/setting/change/anniversarytime").authenticated()

                //mainpage
                .antMatchers(HttpMethod.GET,"/mainpage/").authenticated()
                .antMatchers(HttpMethod.POST,"/mainpage/enter/datingdate").authenticated()

                //diary
                .antMatchers(HttpMethod.POST,"/diary/create").authenticated()
                .antMatchers(HttpMethod.PATCH,"/diary/edit/**").authenticated()
                .antMatchers(HttpMethod.GET,"/diary/detail/**").authenticated()
                .antMatchers(HttpMethod.DELETE,"/diary/delete/**").authenticated()
                .antMatchers(HttpMethod.GET,"/diary/list").authenticated()

                //question
                .antMatchers(HttpMethod.POST,"/question/answer/**").authenticated()
                .antMatchers(HttpMethod.GET,"/question/list").authenticated()
                .antMatchers(HttpMethod.GET,"/question/**").authenticated()

                .anyRequest().permitAll();
        http
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(exceptionHandlerFilter, JwtAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
