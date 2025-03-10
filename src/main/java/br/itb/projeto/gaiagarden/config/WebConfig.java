package br.itb.projeto.gaiagarden.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

		
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**")
				.allowedMethods("GET", "POST", "PUT",
						"PATCH", "DELETE", "OPTIONS",
						"HEAD", "TRACE", "CONNECET").allowCredentials(false).maxAge(3600);
		}
	}

