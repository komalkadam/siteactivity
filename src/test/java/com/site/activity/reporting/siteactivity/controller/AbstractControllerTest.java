package com.site.activity.reporting.siteactivity.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.site.activity.reporting.siteactivity.SiteactivityApplication;

/**
 * Parent class for all test controller.
 * 
 * @author komal
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SiteactivityApplication.class)
@AutoConfigureMockMvc
public abstract class AbstractControllerTest {

	@Autowired
	protected WebApplicationContext context;

	@Autowired
	protected MockMvc mvc;

	/*@Autowired
	protected Filter springSecurityFilterChain;*/

	public void setup() {
	}

}
