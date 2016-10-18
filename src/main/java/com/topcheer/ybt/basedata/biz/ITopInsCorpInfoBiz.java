package com.topcheer.ybt.basedata.biz;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.entity.TopInsCorpInfo;

public interface ITopInsCorpInfoBiz {
	//查询保险公司详细信息
	public PageInfo<TopInsCorpInfo> getTopInsCorpInfoList(Map<String, Object> map);

	//根据保险公司编码查询保险公司信息
//	public PageInfo<TopInsCorpInfo> getInsCorpByinsCorpCode(String insCorpCode);
	
	public PageInfo<TopInsCorpInfo> getInsCorpByinsCorpCode(TopInsCorpInfo topInsCorpInfo);
	
	
	//添加保险公司信息
	public int insertTopInsCorpInfo(TopInsCorpInfo topInsCorpInfo);
	
	//更新保险公司信息
	public int updateTopInsCorpInfo(TopInsCorpInfo topInsCorpInfo);
	
	//根据保险公司编码删除保险公司信息
	public int deletetTopInsCorpInfo(String  topInsCorpInfoCode);

	public List<TopInsCorpInfo> searchAll();

}
