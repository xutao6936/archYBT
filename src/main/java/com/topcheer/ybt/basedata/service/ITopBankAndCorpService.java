package com.topcheer.ybt.basedata.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.basedata.entity.TopBankAndCorp;

public interface ITopBankAndCorpService {

	public List<TopBankAndCorp> getTopBankandcorpList(String bankcode);
	
	public TopBankAndCorp getTopBankandcorp(String bankcode);
	
	public List<TopBankAndCorp> searchAll();
	
	public void insert(TopBankAndCorp topBankandcorp);
	
	public void update(TopBankAndCorp topBankandcorp);
	
	public void delete(String id);

	public List<TopBankAndCorp> getCorpByBankCode(String bankCode);

}
