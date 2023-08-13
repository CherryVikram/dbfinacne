package com.cherry.finance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Allow requests from these origins
        config.addAllowedOrigin("*"); // Adjust the origin as needed

        // Allow specific HTTP methods (GET, POST, PUT, etc.)
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        // You can add more methods as needed

        // Allow specific HTTP headers
        config.addAllowedHeader("Authorization");
        config.addAllowedHeader("Content-Type");
        // You can add more headers as needed

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}




