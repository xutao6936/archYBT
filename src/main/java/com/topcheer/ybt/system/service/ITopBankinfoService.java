package com.topcheer.ybt.system.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.system.entity.TopBankinfo;

public interface ITopBankinfoService {

	public PageInfo<TopBankinfo> searchTopBankinfo(Map searchMap) throws DataAccessException;

	public List<TopBankinfo> getTopBankinfoList(String bankCode) throws DataAccessException;

	public TopBankinfo getTopBankinfo(String bankCode) throws DataAccessException;

	public List<TopBankinfo> searchAll() throws DataAccessException;

	public void insert(TopBankinfo topBankinfo) throws DataAccessException;

	public void update(TopBankinfo topBankinfo) throws DataAccessException;

	public void delete(String id) throws DataAccessException;

	public List<TopBankinfo> getBankInfoAjax();

}
