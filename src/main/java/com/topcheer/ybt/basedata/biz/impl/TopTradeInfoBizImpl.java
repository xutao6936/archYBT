package com.topcheer.ybt.basedata.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.topcheer.ybt.basedata.biz.ITopTradeInfoBiz;
import com.topcheer.ybt.basedata.entity.TopBfyInfo;
import com.topcheer.ybt.basedata.entity.TopBuyInfo;
import com.topcheer.ybt.basedata.entity.TopBuyInfoAdd;
import com.topcheer.ybt.basedata.entity.TopInsprdInfo;
import com.topcheer.ybt.basedata.entity.TopPhInfo;
import com.topcheer.ybt.basedata.entity.TopRnInfo;
import com.topcheer.ybt.basedata.entity.TopSpecialInfo;
import com.topcheer.ybt.basedata.service.ITopTradeInfoService;

@Component
@Service(value = "topTradeInfoBizImpl")
public class TopTradeInfoBizImpl implements ITopTradeInfoBiz {

	@Resource(name = "topTradeInfoService")
	ITopTradeInfoService topTradeInfoService;
	
	@Override
	public void insertBaseInfo(TopBuyInfo topBuyInfo) {
		topTradeInfoService.insertBaseInfo(topBuyInfo);
	}
	@Override
	public List<TopBuyInfo> selectBaseInfo(String id) {
		return topTradeInfoService.selectBaseInfo(id);
	}
	@Override
	public void updateInfo(TopBuyInfo topBuyInfo) {
		topTradeInfoService.updateBuyInfo(topBuyInfo);
	}
	@Override
	public void insertPhInfo(TopPhInfo topPhInfo) {
		topTradeInfoService.insertPhInfo(topPhInfo);
	}
	@Override
	public void insertRnInfo(TopRnInfo topRnInfo) {
		topTradeInfoService.insertRnInfo(topRnInfo);
	}
	@Override
	public void insertBfyInfo(TopBfyInfo topBfyInfo) {
		topTradeInfoService.insertBfyInfo(topBfyInfo);
	}
	@Override
	public void insertSpecialInfo(TopSpecialInfo topSpecialInfo) {
		topTradeInfoService.insertSpecialInfo(topSpecialInfo);
	}
	@Override
	public void insertBuyInfoAddInfo(TopBuyInfoAdd topBuyInfoAdd) {
		topTradeInfoService.insertBuyInfoAddInfo(topBuyInfoAdd);
	}
}
