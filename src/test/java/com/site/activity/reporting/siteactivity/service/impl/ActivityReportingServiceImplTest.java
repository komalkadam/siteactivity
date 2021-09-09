package com.site.activity.reporting.siteactivity.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.site.activity.reporting.siteactivity.SiteactivityApplication;
import com.site.activity.reporting.siteactivity.dao.ActivityReportingDao;
import com.site.activity.reporting.siteactivity.model.Activity;
import com.site.activity.reporting.siteactivity.service.ActivityReportingService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SiteactivityApplication.class)
class ActivityReportingServiceImplTest {
	
	@Autowired
	private ActivityReportingService activityService;

	@MockBean
	private ActivityReportingDao activityDao;
	

	@Test
	void getActivityTotal() {
		Activity activity1 = new Activity();
		activity1.setValue(16);
		doReturn(activity1).when(activityDao).getActivity("learn_from_page");
		Activity response1 = activityService.getActivity("learn_from_page");
		assertNotNull(response1);
		assertEquals(response1, activity1);
	}
	
	@Test
	void saveActivity() {
		Activity activity1 = new Activity();
		activity1.setValue(16);
		doReturn(activity1).when(activityDao).saveActivity(activity1, "learn_from_page");
		Activity response1 = activityService.saveActivity(activity1, "learn_from_page");
		assertNotNull(response1);
		assertEquals(response1, activity1);
	}

}
