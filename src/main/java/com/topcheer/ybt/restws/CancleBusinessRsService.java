package com.topcheer.ybt.restws;

import java.util.List;
import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.topcheer.ybt.restws.pojo.CancleBusinessReqPojo;
import com.topcheer.ybt.restws.pojo.CancleBusinessRespPojo;
import com.topcheer.ybt.basedata.biz.ITopTradeInfoBiz;
import com.topcheer.ybt.basedata.entity.TopBuyInfo;

/**
 * @ClassName: CancleBusinessRsService
 * @Description: 当日撤单
 * @author	liuc
 * @date 
 * 
 */
@Path("/cancleBusinessRsService")
public class CancleBusinessRsService {

		@Resource(name = "topTradeInfoBizImpl")
		ITopTradeInfoBiz iTopTradeInfoBiz;
	
		@Path("/cancleBusiness")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public CancleBusinessRespPojo CancleBusiness(CancleBusinessReqPojo cancleBusinessReqPojo) {
			CancleBusinessRespPojo cancleBusinessRespPojo;
			String resultInfo = "";
			String resultCode = "";
			
			TopBuyInfo topBuyInfo = new TopBuyInfo(); 
			topBuyInfo.setSerialno(cancleBusinessReqPojo.getSerialNo());
			topBuyInfo.setInscorpstatus("4");//冲正成功
			topBuyInfo.setCorestatus("4");//冲正成功
			topBuyInfo.setSerialtype("1");
			topBuyInfo.setRecordstatus("1");
			//根据流水号查询银保通系统中的交易信息
			List<TopBuyInfo> list = iTopTradeInfoBiz.selectBaseInfo(cancleBusinessReqPojo.getSerialNo());
			if(0==list.size()){
			    resultInfo = "银保通系统中无此流水";
			    resultCode = "000001";
			    cancleBusinessRespPojo = new CancleBusinessRespPojo();
			    cancleBusinessRespPojo.setResultCode(resultCode);
			    cancleBusinessRespPojo.setResultInfo(resultInfo);
				return cancleBusinessRespPojo;
			}
			
			//撤单交易直接将保险公司状态和核心状态修改为已冲正
			iTopTradeInfoBiz.updateInfo(topBuyInfo);
			return new CancleBusinessRespPojo("000000","返回成功","2800","新华人寿","03","20161018000000000001","355124","10000","20161019","新华人寿一号分红险");
		}
		
		@SuppressWarnings("unused")
		private WebApplicationException buildException(Status status, String message) {
			return new WebApplicationException(Response.status(status).entity(message).type(MediaType.APPLICATION_JSON)
					.build());
		}

}
