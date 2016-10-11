package com.topcheer.ybt.system.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.topcheer.ybt.system.entity.TopBankinfo;

public interface TopBankinfoMapper {

	public List<TopBankinfo> searchTopBankinfo(TopBankinfo topBankinfo) throws DataAccessException;

	public List<TopBankinfo> searchAll() throws DataAccessException;

	public List<TopBankinfo> getTopBankinfo(String bankId) throws DataAccessException;

	public void insert(TopBankinfo topBankinfo) throws DataAccessException;

	public void update(TopBankinfo topBankinfo) throws DataAccessException;

	public void delete(String bankId) throws DataAccessException;

	public List<TopBankinfo> getBankInfoAjax();

}
