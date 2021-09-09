package com.site.activity.reporting.siteactivity;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SiteactivityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiteactivityApplication.class, args);
	}
	
	@Bean
	public Ignite initIgnite() {
		return Ignition.start();
	}

}
