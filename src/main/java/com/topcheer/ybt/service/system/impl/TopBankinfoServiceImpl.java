package com.topcheer.ybt.service.system.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.dao.system.TopBankinfoMapper;
import com.topcheer.ybt.entity.system.TopBankinfo;
import com.topcheer.ybt.service.system.ITopBankinfoService;


@Service("topBankinfoService")

public class TopBankinfoServiceImpl implements ITopBankinfoService{
	
	@Autowired
	protected TopBankinfoMapper topBankinfoMapper;
	
	@Transactional
	public void delete(String id) throws DataAccessException{
		topBankinfoMapper.delete(id);
		
	}

	public List<TopBankinfo> getTopBankinfoList(String bankId)throws DataAccessException {
		return topBankinfoMapper.getTopBankinfo(bankId);
	}
	
	public TopBankinfo getTopBankinfo(String bankId) throws DataAccessException{
		List<TopBankinfo> list = topBankinfoMapper.getTopBankinfo(bankId);
		return list==null||list.size()==0l?null:list.get(0);
	}
	@Transactional
	public void insert(TopBankinfo topBankinfo) throws DataAccessException{
		 topBankinfoMapper.insert(topBankinfo);
	}

	public List<TopBankinfo> searchAll() throws DataAccessException{
		return topBankinfoMapper.searchAll();
	}

	public PageInfo<TopBankinfo> searchTopBankinfo(Map searchMap) throws DataAccessException{
		TopBankinfo topBankinfo = (TopBankinfo) searchMap.get("topBankinfo");
		int pageSize = Integer.parseInt(searchMap.get("pageSize").toString());
		int pageNo = Integer.parseInt(searchMap.get("pageNo").toString());
		PageHelper.startPage(pageNo, pageSize,true, true, true);
		List<TopBankinfo> list = topBankinfoMapper.searchTopBankinfo(topBankinfo);
		PageInfo<TopBankinfo> pageinfo = new PageInfo<TopBankinfo>(list);
		return pageinfo;
	}
	
	@Transactional
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
