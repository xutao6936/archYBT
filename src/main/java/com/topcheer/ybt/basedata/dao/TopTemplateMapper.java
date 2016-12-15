package com.topcheer.ybt.basedata.dao;

import java.util.List;
import java.util.Map;

import com.topcheer.ybt.basedata.entity.TopInsTemplateInfo;
import com.topcheer.ybt.basedata.entity.TopTempInsPrdInfo;
import com.topcheer.ybt.basedata.entity.TopTemplate;


public interface TopTemplateMapper {
	
	public List<TopTemplate> searchTopTemplate(TopTemplate topTemplate);
	
	public List<TopTemplate> searchAll();
	
	public List<TopTemplate> getTopTemplate(String templateid);
	
	public void insert(TopTemplate topTemplate);
	
	public void update(TopTemplate topTemplate);
	
	public void delete(String templateid);

	public TopTempInsPrdInfo getTopTempInsPrdInfoByInsPrdCode(Map map);

	public void deleteTempInsPrdByTempId(String templateId);

	public void insertTempInsPrd(TopTempInsPrdInfo topTempInsPrdInfo);

	public void deleteInsTemplateByTempId(String templateId);

	public void insertInsTemplate(TopInsTemplateInfo topInsTemplateInfo);

	public TopInsTemplateInfo getTopInsTemplateInfo(Map<String, Object> map);

	public List<TopTemplate> getTemplateIdAjax(String insCorpCode);

	
}
