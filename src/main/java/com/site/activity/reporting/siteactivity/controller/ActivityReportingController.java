/**
 * 
 */
package com.site.activity.reporting.siteactivity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.site.activity.reporting.siteactivity.model.Activity;
import com.site.activity.reporting.siteactivity.service.ActivityReportingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author kkadam
 *
 */
@RestController
@RequestMapping("/activity")
@Api(value = "ActivityController", description = "Activity controller API", consumes = "application/json", produces = "application/json")
public class ActivityReportingController {
	@Autowired
	ActivityReportingService activityService;

	@GetMapping("/{key}/total")
	@ApiOperation(value = "Get Activity Total", notes = "Get Activity Total", response = Activity.class)
	public Activity getActivityTotal(@PathVariable("key") String key) {
		return activityService.getActivity(key);
	}

	@PostMapping("/{key}")
	@ResponseBody
	@ApiOperation(value = "Save activity", notes = "Save activity", response = Activity.class)
	public Activity saveActivity(@PathVariable("key") String key, @RequestBody Activity activity) {
		activityService.saveActivity(activity, key);
		return new Activity();
	}

}
