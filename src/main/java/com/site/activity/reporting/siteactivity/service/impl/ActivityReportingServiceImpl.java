/**
 * 
 */
package com.site.activity.reporting.siteactivity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.activity.reporting.siteactivity.dao.ActivityReportingDao;
import com.site.activity.reporting.siteactivity.model.Activity;
import com.site.activity.reporting.siteactivity.service.ActivityReportingService;

/**
 * @author kkadam
 *
 */
@Service
public class ActivityReportingServiceImpl implements ActivityReportingService{
	
	@Autowired
	ActivityReportingDao activityDao;

	@Override
	public Activity getActivity(String activityType) {
		return activityDao.getActivity(activityType);
	}

	@Override
	public Activity saveActivity(Activity activity, String activityType) {
		return activityDao.saveActivity(activity, activityType);
	}

}
