package com.topcheer.ybt.system.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.system.entity.TopUserinfo;

/**
 * @ClassName: ITopUserinfoService
 * @Description:
 * @author XUTAO
 * @date 2016-6-17 上午09:22:50
 * 
 */
public interface ITopUserinfoService {

	public PageInfo<TopUserinfo> searchTopUserinfo(Map<String,Object> searchMap);

	public List<TopUserinfo> getTopUserinfoList(String userId);

	public TopUserinfo getTopUserinfo(String userId);

	public List<TopUserinfo> searchAll();

	public void insert(TopUserinfo topUserinfo);

	public void update(TopUserinfo topUserinfo);

	public void delete(String id);

	public void uploadPath(TopUserinfo topUserinfo);

	public List<TopUserinfo> searchTopUser(Map<String,Object> searchMap);

	public List<TopUserinfo> searchTopUserForLogin(Map searchMap);

}
