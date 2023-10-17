package com.example.server.common;

import static org.springframework.security.config.Customizer.withDefaults;

import javax.servlet.DispatcherType;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.session.ConcurrentSessionFilter;

import com.example.server.common.interceptor.SessionCheckFilter;
import com.example.server.common.sys.handler.CustomAuthenticationFailureHandler;
import com.example.server.common.sys.handler.CustomAuthenticationProvider;
import com.example.server.common.sys.handler.CustomAuthenticationSuccessHandler;
import com.example.server.common.sys.session.CustomConcurrentSessionFilter;
import com.example.server.common.sys.session.CustomSessionInformationExpiredStrategy;




@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	@Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/status", "*/resources/**" ,"/images/**", "/auth/join","/loginprc123123","/test","/","/login","/favicon.ico","/duplicationLogin");
    }
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable()
                .authorizeHttpRequests(request -> request
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/")
                        .loginProcessingUrl("/loginprc")
                        .usernameParameter("userid")
                        .passwordParameter("pw")
//                        .defaultSuccessUrl("/success", true)
                        .successHandler(succHandler())
                        .failureHandler(failHandler())
                        .permitAll()
                )
                .logout(withDefaults())
		        .sessionManagement() // session 관리 하게따
		        .maximumSessions(1) // maximunSessions : Session 허용 개수 (1개로_
		        .maxSessionsPreventsLogin(false)
        		.expiredUrl("/duplicationLogin")
        		.sessionRegistry(sessionRegistry());
        
        http.addFilterBefore(concurrentSessionFilter(), ConcurrentSessionFilter.class);
        

        return http.build();
    }
    
    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new CustomAuthenticationProvider();
    }
    
    
    @Bean
    public AuthenticationFailureHandler failHandler() {
        return new CustomAuthenticationFailureHandler();
    }
    
    @Bean
    public AuthenticationSuccessHandler succHandler() {
        return new CustomAuthenticationSuccessHandler();
    }
    
    @Bean
    public SessionCheckFilter customFilter() {
        return new SessionCheckFilter();
    }
    
    @Bean
	public ConcurrentSessionFilter concurrentSessionFilter() {
        CustomSessionInformationExpiredStrategy redirectStrategy = new CustomSessionInformationExpiredStrategy("/duplicationLogin");
        CustomConcurrentSessionFilter concurrentSessionFilter = new CustomConcurrentSessionFilter(sessionRegistry(), redirectStrategy);
        return concurrentSessionFilter;
	}
    
    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }	
	
}