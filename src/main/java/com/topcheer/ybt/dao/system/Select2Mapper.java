package com.topcheer.ybt.dao.system;

import java.util.List;

import com.topcheer.ybt.entity.system.TopMenuInfoForSelect2;


public interface Select2Mapper {
	public List<TopMenuInfoForSelect2> searchAll();
	public List<TopMenuInfoForSelect2> searchWhere(TopMenuInfoForSelect2 topMenuInfoForSelect2);

}
