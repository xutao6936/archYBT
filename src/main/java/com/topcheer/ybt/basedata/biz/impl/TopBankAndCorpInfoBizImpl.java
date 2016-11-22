package com.topcheer.ybt.basedata.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.topcheer.ybt.basedata.biz.ITopBankAndCorpInfoBiz;
import com.topcheer.ybt.basedata.entity.TopBankAndCorp;
import com.topcheer.ybt.basedata.service.ITopBankAndCorpService;

@Component
@Service(value = "topBankAndCorpInfoBizImpl")
public class TopBankAndCorpInfoBizImpl implements ITopBankAndCorpInfoBiz{
	private static Logger log = LoggerFactory.getLogger(TopBankAndCorpInfoBizImpl.class);

	@Resource(name = "topBankandcorpService")
	ITopBankAndCorpService topBankandcorpService;
	@Override
	public List<TopBankAndCorp> getTopBankandcorpList(String bankcode) {
		return topBankandcorpService.getTopBankandcorpList(bankcode);
	}

	@Override
	public TopBankAndCorp getTopBankandcorp(String bankcode) {
		return topBankandcorpService.getTopBankandcorp(bankcode);
	}

	@Override
	public List<TopBankAndCorp> searchAll() {
		return topBankandcorpService.searchAll();
	}

	@Override
	public void insert(TopBankAndCorp topBankandcorp) {
		topBankandcorpService.insert(topBankandcorp);
	}

	@Override
	public void update(TopBankAndCorp topBankandcorp) {
		topBankandcorpService.update(topBankandcorp);
	}

	@Override
	public void delete(String id) {
		topBankandcorpService.delete(id);
	}

	@Override
	public List<TopBankAndCorp> getCorpByBankCode(String bankCode) {
		return topBankandcorpService.getCorpByBankCode(bankCode);
	}

}
