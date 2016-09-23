package com.topcheer.ybt.system.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.topcheer.ybt.system.dao.TopUserRoleMapper;
import com.topcheer.ybt.system.dao.TopUserinfoMapper;
import com.topcheer.ybt.system.entity.TopUserinfo;
import com.topcheer.ybt.system.service.ITopUserinfoService;

/**
 * @ClassName: TopUserinfoServiceImpl
 * @Description:
 * @author XUTAO
 * @date 2016-6-17 上午09:23:20
 * 
 */
@Service("topUserinfoService")
public class TopUserinfoServiceImpl implements ITopUserinfoService {

	@Autowired
	protected TopUserinfoMapper topUserinfoMapper;
	
	@Autowired
	private TopUserRoleMapper topUserRoleMapper;

	@Transactional
	public void delete(String id) {
		try {
			topUserRoleMapper.deleteByUserId(id);
			topUserinfoMapper.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("删除用户数据库出现异常，事务回滚...",e.getCause());
		}

	}

	public void uploadPath(TopUserinfo topUserinfo) {
		topUserinfoMapper.updateByPrimaryKeySelective(topUserinfo);

	}

	public List<TopUserinfo> getTopUserinfoList(String userId) {
		return topUserinfoMapper.getTopUserinfo(userId);
	}

	public TopUserinfo getTopUserinfo(String userId) {
		List<TopUserinfo> list = topUserinfoMapper.getTopUserinfo(userId);
		return (list == null) || (list.size() == 0l) ? null : list.get(0);
	}

	public void insert(TopUserinfo topUserinfo) {
		topUserinfoMapper.insert(topUserinfo);
	}

	public List<TopUserinfo> searchAll() {
		return topUserinfoMapper.searchAll();
	}

	public List<TopUserinfo> searchTopUser(Map<String,Object> searchMap) {
		TopUserinfo userInfo = (TopUserinfo) searchMap.get("userInfo");
		return topUserinfoMapper.searchTopUserinfo(userInfo);
	}

	public PageInfo<TopUserinfo> searchTopUserinfo(Map<String,Object> searchMap) {
		TopUserinfo userInfo = (TopUserinfo) searchMap.get("userInfo");
		int pageSize = Integer.parseInt(searchMap.get("pageSize").toString());
		int pageNo = Integer.parseInt(searchMap.get("pageNo").toString());
		PageHelper.startPage(pageNo, pageSize, true, true, true);
		List<TopUserinfo> list = topUserinfoMapper.searchTopUserinfo(userInfo);
		PageInfo<TopUserinfo> pageinfo = new PageInfo<TopUserinfo>(list);
		return pageinfo;
	}

	public void update(TopUserinfo TopUserinfo) {
		topUserinfoMapper.updateByPrimaryKeySelective(TopUserinfo);
	}

	public TopUserinfoMapper getTopUserinfoMapper() {
		return topUserinfoMapper;
	}

	public void setTopUserinfoMapper(TopUserinfoMapper TopUserinfoMapper) {
		this.topUserinfoMapper = TopUserinfoMapper;
	}

	public List<TopUserinfo> searchTopUserForLogin(Map searchMap) {
		TopUserinfo userInfo = (TopUserinfo) searchMap.get("userInfo");
		return topUserinfoMapper.searchTopUserinfoForLogin(userInfo);
	}

}
