package com.topcheer.ybt.dao.system;

import java.util.List;
import java.util.Map;



import org.springframework.dao.DataAccessException;

import com.topcheer.ybt.entity.system.TopBankinfo;


public interface TopBankinfoMapper {
	
	public List<TopBankinfo> searchTopBankinfo(TopBankinfo topBankinfo)throws DataAccessException;
	
	public List<TopBankinfo> searchAll()throws DataAccessException;
	
	public List<TopBankinfo> getTopBankinfo(String bankId)throws DataAccessException;
	
	public void insert(TopBankinfo topBankinfo)throws DataAccessException;
	
	public void update(TopBankinfo topBankinfo)throws DataAccessException;
	
	public void delete(String bankId)throws DataAccessException;
	
}
