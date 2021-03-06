package com.topcheer.ybt.basedata.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.dao.TopInsPrdPeriodInfoMapper;
import com.topcheer.ybt.basedata.entity.TopInsPrdPeriodInfo;
import com.topcheer.ybt.basedata.service.ITopInsPrdPeriodInfoService;
import com.topcheer.ybt.system.entity.TopUserinfo;

@Service("topInsPrdPeriodInfoService")
@Transactional
public class TopInsPrdPeriodInfoServiceimpl implements ITopInsPrdPeriodInfoService {
	
	@Autowired
	protected TopInsPrdPeriodInfoMapper topInsPrdPeriodInfoMapper;

	/**
	 * 查询保障年期信息
	 */
	@Override
	public PageInfo<TopInsPrdPeriodInfo> getInsPrdPeriodAllList(Map<String, Object> map) {
		TopInsPrdPeriodInfo topInsPrdPeriodInfo = (TopInsPrdPeriodInfo) map.get("topInsPrdPeriodInfo");
		int pageSize = Integer.parseInt(map.get("pageSize").toString());
		int pageNo = Integer.parseInt(map.get("pageNo").toString());
		PageHelper.startPage(pageNo, pageSize, true, true, true);
		List<TopInsPrdPeriodInfo>  topInsPeriodInfoList =topInsPrdPeriodInfoMapper.searchAllTopInsPeriodInfo(topInsPrdPeriodInfo);
		PageInfo<TopInsPrdPeriodInfo> pageinfo = new PageInfo<TopInsPrdPeriodInfo>(topInsPeriodInfoList);
		return pageinfo;
	}
	/**
	 * 插入保障年期基本信息
	 */
	@Override
	public void insertInsPrdPeriod(TopInsPrdPeriodInfo topInsPrdPeriodInfo) {
		// TODO Auto-generated method stub
		topInsPrdPeriodInfoMapper.insertTopInsPeriodInfo(topInsPrdPeriodInfo);
	}
	@Override
	public void updateInsPrdPeriod(TopInsPrdPeriodInfo topInsPrdPeriodInfo) {
		// TODO Auto-generated method stub
		topInsPrdPeriodInfoMapper.updateTopInsPeriodInfo(topInsPrdPeriodInfo);
	}
	@Override
	public void deleteInsPrdPeriod(String insPrdCode) {
		// TODO Auto-generated method stub
		topInsPrdPeriodInfoMapper.deleteTopInsPeriodInfo(insPrdCode);
	}
	@Override
	public List getInsPrdPeriodByInsPrdCode(String insPrdCode) {
		return topInsPrdPeriodInfoMapper.getInsPrdPeriodByInsPrdCode(insPrdCode);
	}
	

}
