package com.topcheer.ybt.basedata.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.topcheer.ybt.basedata.dao.TopInsprdInfoMapper;
import com.topcheer.ybt.basedata.entity.TopInsprdInfo;
import com.topcheer.ybt.basedata.service.ITopInsprdInfoService;
import com.topcheer.ybt.system.entity.TopUserinfo;


@Service("topInsprdInfoService")
@Transactional
public class TopInsprdInfoServiceImpl implements ITopInsprdInfoService {

	@Autowired
	protected TopInsprdInfoMapper topInsprdInfoMapper;
	
	public PageInfo<TopInsprdInfo> getTopInsPrdInfoList(Map<String, Object> map) {
		TopInsprdInfo topInsprdInfo = (TopInsprdInfo) map.get("topInsprdInfo");
		int pageSize = Integer.parseInt(map.get("pageSize").toString());
		int pageNo = Integer.parseInt(map.get("pageNo").toString());
		PageHelper.startPage(pageNo, pageSize, true, true, true);
		List<TopInsprdInfo>  topInsprdInfoList = topInsprdInfoMapper.searchTopInsPrdInfo(topInsprdInfo);
		PageInfo<TopInsprdInfo> pageinfo = new PageInfo<TopInsprdInfo>(topInsprdInfoList);
		return pageinfo;
	}
	
	public PageInfo<TopInsprdInfo> getTopInsPrdInfoByInsPrdCode(String insPrdCode) {
		TopInsprdInfo topInsprdInfo = new TopInsprdInfo();
		topInsprdInfo.setInsPrdCode(insPrdCode);
		List<TopInsprdInfo>  topInsprdInfoList = topInsprdInfoMapper.searchTopInsPrdInfo(topInsprdInfo);
		PageInfo<TopInsprdInfo> pageinfo = new PageInfo<TopInsprdInfo>(topInsprdInfoList);
		return pageinfo;
	}

	public void insertTopInsPrdInfo(TopInsprdInfo topInsprdInfo) {
		topInsprdInfoMapper.insertTopInsPrdInfo(topInsprdInfo);
	}

	public void updateTopInsPrdInfo(TopInsprdInfo topInsprdInfo) {
		topInsprdInfoMapper.updateTopInsPrdInfo(topInsprdInfo);
		
	}

	public void deleteTopInsPrdInfo(String insPrdCode) {
		// TODO Auto-generated method stub
		topInsprdInfoMapper.deleteTopInsPrdInfo(insPrdCode);
	}

	@Override
	public List<TopInsprdInfo> getTopInsPrdInfoListByInsPrdCode(
			String insCorpCode) {
		List<TopInsprdInfo>  topInsprdInfoList = topInsprdInfoMapper.getTopInsPrdInfoListByInsPrdCode(insCorpCode);
		return topInsprdInfoList;
	}
	

}
