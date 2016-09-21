package com.topcheer.ybt.service.system;


import java.util.List;

import com.topcheer.ybt.entity.system.TopMenuInfoForSelect2;

public interface ISelect2Service {
	//查询全部的menu信息
	public List<TopMenuInfoForSelect2> searchAll();
	
	//查询全部的menu信息
	public List<TopMenuInfoForSelect2> searchWhere(TopMenuInfoForSelect2 topMenuInfoForSelect2);
}
