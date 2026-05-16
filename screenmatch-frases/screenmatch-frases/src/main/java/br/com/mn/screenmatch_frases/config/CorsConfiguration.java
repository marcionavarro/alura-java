package br.com.mn.screenmatch_frases.config;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    public void addCorsMappings(@NotNull CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:5500/")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE");
    }
}
