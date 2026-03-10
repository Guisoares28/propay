package com.example.paypro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.paypro.repositories.UsuarioRepository;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
		return http
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth
						.anyRequest().permitAll()
				)
				.headers(headers -> headers
						.frameOptions(options -> options.sameOrigin()))
				.formLogin(form -> form
						.loginPage("/login-form")
						.permitAll()
				)
				.build();
	}
    
    @Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
    
    @Bean
    public UserDetailsServiceImpl userDetailsServiceImpl(UsuarioRepository usuarioRepository) {
    	return new UserDetailsServiceImpl(usuarioRepository);
    }
}
