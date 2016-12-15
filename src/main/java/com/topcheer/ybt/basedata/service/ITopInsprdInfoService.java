package com.topcheer.ybt.basedata.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.entity.TopInsprdInfo;

public interface ITopInsprdInfoService {
	//取得保险产品基本信息表数据
	public PageInfo<TopInsprdInfo> getTopInsPrdInfoList(Map<String, Object> map);
	
	//根据保险产品编码查询基本信息
	public  PageInfo<TopInsprdInfo> getTopInsPrdInfoByInsPrdCode(String insPrdCode);
	
	//向保险产品基本信息表中插入数据
	public void  insertTopInsPrdInfo(TopInsprdInfo topInsprdInfo);
	
	//更新保险产品基本信息表
	public void  updateTopInsPrdInfo(TopInsprdInfo topInsprdInfo);
	
	//删除产品基本信息表
	public  void  deleteTopInsPrdInfo(String  insPrdCode);
	
	//根据保险公司代码查询出该保险公司下所有的保险产品
	public List <TopInsprdInfo> getTopInsPrdInfoListByInsPrdCode(String insCorpCode);

	public List<TopInsprdInfo> getInsPrdInfoByInsPrdCode(String insPrdCode);

	public PageInfo<TopInsprdInfo> getTopInsPrdInfoListByParams(
			Map<String, String> map);

	public List<TopInsprdInfo> getInsPrdInfoByInsCorpCode(String insCorpCode);

}
