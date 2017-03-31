package com.thesis.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thesis.cms.dao.TimeMapper;
import com.thesis.cms.model.Time;
import com.thesis.cms.service.TimeService;

@Service
@Transactional
public class TimeServiceimpl implements TimeService {

	
	@Autowired
	private TimeMapper timeMapper;
	
	
	@Override
	public Time selectTime() {
		return timeMapper.selectTime();
	}


	@Override
	public void update(Time time) {
		timeMapper. update(time);		
	}

}
