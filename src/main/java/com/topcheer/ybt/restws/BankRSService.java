package com.topcheer.ybt.restws;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.topcheer.ybt.data.BankResult;
import com.topcheer.ybt.entity.system.TopBankinfo;
import com.topcheer.ybt.service.system.ITopBankinfoService;
import com.topcheer.ybt.util.SpringContextHelper;


/** 
* @ClassName: BankRSService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author XUTAO 
* @date 2016-6-16 下午05:30:02 
*  
*/
@Path("/bankinfo")
public class BankRSService {
	
	@Autowired
	ITopBankinfoService service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getBankinfo")
	public List<BankResult> getBankInfo(){
		//ITopBankinfoService service = (ITopBankinfoService) SpringContextHelper.getBean("topBankinfoService");
		List<BankResult> result = Lists.newArrayList();
		List<TopBankinfo> searchAll = service.searchAll();
		for (TopBankinfo topBankinfo : searchAll) {
			BankResult br = new BankResult();
			try {
				PropertyUtils.copyProperties(br, topBankinfo);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			result.add(br);
		}
		return result;
	}
	
	
	
}
