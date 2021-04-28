package com.sdqi2021.AQMS;

import com.sdqi2021.AQMS.model.User;
import com.sdqi2021.AQMS.repo.UserRepo;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class AqmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AqmsApplication.class, args);
	}

	@Bean
	public ApplicationRunner initializer(UserRepo userRepo) {
		return args -> userRepo.saveAll(Arrays.asList(User.builder()
				.id(1)
				.username("admin")
				.email("admin@gmail.com")
				.password("$2a$10$jAEf7ZvYL41BKIC3W.na7./SmPFuB2xsEknOxuvE/QEixox6lsMDC")
				.active(true)
				.role("ROLE_ADMIN")
				.build()));
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

//	@Bean
//	public ApplicationRunner initializer(RoleRepo roleRepo) {
//		return args -> roleRepo.saveAll(Arrays.asList(Role.builder().id(1).name("ROLE_ADMIN").build(),
//				Role.builder().id(2).name("ROLE_USER").build()));
//	}



	//insert into User (username, email, password, active, role) values
	// ('admin', 'admin@gmail.com', '$2a$10$jAEf7ZvYL41BKIC3W.na7./SmPFuB2xsEknOxuvE/QEixox6lsMDC', true, 'ROLE_ADMIN');

}
