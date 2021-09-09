/**
 * 
 */
package com.site.activity.reporting.siteactivity.dao.impl;

import java.util.Iterator;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.cache.Cache.Entry;
import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.configuration.CacheConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.activity.reporting.siteactivity.dao.ActivityReportingDao;
import com.site.activity.reporting.siteactivity.model.Activity;
import com.site.activity.reporting.siteactivity.model.ActivityTimestamp;

/**
 * @author kkadam
 *
 */
@Service
public class ActivityReportingDaoImpl implements ActivityReportingDao {
	
	@Autowired
	Ignite ignite;
		
	

	@Override
	public Activity getActivity(String activityType) {
		IgniteCache<String, ActivityTimestamp> cache = getOrCreateCache(activityType);
		
		int count = 0;
		if (cache != null) {
			Iterator<Entry<String, ActivityTimestamp>> iterator = cache.iterator();
			while (iterator.hasNext()) {
				Entry<String, ActivityTimestamp> activityTimestampEntry = iterator.next();
				ActivityTimestamp value = activityTimestampEntry.getValue();
				count = count + value.getValue();
			}
		}
		Activity activity = new Activity();
		activity.setValue(count);
		
		return activity;
	}

	@Override
	public Activity saveActivity(Activity activity, String activityType) {
		IgniteCache<String, ActivityTimestamp> cache = getOrCreateCache(activityType);
		ActivityTimestamp activityTimestamp = new ActivityTimestamp();
		activityTimestamp.setActivityName(activityType);
		activityTimestamp.setTimestamp(System.currentTimeMillis());
		activityTimestamp.setValue(activity.getValue());
		cache.put(UUID.randomUUID().toString(), activityTimestamp);
		return activity;
	}
	
	private IgniteCache<String, ActivityTimestamp> getOrCreateCache(String activityName){
		CacheConfiguration<String, ActivityTimestamp> cacheConfigurationActivityTimestamp = new CacheConfiguration<String, ActivityTimestamp>();
		cacheConfigurationActivityTimestamp.setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(new Duration(TimeUnit.HOURS, 12)));
		cacheConfigurationActivityTimestamp.setName(activityName);
		return ignite.getOrCreateCache(cacheConfigurationActivityTimestamp);
	}

}
