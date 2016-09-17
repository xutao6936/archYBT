package com.topcheer.ybt.biz.system.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.biz.system.ITopBankinfoBiz;
import com.topcheer.ybt.entity.system.TopBankinfo;
import com.topcheer.ybt.service.system.ITopBankinfoService;

@Component
@Service(value="topBankinfoBizImpl")
public class TopBankinfoBizImpl implements ITopBankinfoBiz{
	
	@Autowired
	@Qualifier("topBankinfoService")
	ITopBankinfoService service;
	public PageInfo<TopBankinfo> searchTopBankinfo(Map searchMap) throws DataAccessException{
		return service.searchTopBankinfo(searchMap);
	}

	public List<TopBankinfo> getTopBankinfoList(String bankCode)throws DataAccessException {
		return service.getTopBankinfoList(bankCode);
	}

	public TopBankinfo getTopBankinfo(String bankCode) throws DataAccessException{
		return service.getTopBankinfo(bankCode);
	}

	public List<TopBankinfo> searchAll()throws DataAccessException {
		return service.searchAll();
	}

	public void insert(TopBankinfo topBankinfo)throws DataAccessException {
		service.insert(topBankinfo);
		
	}

	public void update(TopBankinfo topBankinfo)throws DataAccessException {
		service.update(topBankinfo);
	}

	public void delete(String id) throws DataAccessException{
		service.delete(id);
	}

}
