package com.topcheer.ybt.basedata.dao;

import java.util.List;

import com.topcheer.ybt.basedata.entity.TopBfyInfo;
import com.topcheer.ybt.basedata.entity.TopBuyInfo;
import com.topcheer.ybt.basedata.entity.TopBuyInfoAdd;
import com.topcheer.ybt.basedata.entity.TopPhInfo;
import com.topcheer.ybt.basedata.entity.TopRnInfo;
import com.topcheer.ybt.basedata.entity.TopSpecialInfo;


public interface TopTradeInfoMapper {
	
	//插入数据
	public void insertBaseInfo(TopBuyInfo topBuyInfo);
	
	public void updateBuyInfo(TopBuyInfo topBuyInfo);
	
	public void  insertPhInfo(TopPhInfo topPhInfo);
	
	public void  insertRnInfo(TopRnInfo topRnInfo);
	
	public void  insertBfyInfo(TopBfyInfo topBfyInfo);
	
	public void  insertSpecialInfo(TopSpecialInfo topBfyInfo);
	
	public void  insertBuyInfoAddInfo(TopBuyInfoAdd topBfyInfo);
	

	public List<TopBuyInfo> selectBaseInfo(String serialno);
	

}
