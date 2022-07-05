package com.example.ManagerShoers;

import com.example.ManagerShoers.common.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling

public class ManagerShoersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagerShoersApplication.class, args);
	}

}
