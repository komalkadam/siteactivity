package com.site.activity.reporting.siteactivity;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.site.activity.reporting.siteactivity.controller.ActivityReportingController;

@SpringBootTest
class SiteactivityApplicationTests {
	@Autowired
	private ActivityReportingController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
