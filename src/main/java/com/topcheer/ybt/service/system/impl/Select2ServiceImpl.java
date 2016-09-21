package com.topcheer.ybt.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topcheer.ybt.dao.system.Select2Mapper;
import com.topcheer.ybt.entity.system.TopMenuInfoForSelect2;
import com.topcheer.ybt.service.system.ISelect2Service;

@Service("iSelect2Service")
@Transactional
public class Select2ServiceImpl implements ISelect2Service{
	
	@Autowired
	public  Select2Mapper select2Mapper;
	
	public List<TopMenuInfoForSelect2> searchAll() {
		// TODO Auto-generated method stub
		return select2Mapper.searchAll();
	}

	public List<TopMenuInfoForSelect2> searchWhere(TopMenuInfoForSelect2 topMenuInfoForSelect2) {
		// TODO Auto-generated method stub
		return select2Mapper.searchWhere( topMenuInfoForSelect2);
	}

}
