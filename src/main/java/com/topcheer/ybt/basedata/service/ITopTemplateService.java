package com.topcheer.ybt.basedata.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.entity.TopInsTemplateInfo;
import com.topcheer.ybt.basedata.entity.TopTempInsPrdInfo;
import com.topcheer.ybt.basedata.entity.TopTemplate;

public interface ITopTemplateService {
	
	public PageInfo<TopTemplate> searchTopTemplate(Map searchMap);
	
	public List<TopTemplate> getTopTemplateList(String templateid);
	
	public TopTemplate getTopTemplate(String templateid);
	
	public List<TopTemplate> searchAll();
	
	public void insert(TopTemplate topTemplate);
	
	public void update(TopTemplate topTemplate);
	
	public void delete(String id);

	public TopTempInsPrdInfo getTopTempInsPrdInfoByInsPrdCode(Map map);

	//根据产品库编码删除产品库绑定保险产品信息
	public void deleteTempInsPrdByTempId(String templateId);
	
	//产品库绑定保险产品信息
	public void insertTempInsPrd(TopTempInsPrdInfo topTempInsPrdInfo);

	//根据产品库编码删除产品库绑定的保险公司
	public void deleteInsTemplateByTempId(String templateId);

	public void insertInsTemplate(TopInsTemplateInfo topInsTemplateInfo);

	public TopInsTemplateInfo getTopInsTemplateInfo(Map<String, Object> map);

	public List<TopTemplate> getTemplateIdAjax(String insCorpCode);

	public List<TopTemplate> getTemplateInfoByTempId(String templateId);


}
