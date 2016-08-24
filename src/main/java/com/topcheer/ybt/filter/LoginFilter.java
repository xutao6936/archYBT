package com.topcheer.ybt.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Strings;
import com.topcheer.ybt.entity.system.TopUserinfo;


/** 
* @ClassName: LoginFilter 
* @Description: 登录filter
* @author XUTAO 
* @date 2016-6-17 上午09:21:14 
*  
*/
public class LoginFilter implements Filter {
	private static Logger log = LoggerFactory.getLogger(LoginFilter.class);
	private static String allowUrl;
    /**
     * Default constructor. 
     */
    public LoginFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		String URI = request.getRequestURI();
		if(validateUrl(URI)){
			chain.doFilter(request, response);
			
		}else{
			TopUserinfo userinfo =  (TopUserinfo) request.getSession().getAttribute("userinfo");
			if(null ==userinfo){
				log.info("用户未登录");
				response.sendRedirect(request.getContextPath() + "/login.jsp");
//				request.getRequestDispatcher(request.getContextPath() + "/login.jsp").forward(request, response);  
//				response.setHeader("Cache-Control", "no-store");  
//	            response.setDateHeader("Expires", 0);  
//	            response.setHeader("Pragma", "no-cache");  
				return;
			}else{
				log.info("登录账户为{}",userinfo.getLoginAccount());
				chain.doFilter(request, response);
			}
		}
			
			
	}
	
	private static boolean validateUrl(String URI){
		if(URI.indexOf(allowUrl)!=-1){
			return true;
		}
		return false;
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		allowUrl = fConfig.getInitParameter("allowUrl");
	}

}
