package com.human.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.human.springboot") // 매퍼 인터페이스가 위치한 패키지명
public class UseSoccerApplication {

	public static void main(String[] args) {
		SpringApplication.run(UseSoccerApplication.class, args);
	}

}
