package com.player;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.player.controller"})
public class SpringbootbackendemployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootbackendemployeeApplication.class, args);
	}

}
