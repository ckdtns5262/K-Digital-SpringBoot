package com.mission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Mission1Application {

	public static void main(String[] args) {
		//SpringApplication.run(Chapter01Application.class, args);
		SpringApplication application = new SpringApplication(Mission1Application.class);
		application.setWebApplicationType(WebApplicationType.SERVLET);
		application.run(args); // run  톰캣 구동
		
		System.out.println("완료^^");
	}

}

