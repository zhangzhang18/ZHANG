package com.thesis.cms.service;

import com.thesis.cms.model.Time;

public interface TimeService {

	public Time selectTime();

	public void update(Time time);
	
}
