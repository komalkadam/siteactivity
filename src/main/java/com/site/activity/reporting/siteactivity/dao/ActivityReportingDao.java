/**
 * 
 */
package com.site.activity.reporting.siteactivity.dao;

import com.site.activity.reporting.siteactivity.model.Activity;

/**
 * @author kkadam
 *
 */
public interface ActivityReportingDao {
	public Activity getActivity(String activityType);
	
	public Activity saveActivity(Activity activity, String activityName);

}
