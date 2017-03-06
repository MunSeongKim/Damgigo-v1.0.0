package com.damgigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DamgigoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DamgigoApplication.class, args);
	}
}
