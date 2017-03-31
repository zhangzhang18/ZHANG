package com.thesis.cms.dao;

import com.thesis.cms.model.Time;
import com.thesis.cms.model.TimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeMapper {
	int countByExample(TimeExample example);

	int deleteByExample(TimeExample example);

	int insert(Time record);

	int insertSelective(Time record);

	List<Time> selectByExample(TimeExample example);

	int updateByExampleSelective(@Param("record") Time record,
			@Param("example") TimeExample example);

	int updateByExample(@Param("record") Time record,
			@Param("example") TimeExample example);

	Time selectTime();

	void update(Time time);
}