package com.topcheer.ybt.basedata.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.topcheer.ybt.basedata.dao.TopTradeInfoMapper;
import com.topcheer.ybt.basedata.entity.TopBfyInfo;
import com.topcheer.ybt.basedata.entity.TopBuyInfo;
import com.topcheer.ybt.basedata.entity.TopBuyInfoAdd;
import com.topcheer.ybt.basedata.entity.TopPhInfo;
import com.topcheer.ybt.basedata.entity.TopRnInfo;
import com.topcheer.ybt.basedata.entity.TopSpecialInfo;
import com.topcheer.ybt.basedata.service.ITopTradeInfoService;

@Service("topTradeInfoService")
@Transactional
public class TopTradeInfoServiceImpl implements ITopTradeInfoService {

	@Autowired
	protected TopTradeInfoMapper topTradeInfoMapper;

	@Override
	public void insertBaseInfo(TopBuyInfo topBuyInfo) {
		topTradeInfoMapper.insertBaseInfo(topBuyInfo);
	}

	@Override
	public List<TopBuyInfo> selectBaseInfo(String id) {
		return topTradeInfoMapper.selectBaseInfo(id);
	}

	@Override
	public void updateBuyInfo(TopBuyInfo topBuyInfo) {
		topTradeInfoMapper.updateBuyInfo(topBuyInfo);
	}

	@Override
	public void insertPhInfo(TopPhInfo topPhInfo) {
		topTradeInfoMapper.insertPhInfo(topPhInfo);
		
	}

	@Override
	public void insertRnInfo(TopRnInfo topRnInfo) {
		topTradeInfoMapper.insertRnInfo(topRnInfo);
	}

	@Override
	public void insertBfyInfo(TopBfyInfo topBfyInfo) {
		topTradeInfoMapper.insertBfyInfo(topBfyInfo);
	}

	@Override
	public void insertSpecialInfo(TopSpecialInfo topSpecialInfo) {
		topTradeInfoMapper.insertSpecialInfo(topSpecialInfo);
	}

	@Override
	public void insertBuyInfoAddInfo(TopBuyInfoAdd topBuyInfoAdd) {
		topTradeInfoMapper.insertBuyInfoAddInfo(topBuyInfoAdd);
	}
	
	

}
