package com.sdqi2021.AQMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AqmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AqmsApplication.class, args);
	}

//	@Configuration
//	public static class WebConfig implements WebMvcConfigurer {
//
//		@Override
//		public void addResourceHandlers(ResourceHandlerRegistry registry) {
//			registry.addResourceHandler("/**")
//					.addResourceLocations("classpath:/static/", "classpath:/images/")
//					.setCachePeriod(0);
//		}
//	}

}
