package com.ta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.ta"})
public class GetBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetBatchApplication.class, args);
	}

}
