/**
 * 
 */
package com.site.activity.reporting.siteactivity.service;

import com.site.activity.reporting.siteactivity.model.Activity;

/**
 * @author kkadam
 *
 */
public interface ActivityReportingService {
	public Activity getActivity(String activityType);

	public Activity saveActivity(Activity activity, String activityType);

}
