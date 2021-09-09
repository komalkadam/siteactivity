package com.site.activity.reporting.siteactivity.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import com.site.activity.reporting.siteactivity.SiteactivityApplication;
import com.site.activity.reporting.siteactivity.model.Activity;
import com.site.activity.reporting.siteactivity.service.ActivityReportingService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = { SiteactivityApplication.class })
@AutoConfigureMockMvc( addFilters = false)
@WebMvcTest(ActivityReportingController.class)
class ActivityControllerTest extends AbstractControllerTest {
	
	@MockBean
	ActivityReportingService activityService;

	
	
	@Test
	public void getActivityTest() throws Exception {
		Activity activity = new Activity();
		activity.setValue(16);
		when(activityService.getActivity("learn_from_page")).thenReturn(activity);
		MvcResult result = this.mvc.perform(get("/activity/learn_from_page/total")).andDo(print()).andExpect(status().isOk()).
		andReturn();
		result.equals(activity);
	}
	
	@Test
	public void postActivityTest() throws Exception {
		Activity activity = new Activity();
		activity.setValue(16);
		Activity response = new Activity();
		when(activityService.saveActivity(activity, "learn_from_page")).thenReturn(response);
		MvcResult result = this.mvc.perform(post("/activity/learn_from_page").contentType(MediaType.APPLICATION_JSON)
				.content("{\"value\" : 16}").accept(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk()).
		andReturn();
		result.equals(response);
	}

}
