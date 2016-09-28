package com.topcheer.ybt.basedata.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.dao.TopInsPrdPeriodInfoMapper;
import com.topcheer.ybt.basedata.entity.TopInsPrdPeriodInfo;
import com.topcheer.ybt.basedata.service.ITopInsPrdPeriodInfoService;

@Service("topInsPrdPeriodInfoService")
@Transactional
public class TopInsPrdPeriodInfoServiceimpl implements ITopInsPrdPeriodInfoService {
	
	@Autowired
	protected TopInsPrdPeriodInfoMapper topInsPrdPeriodInfoMapper;

	@Override
	public PageInfo<TopInsPrdPeriodInfo> getInsPrdPeriodAllList() {
		// TODO Auto-generated method stub
		List<TopInsPrdPeriodInfo>  topInsPeriodInfoList =topInsPrdPeriodInfoMapper.searchAllTopInsPeriodInfo();
		PageInfo<TopInsPrdPeriodInfo> pageinfo = new PageInfo<TopInsPrdPeriodInfo>(topInsPeriodInfoList);
		return pageinfo;
	}

}
