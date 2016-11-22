package com.topcheer.ybt.basedata.biz.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.biz.ITopInsCorpInfoBiz;
import com.topcheer.ybt.basedata.entity.TopInsCorpInfo;
import com.topcheer.ybt.basedata.service.ITopInsCorpInfoService;

@Component
@Service(value = "topInsCorpInfoBizImpl")
public class TopInsCorpInfoBizImpl implements ITopInsCorpInfoBiz {
	private static Logger log = LoggerFactory.getLogger(TopInsCorpInfoBizImpl.class);

	@Resource(name = "topInsCorpInfoService")
	ITopInsCorpInfoService topInsCorpInfoService;

	@Override
	public PageInfo<TopInsCorpInfo> getTopInsCorpInfoList(Map<String, Object> map) {
		return topInsCorpInfoService.getTopInsCorpInfoList(map);
	}

	@Override
	/*public PageInfo<TopInsCorpInfo> getInsCorpByinsCorpCode(String insCorpCode) {
		return topInsCorpInfoService.getInsCorpByinsCorpCode(insCorpCode);
	}*/
	public PageInfo<TopInsCorpInfo> getInsCorpByinsCorpCode(TopInsCorpInfo topInsCorpInfo) {
		log.info("进入BIZ");
		return topInsCorpInfoService.getInsCorpByinsCorpCode(topInsCorpInfo);
	}

	@Override
	public int insertTopInsCorpInfo(TopInsCorpInfo topInsCorpInfo) {
		return topInsCorpInfoService.insertTopInsCorpInfo(topInsCorpInfo);
	}

	@Override
	public int updateTopInsCorpInfo(TopInsCorpInfo topInsCorpInfo) {
		return topInsCorpInfoService.updateTopInsCorpInfo(topInsCorpInfo);
	}

	@Override
	public int deletetTopInsCorpInfo(String topInsCorpInfoCode) {
		return topInsCorpInfoService.deletetTopInsCorpInfo(topInsCorpInfoCode);
	}

	@Override
	public List<TopInsCorpInfo> searchAll() {
		return topInsCorpInfoService.searchAll();
	}

	@Override
	public TopInsCorpInfo getInsCorpByInsCorpCode(String corpCode) {
		return (TopInsCorpInfo) topInsCorpInfoService.getInsCorpByInsCorpCode(corpCode);
	}

	@Override
	public List<TopInsCorpInfo> getInsCorpList(List<String> list) {
		return topInsCorpInfoService.getInsCorpList(list);
	}

	@Override
	public PageInfo<TopInsCorpInfo> getTopInsCorpInfoListByParams(
			Map<String, String> map) {
		return topInsCorpInfoService.getTopInsCorpInfoListByParams(map);
	}

}
