package com.topcheer.ybt.service.system.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.topcheer.ybt.dao.system.TopBankinfoMapper;
import com.topcheer.ybt.entity.system.TopBankinfo;
import com.topcheer.ybt.service.system.ITopBankinfoService;


@Service("topBankinfoService")
@Transactional
public class TopBankinfoServiceImpl implements ITopBankinfoService{
	
	@Autowired
	protected TopBankinfoMapper topBankinfoMapper;

	public void delete(String id) {
		topBankinfoMapper.delete(id);
		
	}

	public List<TopBankinfo> getTopBankinfoList(String bankCode) {
		return topBankinfoMapper.getTopBankinfo(bankCode);
	}
	
	public TopBankinfo getTopBankinfo(String bankCode) {
		List<TopBankinfo> list = topBankinfoMapper.getTopBankinfo(bankCode);
		return list==null||list.size()==0l?null:list.get(0);
	}

	public void insert(TopBankinfo topBankinfo) {
		 topBankinfoMapper.insert(topBankinfo);
	}

	public List<TopBankinfo> searchAll() {
		return topBankinfoMapper.searchAll();
	}

	public PageInfo<TopBankinfo> searchTopBankinfo(Map searchMap) {
		TopBankinfo topBankinfo = (TopBankinfo) searchMap.get("topBankinfo");
		int pageSize = Integer.parseInt(searchMap.get("pageSize").toString());
		int pageNo = Integer.parseInt(searchMap.get("pageNo").toString());
		PageHelper.startPage(pageNo, pageSize,true, true, true);
		List<TopBankinfo> list = topBankinfoMapper.searchTopBankinfo(topBankinfo);
		PageInfo<TopBankinfo> pageinfo = new PageInfo<TopBankinfo>(list);
		return pageinfo;
	}

	public void update(TopBankinfo TopBankinfo) {
		topBankinfoMapper.update(TopBankinfo);
	}

	public TopBankinfoMapper getTopBankinfoMapper() {
		return topBankinfoMapper;
	}

	public void setTopBankinfoMapper(TopBankinfoMapper TopBankinfoMapper) {
		this.topBankinfoMapper = TopBankinfoMapper;
	}
	
	
	

}
