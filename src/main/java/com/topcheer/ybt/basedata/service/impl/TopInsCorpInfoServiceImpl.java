package com.topcheer.ybt.basedata.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.dao.TopInsCorpInfoMapper;
import com.topcheer.ybt.basedata.entity.TopInsCorpInfo;
import com.topcheer.ybt.basedata.entity.TopInsprdInfo;
import com.topcheer.ybt.basedata.service.ITopInsCorpInfoService;

@Service("topInsCorpInfoService")
@Transactional
public class TopInsCorpInfoServiceImpl implements ITopInsCorpInfoService {
	private static Logger log = LoggerFactory.getLogger(TopInsCorpInfoServiceImpl.class);
	@Autowired
	protected TopInsCorpInfoMapper topInsCorpinfoMapper;

	@Override
	public PageInfo<TopInsCorpInfo> getTopInsCorpInfoList(Map<String, Object> map) {
		TopInsCorpInfo topInsCorpInfo = (TopInsCorpInfo) map.get("topInsCorpInfo");
		int pageSize = Integer.parseInt(map.get("pageSize").toString());
		int pageNo = Integer.parseInt(map.get("pageNo").toString());
		PageHelper.startPage(pageNo, pageSize, true, true, true);
		List<TopInsCorpInfo> list = topInsCorpinfoMapper.searchInsCorpInfo(topInsCorpInfo);
		PageInfo<TopInsCorpInfo> pageinfo = new PageInfo<TopInsCorpInfo>(list);
		return pageinfo;
	}

	@Override
	public int insertTopInsCorpInfo(TopInsCorpInfo topInsCorpInfo) {
		// TODO Auto-generated method stub
		return topInsCorpinfoMapper.insertTopInsCorpInfo(topInsCorpInfo);
	}

	@Override
	public int updateTopInsCorpInfo(TopInsCorpInfo topInsCorpInfo) {
		// TODO Auto-generated method stub
		return topInsCorpinfoMapper.updateTopInsCorpInfo(topInsCorpInfo);
	}

	@Override
	public int deletetTopInsCorpInfo(String topInsCorpInfoCode) {
		return topInsCorpinfoMapper.deleteTopInsCorpInfo(topInsCorpInfoCode);
	}

	@Override
	public PageInfo<TopInsCorpInfo> getInsCorpByinsCorpCode(TopInsCorpInfo topInsCorpInfo) {
		// TODO Auto-generated method stub
		log.info("进入Service"+topInsCorpInfo.getInsCorpCode());
		
		List<TopInsCorpInfo> list = topInsCorpinfoMapper.searchInsCorpInfo(topInsCorpInfo);
		PageInfo<TopInsCorpInfo> pageinfo = new PageInfo<TopInsCorpInfo>(list);
		return pageinfo;
	}

	@Override
	public List <TopInsCorpInfo> searchAll() {
		List <TopInsCorpInfo> list = topInsCorpinfoMapper.searchAll();
		return list;
	}

}
