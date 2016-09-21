package com.topcheer.ybt.basedata.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.dao.TopInsCorpInfoMapper;
import com.topcheer.ybt.basedata.entity.TopInsCorpInfo;
import com.topcheer.ybt.basedata.service.ITopInsCorpInfoService;

@Service("topInsCorpInfoService")
@Transactional
public class TopInsCorpInfoServiceImpl implements ITopInsCorpInfoService {

	@Autowired
	protected TopInsCorpInfoMapper topInsCorpinfoMapper;

	@Override
	public PageInfo<TopInsCorpInfo> getTopInsCorpInfoList() {
		// TODO Auto-generated method stub
		List<TopInsCorpInfo> list = topInsCorpinfoMapper.searchAll();
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
		// TODO Auto-generated method stub
		return topInsCorpinfoMapper.deleteTopInsCorpInfo(topInsCorpInfoCode);
	}

	@Override
	public PageInfo<TopInsCorpInfo> getInsCorpByinsCorpCode(String insCorpCode) {
		// TODO Auto-generated method stub
		List<TopInsCorpInfo> list = topInsCorpinfoMapper.searchByinsCorpCode(insCorpCode);
		PageInfo<TopInsCorpInfo> pageinfo = new PageInfo<TopInsCorpInfo>(list);
		return pageinfo;
	}

}
