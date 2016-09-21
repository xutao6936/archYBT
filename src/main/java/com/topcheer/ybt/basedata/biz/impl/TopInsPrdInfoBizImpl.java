package com.topcheer.ybt.basedata.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.biz.ITopInsPrdInfoBiz;
import com.topcheer.ybt.basedata.entity.TopInsprdInfo;
import com.topcheer.ybt.basedata.service.ITopInsprdInfoService;

@Component
@Service(value="topInsPrdInfoBizImpl")
public class TopInsPrdInfoBizImpl implements ITopInsPrdInfoBiz{
	
	@Autowired
	ITopInsprdInfoService topInsprdInfoService;

	@Override
	public PageInfo<TopInsprdInfo> getTopInsPrdInfoList() {
		// TODO Auto-generated method stub
		return topInsprdInfoService.getTopInsPrdInfoList();
	}

	@Override
	public PageInfo<TopInsprdInfo> getTopInsPrdInfoByInsPrdCode(
			String insPrdCode) {
		// TODO Auto-generated method stub
		return topInsprdInfoService.getTopInsPrdInfoByInsPrdCode(insPrdCode);
	}

	@Override
	public void insertTopInsPrdInfo(TopInsprdInfo topInsprdInfo) {
		// TODO Auto-generated method stub
		topInsprdInfoService.insertTopInsPrdInfo(topInsprdInfo);
	}

	@Override
	public void updateTopInsPrdInfo(TopInsprdInfo topInsprdInfo) {
		// TODO Auto-generated method stub
		topInsprdInfoService.updateTopInsPrdInfo(topInsprdInfo);
	}

	@Override
	public void deleteTopInsPrdInfo(String topInsPrdInfo) {
		// TODO Auto-generated method stub
		topInsprdInfoService.deleteTopInsPrdInfo(topInsPrdInfo);
	}

}
