package com.topcheer.ybt.dao.system;

import java.util.List;

import com.topcheer.ybt.entity.system.TopUserinfo;



/** 
* @ClassName: TopUserinfoMapper 
* @Description: 
* @author XUTAO 
* @date 2016-6-17 上午09:19:19 
*  
*/
public interface TopUserinfoMapper {
	
	public List<TopUserinfo> searchTopUserinfo(TopUserinfo userInfo);
	
	public List<TopUserinfo> searchTopUserinfoForLogin(TopUserinfo userInfo);
	
	public List<TopUserinfo> searchAll();
	
	public List<TopUserinfo> getTopUserinfo(String userId);
	
	public void insert(TopUserinfo topUserinfo);
	
	public void updateByPrimaryKeySelective(TopUserinfo topUserinfo);
	
	public void delete(String userId);
	
	public void uploadPath(TopUserinfo topUserinfo);
	
}
