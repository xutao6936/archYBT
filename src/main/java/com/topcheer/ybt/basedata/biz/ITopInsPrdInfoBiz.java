package com.topcheer.ybt.basedata.biz;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.entity.TopInsprdInfo;

public interface ITopInsPrdInfoBiz {
	

		public PageInfo<TopInsprdInfo> getTopInsPrdInfoList(Map<String, Object> map);

	    //取得保险产品基本信息表数据
		public PageInfo<TopInsprdInfo> getTopInsPrdInfoList();
		
		//根据保险产品编码查询基本信息
		public  PageInfo<TopInsprdInfo> getTopInsPrdInfoByInsPrdCode(String insPrdCode);
		
		//根据保险产品编码查询基本信息
		public  List<TopInsprdInfo> getInsPrdInfoByInsPrdCode(String insPrdCode);
		
		//向保险产品基本信息表中插入数据
		public void  insertTopInsPrdInfo(TopInsprdInfo topInsprdInfo);
		
		//更新保险产品基本信息表
		public void  updateTopInsPrdInfo(TopInsprdInfo topInsprdInfo);
		
		//删除产品基本信息表
		public  void  deleteTopInsPrdInfo(String   insPrdCode);

		public List<TopInsprdInfo> getTopInsPrdInfoListByInsPrdCode(
				String insCorpCode);
		
		//根据条件查询保险产品信息
		public PageInfo<TopInsprdInfo> getTopInsPrdInfoListByParams(
				Map<String, String> map);
		
}
