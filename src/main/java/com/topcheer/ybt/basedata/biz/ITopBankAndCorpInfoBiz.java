package com.topcheer.ybt.basedata.biz;

import java.util.List;

import com.topcheer.ybt.basedata.entity.TopBankAndCorp;

public interface ITopBankAndCorpInfoBiz {
	public List<TopBankAndCorp> getTopBankandcorpList(String bankcode);
	
	public TopBankAndCorp getTopBankandcorp(String bankcode);
	
	public List<TopBankAndCorp> searchAll();
	
	public void insert(TopBankAndCorp topBankandcorp);
	
	public void update(TopBankAndCorp topBankandcorp);
	
	public void delete(String id);

	public List<TopBankAndCorp> getCorpByBankCode(String bankCode);
}
