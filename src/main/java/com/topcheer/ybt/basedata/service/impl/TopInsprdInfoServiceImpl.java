package com.topcheer.ybt.basedata.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.dao.TopInsprdInfoMapper;
import com.topcheer.ybt.basedata.entity.TopInsprdInfo;
import com.topcheer.ybt.basedata.service.ITopInsprdInfoService;


@Service("topInsprdInfoService")
@Transactional
public class TopInsprdInfoServiceImpl implements ITopInsprdInfoService {

	@Autowired
	protected TopInsprdInfoMapper topInsprdInfoMapper;
	
	public PageInfo<TopInsprdInfo> getTopInsPrdInfoList() {
		// TODO Auto-generated method stub
		List<TopInsprdInfo>  topInsprdInfoList = topInsprdInfoMapper.searchAllTopInsprdInfo();
		PageInfo<TopInsprdInfo> pageinfo = new PageInfo<TopInsprdInfo>(topInsprdInfoList);
		return pageinfo;
	}
	
	public PageInfo<TopInsprdInfo> getTopInsPrdInfoByInsPrdCode(String insPrdCode) {
		List<TopInsprdInfo>  topInsprdInfoList = topInsprdInfoMapper.searchTopInsPrdInfoByInsPrdCode(insPrdCode);
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
