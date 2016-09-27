package com.topcheer.ybt.basedata.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.biz.ITopInsCorpInfoBiz;
import com.topcheer.ybt.basedata.controller.TopInsCorpInfoController;
import com.topcheer.ybt.basedata.entity.TopInsCorpInfo;
import com.topcheer.ybt.basedata.service.ITopInsCorpInfoService;

@Component
@Service(value = "topInsCorpInfoBizImpl")
public class TopInsCorpInfoBizImpl implements ITopInsCorpInfoBiz {
	private static Logger log = LoggerFactory.getLogger(TopInsCorpInfoBizImpl.class);

	@Resource(name = "topInsCorpInfoService")
	ITopInsCorpInfoService topInsCorpInfoService;

	@Override
	public PageInfo<TopInsCorpInfo> getTopInsCorpInfoList() {
		// TODO Auto-generated method stub
		return topInsCorpInfoService.getTopInsCorpInfoList();
	}

	@Override
	/*public PageInfo<TopInsCorpInfo> getInsCorpByinsCorpCode(String insCorpCode) {
		// TODO Auto-generated method stub
		return topInsCorpInfoService.getInsCorpByinsCorpCode(insCorpCode);
	}*/
	public PageInfo<TopInsCorpInfo> getInsCorpByinsCorpCode(TopInsCorpInfo topInsCorpInfo) {
		// TODO Auto-generated method stub
		log.info("进入BIZ");
		return topInsCorpInfoService.getInsCorpByinsCorpCode(topInsCorpInfo);
	}

	@Override
	public int insertTopInsCorpInfo(TopInsCorpInfo topInsCorpInfo) {
		// TODO Auto-generated method stub
		return topInsCorpInfoService.insertTopInsCorpInfo(topInsCorpInfo);
	}

	@Override
	public int updateTopInsCorpInfo(TopInsCorpInfo topInsCorpInfo) {
		// TODO Auto-generated method stub
		return topInsCorpInfoService.updateTopInsCorpInfo(topInsCorpInfo);
	}

	@Override
	public int deletetTopInsCorpInfo(String topInsCorpInfoCode) {
		// TODO Auto-generated method stub
		return topInsCorpInfoService.deletetTopInsCorpInfo(topInsCorpInfoCode);
	}

	@Override
	public List<TopInsCorpInfo> searchAll() {
		return topInsCorpInfoService.searchAll();
	}

}
