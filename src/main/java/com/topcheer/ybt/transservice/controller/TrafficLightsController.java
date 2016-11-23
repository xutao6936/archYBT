package com.topcheer.ybt.transservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 绿灯交易
 * 
 * @author liuc
 * 
 */

@Controller
@RequestMapping("/topTrafficLights")
public class TrafficLightsController {
	private static Logger logger = LoggerFactory
			.getLogger(TrafficLightsController.class);
	
	@RequestMapping("/turnToTrafficLightsInfo.do")
	public String turnToTrafficLightsInfo() {
		return "transservice/trafficLightsInfo";
	}
}