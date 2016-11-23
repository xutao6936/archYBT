package com.topcheer.ybt.util;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.topcheer.ybt.system.service.ITopSequenceService;

@Component
@Service(value = "oracleSequenceUtil")
public class OracleSequenceUtil {
	
	@Resource(name = "topSequenceService")
	ITopSequenceService iTopSequenceService;
	
	//新保承保phinfo流水号
		public String getPhInfoSerialNo(){
			String sequence = getSequence(); // 10位交易流水
			if (sequence == null) {
				return null;
			}
			sequence = DateUtil.getCurrentDate() + fillZeroFront(sequence, 12);
			return sequence;
		}

		public String getSequence() {

			String sequence = iTopSequenceService.getSequenceByName();
			return sequence;
		}
		
		private static String fillZeroFront(String str, int length) {
			if (str == null) {
				throw new IllegalArgumentException("字符不能为空！");
			}
			int originLen = str.length();
			for (int i = 0; i < length - originLen; i++) {
				str = "0" + str;
			}
			return str;
		}

}
