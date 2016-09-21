package com.topcheer.ybt.basedata.dao;

import java.util.List;

import com.topcheer.ybt.basedata.entity.TopInsCorpInfo;



public interface TopInsCorpInfoMapper {
	public List<TopInsCorpInfo> searchAll();
	
	public List<TopInsCorpInfo> searchByinsCorpCode(String  insCorpCode);
	
	public int  insertTopInsCorpInfo(TopInsCorpInfo topInsCorpInfo);
	
	public int  updateTopInsCorpInfo(TopInsCorpInfo topInsCorpInfo);
	
	public int  deleteTopInsCorpInfo(String topInsCorpInfoCode);

}
