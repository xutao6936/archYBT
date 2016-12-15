package com.topcheer.ybt.basedata.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.dao.TopTemplateMapper;
import com.topcheer.ybt.basedata.entity.TopInsTemplateInfo;
import com.topcheer.ybt.basedata.entity.TopTempInsPrdInfo;
import com.topcheer.ybt.basedata.entity.TopTemplate;
import com.topcheer.ybt.basedata.service.ITopTemplateService;


@Service("topTemplateService")
@Transactional
public class TopTemplateServiceImpl implements ITopTemplateService{
	
	@Autowired
	protected TopTemplateMapper topTemplateMapper;

	public void delete(String id) {
		topTemplateMapper.delete(id);
		
	}

	public List<TopTemplate> getTopTemplateList(String templateid) {
		return topTemplateMapper.getTopTemplate(templateid);
	}
	
	public TopTemplate getTopTemplate(String templateid) {
		List<TopTemplate> list = topTemplateMapper.getTopTemplate(templateid);
		return list==null||list.size()==0l?null:list.get(0);
	}

	public void insert(TopTemplate topTemplate) {
		 topTemplateMapper.insert(topTemplate);
	}

	public List<TopTemplate> searchAll() {
		return topTemplateMapper.searchAll();
	}

	public PageInfo<TopTemplate> searchTopTemplate(Map searchMap) {
		TopTemplate topTemplate = (TopTemplate) searchMap.get("topTemplate");
		int pageSize = Integer.parseInt(searchMap.get("pageSize").toString());
		int pageNo = Integer.parseInt(searchMap.get("pageNo").toString());
		PageHelper.startPage(pageNo, pageSize,true, true, true);
		List<TopTemplate> list = topTemplateMapper.searchTopTemplate(topTemplate);
		PageInfo<TopTemplate> pageinfo = new PageInfo<TopTemplate>(list);
		return pageinfo;
	}

	public void update(TopTemplate TopTemplate) {
		topTemplateMapper.update(TopTemplate);
	}

	public TopTemplateMapper getTopTemplateMapper() {
		return topTemplateMapper;
	}

	public void setTopTemplateMapper(TopTemplateMapper TopTemplateMapper) {
		this.topTemplateMapper = TopTemplateMapper;
	}

	@Override
	public TopTempInsPrdInfo getTopTempInsPrdInfoByInsPrdCode(Map map) {
		TopTempInsPrdInfo topTempInsPrdInfo = topTemplateMapper.getTopTempInsPrdInfoByInsPrdCode(map);
		return topTempInsPrdInfo;
	}

	@Override
	public void deleteTempInsPrdByTempId(String templateId) {
		topTemplateMapper.deleteTempInsPrdByTempId(templateId);
	}

	@Override
	public void insertTempInsPrd(TopTempInsPrdInfo topTempInsPrdInfo) {
		topTemplateMapper.insertTempInsPrd(topTempInsPrdInfo);
	}

	@Override
	public void deleteInsTemplateByTempId(String templateId) {
		topTemplateMapper.deleteInsTemplateByTempId(templateId);
	}

	@Override
	public void insertInsTemplate(TopInsTemplateInfo topInsTemplateInfo) {
		topTemplateMapper.insertInsTemplate(topInsTemplateInfo);
	}

	@Override
	public TopInsTemplateInfo getTopInsTemplateInfo(Map<String, Object> map) {
		TopInsTemplateInfo topInsTemplateInfo = topTemplateMapper.getTopInsTemplateInfo(map);
		return topInsTemplateInfo;
	}

	@Override
	public List<TopTemplate> getTemplateIdAjax(String insCorpCode) {
		return topTemplateMapper.getTemplateIdAjax(insCorpCode);
	}

	@Override
	public List<TopTemplate> getTemplateInfoByTempId(String templateId) {
		return topTemplateMapper.getTopTemplate(templateId);
	}
	
	
	

}
