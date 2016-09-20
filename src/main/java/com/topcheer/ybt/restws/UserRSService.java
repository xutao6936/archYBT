package com.topcheer.ybt.restws;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.topcheer.ybt.data.LoginResult;
import com.topcheer.ybt.system.entity.TopBankinfo;
import com.topcheer.ybt.system.entity.TopUserinfo;
import com.topcheer.ybt.system.service.ITopBankinfoService;
import com.topcheer.ybt.system.service.ITopUserinfoService;
import com.topcheer.ybt.util.ResultHelper;

/**
 * @ClassName: UserRSService
 * @Description:
 * @author XUTAO
 * @date 2016-6-17 上午09:22:28
 * 
 *       select * from top_menuinfo t start with t.fa_menu_code='YBT' connect by prior t.menu_code=t.fa_menu_code
 */
@Path("/user")
public class UserRSService {

	@Resource(name = "topUserinfoService")
	ITopUserinfoService service;
	@Resource(name = "topBankinfoService")
	ITopBankinfoService bankinfoService;

	@GET
	@Path("/login/{loginAccount}/{pwd}")
	@Produces(MediaType.APPLICATION_JSON)
	public LoginResult login(@PathParam("loginAccount") String loginAccount, @PathParam("pwd") String pwd) {
		if (Strings.isNullOrEmpty(loginAccount) || Strings.isNullOrEmpty(pwd)) {
			String msg = "登录账户或者密码为空";
			throw buildException(Status.NOT_FOUND, msg);
		}
		Map<String, Object> map = Maps.newHashMap();
		TopUserinfo userInfo = new TopUserinfo();
		userInfo.setLoginAccount(loginAccount);
		userInfo.setLoginPwd(pwd);
		map.put("userInfo", userInfo);
		List<TopUserinfo> list = service.searchTopUser(map);
		if ((null != list) && (list.size() > 0)) {
			TopUserinfo user = list.get(0);
			LoginResult result = new LoginResult(ResultHelper.RESULT_SUCC, user.getUserDept(), user.getFilePath(),
					user.getUserName(), "1", null);
			List<TopBankinfo> topBankinfoList = bankinfoService.getTopBankinfoList(user.getUserDept());
			if ((null != topBankinfoList) && (topBankinfoList.size() > 0)) {
				result.setDeptName(topBankinfoList.get(0).getBankName());
			}
			return result;
		} else {
			return new LoginResult(ResultHelper.RESULT_ERROR);
		}
	}

	private WebApplicationException buildException(Status status, String message) {
		return new WebApplicationException(Response.status(status).entity(message).type(MediaType.APPLICATION_JSON)
				.build());
	}

	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "hello";
	}

}
