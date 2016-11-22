package com.topcheer.ybt.basedata.dao;

import java.util.List;
import java.util.Map;

import com.topcheer.ybt.basedata.entity.TopInsCorpInfo;



public interface TopInsCorpInfoMapper {
	public List<TopInsCorpInfo> searchAll();
	
	//public List<TopInsCorpInfo> searchByinsCorpCode(String  insCorpCode);
	public List<TopInsCorpInfo> searchInsCorpInfo(TopInsCorpInfo topInsCorpInfo);
	
	public int  insertTopInsCorpInfo(TopInsCorpInfo topInsCorpInfo);
	
	public int  updateTopInsCorpInfo(TopInsCorpInfo topInsCorpInfo);
	
	public int  deleteTopInsCorpInfo(String topInsCorpInfoCode);

	public TopInsCorpInfo getInsCorpByInsCorpCode(String corpCode);

	public List<TopInsCorpInfo> getInsCorpList(List<String> list);

	public List<TopInsCorpInfo> getTopInsCorpInfoList(Map<String, String> map2);

	public List<TopInsCorpInfo> getTopInsCorpInfoListByParams(
			Map<String, String> map2);

}
