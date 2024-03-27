//package com.evnt.Config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//	        return new BCryptPasswordEncoder();
//	}
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception 
//	{
//	        http.authorizeHttpRequests((authz)->authz.anyRequest().permitAll());
//	        http.cors(Customizer.withDefaults());
//	        return http.build();
//	}
//	
//	@Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//		return (web) -> web.ignoring().requestMatchers(HttpMethod.OPTIONS, "/**");
//    }
//	
//	@Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("*")
//                        .allowedMethods("*")
//                        .allowedHeaders("*");
//            }
//        };
//    }
//}
