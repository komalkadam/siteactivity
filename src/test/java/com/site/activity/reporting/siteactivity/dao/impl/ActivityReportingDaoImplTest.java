/**
 * 
 */
package com.site.activity.reporting.siteactivity.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.site.activity.reporting.siteactivity.SiteactivityApplication;
import com.site.activity.reporting.siteactivity.dao.ActivityReportingDao;
import com.site.activity.reporting.siteactivity.model.Activity;

/**
 * @author kkadam
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = SiteactivityApplication.class)
class ActivityReportingDaoImplTest {
	@Autowired 
	ActivityReportingDao dao;

	@Test
	void saveActivityTotal() {
		Activity activity1 = new Activity();
		activity1.setValue(16);
		Activity activity2 = new Activity();
		activity2.setValue(10);
		dao.saveActivity(activity1, "learn_from_page");
		dao.saveActivity(activity2, "learn_from_page");
		Activity activity = new Activity();
		activity.setValue(26);
		Activity response1 = dao.getActivity("learn_from_page");
		assertNotNull(response1);
		assertEquals(response1, activity);
	}

}
