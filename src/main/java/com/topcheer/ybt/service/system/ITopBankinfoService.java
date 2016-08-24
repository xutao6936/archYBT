package com.topcheer.ybt.service.system;

import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageInfo;

import com.topcheer.ybt.entity.system.TopBankinfo;
public interface ITopBankinfoService {
	
	public PageInfo<TopBankinfo> searchTopBankinfo(Map searchMap);
	
	public List<TopBankinfo> getTopBankinfoList(String bankCode);
	
	public TopBankinfo getTopBankinfo(String bankCode);
	
	public List<TopBankinfo> searchAll();
	
	public void insert(TopBankinfo topBankinfo);
	
	public void update(TopBankinfo topBankinfo);
	
	public void delete(String id);

}
