package com.topcheer.ybt.basedata.dao;

import java.util.List;

import com.topcheer.ybt.basedata.entity.TopInsprdInfo;


public interface TopInsprdInfoMapper {
	//查询保险产品基本信息表所有数据
	public List<TopInsprdInfo> searchAllTopInsprdInfo();
	
	//根据保险产品编码查询基本信息
	public List<TopInsprdInfo> searchTopInsPrdInfoByInsPrdCode(String insPrdCode);
	
	//插入数据
	public void insertTopInsPrdInfo(TopInsprdInfo topInsprdInfo);
	
	//更新数据
	public void updateTopInsPrdInfo(TopInsprdInfo topInsprdInfo);
	
	//数据删除
	public void deleteTopInsPrdInfo(String insprdCode);

	//根据保险公司代码查询出该保险公司下所有的保险产品
	public List<TopInsprdInfo> getTopInsPrdInfoListByInsPrdCode(
			String insCorpCode);

}
