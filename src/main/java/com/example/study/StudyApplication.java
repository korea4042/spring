package com.example.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyApplication {

	public static void main(String[] args) {
		Hello hello = new Hello();
		hello.setHello("Hello");
		String data = hello.getHello();
		System.out.println(data);
		SpringApplication.run(StudyApplication.class, args);

	}

}
