package com.topcheer.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.topcheer.ybt.system.service.ITopBankinfoService;

/**
 * @ClassName: UserServiceTest
 * @Description:
 * @author XUTAO
 * @date 2016-7-18 下午04:01:50
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration("/applicationContext.xml")
@ActiveProfiles("develop")
public class UserServiceTest {

	@Resource(name = "topBankinfoService")
	ITopBankinfoService service;

	@Test
	public void testInsert() {
		/*
		 * TopBankinfo t = new TopBankinfo();
		 * 
		 * t.setBankCode("23");
		 * t.setBankName("静海支行");
		 * t.setBankLevel("3");
		 * t.setUpBankcode("1");
		 * t.setUpdatedate(DateUtil.getCurrentDate());
		 * t.setUpdatetime(DateUtil.getCurrentTime());
		 * t.setOperatorBankcode("000000");
		 * t.setOperatorCode("000000");
		 * t.setAdminFlag("0");
		 * 
		 * service.insert(t);
		 * TopBankinfo t1 = service.getTopBankinfo("23");
		 * assertEquals(t.getBankName(), t1.getBankName());
		 */
	}

}
