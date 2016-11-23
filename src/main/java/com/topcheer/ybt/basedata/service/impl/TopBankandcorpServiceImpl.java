package com.topcheer.ybt.basedata.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topcheer.ybt.basedata.dao.TopBankAndCorpMapper;
import com.topcheer.ybt.basedata.entity.TopBankAndCorp;
import com.topcheer.ybt.basedata.service.ITopBankAndCorpService;


@Service("topBankandcorpService")
@Transactional
public class TopBankandcorpServiceImpl implements ITopBankAndCorpService{
	
	@Autowired
	protected TopBankAndCorpMapper topBankandcorpMapper;

	public void delete(String id) {
		topBankandcorpMapper.delete(id);
		
	}

	public List<TopBankAndCorp> getTopBankandcorpList(String bankcode) {
		return topBankandcorpMapper.getTopBankandcorp(bankcode);
	}
	
	public TopBankAndCorp getTopBankandcorp(String bankcode) {
		List<TopBankAndCorp> list = topBankandcorpMapper.getTopBankandcorp(bankcode);
		return list==null||list.size()==0l?null:list.get(0);
	}

	public void insert(TopBankAndCorp topBankandcorp) {
		 topBankandcorpMapper.insert(topBankandcorp);
	}

	public List<TopBankAndCorp> searchAll() {
		return topBankandcorpMapper.searchAll();
	}


	public void update(TopBankAndCorp TopBankandcorp) {
		topBankandcorpMapper.update(TopBankandcorp);
	}

	@Override
	public List<TopBankAndCorp> getCorpByBankCode(String bankCode) {
		return topBankandcorpMapper.getCorpByBankCode(bankCode);
	}

	
	

}
