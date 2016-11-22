package com.topcheer.ybt.system.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.topcheer.ybt.system.dao.TopSequenceMapper;
import com.topcheer.ybt.system.service.ITopSequenceService;

@Service("topSequenceService")
public class TopSequenceImpl implements ITopSequenceService {

	@Autowired
	protected TopSequenceMapper topSequenceMapper;

	@Override
	public String getSequenceByName() {
		return topSequenceMapper.getSequenceByName();
	}


}
