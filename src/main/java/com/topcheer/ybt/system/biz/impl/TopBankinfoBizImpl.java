package com.topcheer.ybt.system.biz.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.system.biz.ITopBankinfoBiz;
import com.topcheer.ybt.system.entity.TopBankinfo;
import com.topcheer.ybt.system.service.ITopBankinfoService;

@Component
@Service(value = "topBankinfoBizImpl")
public class TopBankinfoBizImpl implements ITopBankinfoBiz {

	@Resource(name = "topBankinfoService")
	ITopBankinfoService service;

	public PageInfo<TopBankinfo> searchTopBankinfo(Map searchMap) throws DataAccessException {
		return service.searchTopBankinfo(searchMap);
	}

	public List<TopBankinfo> getTopBankinfoList(String bankCode) throws DataAccessException {
		return service.getTopBankinfoList(bankCode);
	}

	public TopBankinfo getTopBankinfo(String bankCode) throws DataAccessException {
		return service.getTopBankinfo(bankCode);
	}

	public List<TopBankinfo> searchAll() throws DataAccessException {
		return service.searchAll();
	}

	public void insert(TopBankinfo topBankinfo) throws DataAccessException {
		service.insert(topBankinfo);

	}

	public void update(TopBankinfo topBankinfo) throws DataAccessException {
		service.update(topBankinfo);
	}

	public void delete(String id) throws DataAccessException {
		service.delete(id);
	}

	@Override
	public List<TopBankinfo> getBankInfoAjax() {
		return service.getBankInfoAjax();
	}

}
