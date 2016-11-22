package com.topcheer.ybt.basedata.dao;

import java.util.List;

import com.topcheer.ybt.basedata.entity.TopBankAndCorp;


public interface TopBankAndCorpMapper {
	
	public List<TopBankAndCorp> searchAll();
	
	public List<TopBankAndCorp> getTopBankandcorp(String bankcode);
	
	public void insert(TopBankAndCorp topBankandcorp);
	
	public void update(TopBankAndCorp topBankandcorp);
	
	public void delete(String bankcode);

	public List<TopBankAndCorp> getCorpByBankCode(String bankCode);
	
}
