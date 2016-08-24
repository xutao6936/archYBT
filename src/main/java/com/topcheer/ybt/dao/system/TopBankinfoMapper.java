package com.topcheer.ybt.dao.system;

import java.util.List;
import java.util.Map;


import com.topcheer.ybt.entity.system.TopBankinfo;


public interface TopBankinfoMapper {
	
	public List<TopBankinfo> searchTopBankinfo(TopBankinfo topBankinfo);
	
	public List<TopBankinfo> searchAll();
	
	public List<TopBankinfo> getTopBankinfo(String bankCode);
	
	public void insert(TopBankinfo topBankinfo);
	
	public void update(TopBankinfo topBankinfo);
	
	public void delete(String bankCode);
	
}
