package com.topcheer.ybt.basedata.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.entity.TopInsCorpInfo;

public interface ITopInsCorpInfoService {
	//查询保险公司信息
	public PageInfo<TopInsCorpInfo> getTopInsCorpInfoList(Map<String, Object> map);
	//根据保险公司编码查询保险公司信息
	//public PageInfo<TopInsCorpInfo> getInsCorpByinsCorpCode(String insCorpCode);
	public PageInfo<TopInsCorpInfo> getInsCorpByinsCorpCode(TopInsCorpInfo topInsCorpInfo);
	//添加保险公司信息
	public int insertTopInsCorpInfo(TopInsCorpInfo topInsCorpInfo);
	//更新保险公司信息
	public int updateTopInsCorpInfo(TopInsCorpInfo topInsCorpInfo);
	//删除保险公司基本信息
	public int deletetTopInsCorpInfo(String  topInsCorpInfoCode);
	
	public List<TopInsCorpInfo> searchAll();
	
	public TopInsCorpInfo getInsCorpByInsCorpCode(String corpCode);
	public List<TopInsCorpInfo> getInsCorpList(List<String> list);
	
	//根据条件查询保险公司信息
	public PageInfo<TopInsCorpInfo> getTopInsCorpInfoListByParams(
			Map<String, String> map);
	
	public List<TopInsCorpInfo> getInsCompanyNameAjax(String insCorpCode);

}
