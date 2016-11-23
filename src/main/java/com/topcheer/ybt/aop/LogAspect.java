package com.topcheer.ybt.aop;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.topcheer.ybt.annotation.SystemControllerLog;
import com.topcheer.ybt.annotation.SystemServiceLog;
import com.topcheer.ybt.system.entity.TopLog;
import com.topcheer.ybt.system.entity.TopUserinfo;
import com.topcheer.ybt.system.service.ITopLogService;
import com.topcheer.ybt.util.DateUtil;
import com.topcheer.ybt.util.IpUtil;


/**
 * 使用注解,aop 实现日志的打印以及保存至数据库。
 * 
 * @author liuc
 * 
 */
@Aspect
@Component
public class LogAspect {
	private static Logger logger = LoggerFactory
			.getLogger(LogAspect.class);
	ThreadLocal<Long> time = new ThreadLocal<Long>();
	ThreadLocal<String> tag = new ThreadLocal<String>();
	// 注入Service用于把日志保存数据库
	@Autowired
	private ITopLogService topLogService;

	// Service层切点
	@Pointcut("@annotation(com.topcheer.ybt.annotation.SystemServiceLog)")
	public void serviceAspect() {
	}

	// Controller层切点
	@Pointcut("@annotation(com.topcheer.ybt.annotation.SystemControllerLog)")
	public void controllerAspect() {
	}

	/**
	 * 在所有标注@Log的地方切入
	 * 
	 * @param joinPoint
	 */
	// @Before("log()")
	// public void beforeExec(JoinPoint joinPoint) {
	// //
	// // String ip1 = (String) subject.getSession().getId();
	// // logger.info("ip1:"+ip1);
	//
	// try {
	// // *========控制台输出=========*//
	// Subject subject = SecurityUtils.getSubject();// 获取当前用户
	// logger.info(subject.getPrincipal().toString());
	// String username = subject.getPrincipal().toString();
	// // 请求的IP
	// InetAddress netAddress = IpUtil.getInetAddress();
	// String ip = IpUtil.getHostIp(netAddress);
	// logger.info("ip:" + ip);
	// logger.info("=====前置通知开始=====");
	// logger.info("请求方法:"
	// + (joinPoint.getTarget().getClass().getName() + "."
	// + joinPoint.getSignature().getName() + "()"));
	// logger.info("方法描述:" + getControllerMethodDescription(joinPoint));
	// logger.info("请求人:" + username);
	// logger.info("请求IP:" + ip);
	// // *========数据库日志=========*//
	// TopLog log = new TopLog();
	// log.setId(UUID.randomUUID().toString());
	// log.setDescription(getControllerMethodDescription(joinPoint));
	// log.setMethod((joinPoint.getTarget().getClass().getName() + "."
	// + joinPoint.getSignature().getName() + "()"));
	// log.setType("0");
	// log.setRequestIp(ip);
	// log.setExceptionCode(null);
	// log.setExceptionDetail(null);
	// log.setParams(null);
	// log.setCreateBy(username);
	// log.setExecuteTime("");
	// log.setCreateDate(DateUtil.getCurrentDate());
	// log.setCreateTime(DateUtil.getCurrentTime());
	// // 保存数据库
	// logService.insert(log);
	// System.out.println("=====前置通知结束=====");
	// } catch (Exception e) {
	// // 记录本地异常日志
	// logger.error("==前置通知异常==");
	// logger.error("异常信息:{" + e.getMessage() + "}", e);
	// }
	// }

//	@Around("controllerAspect()")
//	public Object aroundExec(ProceedingJoinPoint pjp) throws Throwable {
//		logger.info("aop 环绕开始");
//		time.set(System.currentTimeMillis());
//		Object obj = pjp.proceed();
//		TopLog log = new TopLog();
//		// 请求的IP
//		InetAddress netAddress = IpUtil.getInetAddress();
//		String ip = IpUtil.getHostIp(netAddress);
//		// 获取当前用户
////		Subject subject = SecurityUtils.getSubject();
////		String username = subject.getPrincipal().toString();
//		String username = "";
//		try {
//			// 获取签名
//			MethodSignature signature = (MethodSignature) pjp.getSignature();
//			String methodName = signature.getName();
//			String className = pjp.getThis().getClass().getName();
//			className = className.substring(0, className.indexOf("$$")); // 截取掉cglib代理类标志
//			logger.info("methodName:" + methodName + ",className:" + className);
//			logger.info("=====前置通知开始=====");
//			logger.info("请求方法:" + methodName);
//			logger.info("方法描述:" + getControllerMethodDescription(pjp));
//			logger.info("请求人:" + username);
//			logger.info("请求IP:" + ip);
//			logger.info("执行时间:" + "运行消耗"
//					+ (System.currentTimeMillis() - time.get()) + "ms");
//			
//			// *========数据库日志=========*//
//			log.setId(UUID.randomUUID().toString());
//			log.setDescription(getControllerMethodDescription(pjp));
//			log.setMethod((pjp.getTarget().getClass().getName() + "."
//					+ pjp.getSignature().getName() + "()"));
//			log.setType("0");// 0-正常，1-异常
//			log.setRequestIp(ip);
//			log.setExceptionCode(null);
//			log.setParams(null);
//			log.setCreateBy(username);
//			log.setExecuteTime("运行消耗"
//					+ (System.currentTimeMillis() - time.get()) + "ms");
//			log.setCreateDate(DateUtil.getCurrentDate());
//			log.setCreateTime(DateUtil.getCurrentTime());
//			// 保存数据库
//			topLogService.insert(log);
//		} catch (Exception e) {
//			// 记录本地异常日志
//			logger.error("==环绕通知异常==");
//			e.printStackTrace();
//		}
//		logger.info("aop 环绕结束");
//		return obj;
//	}


	// 配置抛出异常后通知,使用在方法aspect()上注册的切入点
	@AfterThrowing(pointcut = "controllerAspect()", throwing = "ex")
	public void afterThrow(JoinPoint joinPoint, Exception ex) {
		try {
			logger.info("afterThrow 抛出异常后开始");
			time.set(System.currentTimeMillis());
			// 拦截的方法参数
			Object[] args = joinPoint.getArgs();
			// 拦截的放参数类型
			Class[] parameterTypes = ((MethodSignature) joinPoint.getSignature())
					.getMethod().getParameterTypes();
			// 需要转换成Json的HashMap
			Map<String, Object> maps = new HashMap<String, Object>();
			Map<String, Object> parammaps = new HashMap<String, Object>();

			// 获取签名
			MethodSignature signature = (MethodSignature) joinPoint
					.getSignature();
			String methodName = signature.getName();
			// 请求的IP
			InetAddress netAddress = IpUtil.getInetAddress();
			String ip = IpUtil.getHostIp(netAddress);
				// 获取当前用户
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			HttpSession session = request.getSession();
			TopUserinfo userInfo = (TopUserinfo) session.getAttribute("userinfo");
			String username = userInfo.getUserName();
			String exceptionCode = ex.getClass().getName();// 异常类型代码' X+ B! k M0
															// L) d
			logger.info("exceptionCode:" + exceptionCode);
			// 循环获得所有参数对象
			for (int i = 0; i < args.length; i++) {
				if (null != args[i]) {
					parammaps.put("args[" + i + "]", args[i]);
				} else {
					parammaps.put("args[" + i + "]", "空参数");
				}
			}
			logger.info("=====抛出异常后通知开始=====");
			logger.info("请求方法:" + methodName);
			logger.info("方法描述:" + getControllerMethodDescription(joinPoint));
			logger.info("请求人:" + username);
			logger.info("请求IP:" + ip);
			logger.info("执行时间:" + "运行消耗"
					+ (System.currentTimeMillis() - time.get()) + "ms");
			TopLog log = new TopLog();
			log.setId(UUID.randomUUID().toString());
			log.setDescription(getControllerMethodDescription(joinPoint));
			log.setMethod((joinPoint.getTarget().getClass().getName() + "."
					+ joinPoint.getSignature().getName() + "()"));
			log.setType("1");// 0-正常，1-异常
			log.setRequestIp(ip);
			log.setExceptionCode(exceptionCode);
			log.setParams(null);
			log.setCreateBy(username);
			log.setExecuteTime("运行消耗"
					+ (System.currentTimeMillis() - time.get()) + "ms");
			log.setCreateDate(DateUtil.getCurrentDate());
			log.setCreateTime(DateUtil.getCurrentTime());
			// 保存数据库
			topLogService.insert(log);
		} catch (Exception e) {
			// 记录本地异常日志
			logger.error("==抛出异常后异常==");
			e.printStackTrace();
		}
		logger.info("afterThrow 抛出异常后结束");
	}
	
	
	@Around("serviceAspect()")
	public Object aroundExec(ProceedingJoinPoint pjp) throws Throwable {
		Object obj = pjp.proceed();
		try {
			logger.info("Service层 aop 环绕开始");
			time.set(System.currentTimeMillis());

			TopLog log = new TopLog();
			// 请求的IP
			InetAddress netAddress = IpUtil.getInetAddress();
			String ip = IpUtil.getHostIp(netAddress);
			// 获取当前用户
			HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
			HttpSession session = request.getSession();
			TopUserinfo userInfo = (TopUserinfo) session.getAttribute("userinfo");
			String username = userInfo.getUserName();

			// 获取签名
			MethodSignature signature = (MethodSignature) pjp.getSignature();
			String methodName = signature.getName();
			String className = pjp.getThis().getClass().getName();
			className = className.substring(0, className.indexOf("$$")); // 截取掉cglib代理类标志
			logger.info("methodName:" + methodName + ",className:" + className);
			logger.info("=====前置通知开始=====");
			logger.info("请求方法:" + methodName);
			logger.info("方法描述:" + getServiceMthodDescription(pjp));
			logger.info("请求人:" + username);
			logger.info("请求IP:" + ip);
			logger.info("执行时间:" + "运行消耗"
					+ (System.currentTimeMillis() - time.get()) + "ms");
			
			// *========数据库日志=========*//
			log.setId(UUID.randomUUID().toString());
			log.setDescription(getServiceMthodDescription(pjp));
			log.setMethod((pjp.getTarget().getClass().getName() + "."
					+ pjp.getSignature().getName() + "()"));
			log.setType("0");// 0-正常，1-异常
			log.setRequestIp(ip);
			log.setExceptionCode(null);
			log.setParams(null);
			log.setCreateBy(username);
			log.setExecuteTime("运行消耗"
					+ (System.currentTimeMillis() - time.get()) + "ms");
			log.setCreateDate(DateUtil.getCurrentDate());
			log.setCreateTime(DateUtil.getCurrentTime());
			// 保存数据库
			topLogService.insert(log);
		} catch (Exception e) {
			// 记录本地异常日志
			logger.error("==环绕通知异常==");
			e.printStackTrace();
		}
		logger.info("Service层aop 环绕结束");
		return obj;
	}
	
//	// 配置抛出异常后通知,使用在方法aspect()上注册的切入点
//	@AfterThrowing(pointcut = "serviceAspect()", throwing = "ex")
//	public void afterThrow(JoinPoint joinPoint, Exception ex) {
//		logger.info("afterThrow 抛出异常后开始");
//		time.set(System.currentTimeMillis());
//		// 拦截的方法参数
//		Object[] args = joinPoint.getArgs();
//		// 拦截的放参数类型
//		Class[] parameterTypes = ((MethodSignature) joinPoint.getSignature())
//				.getMethod().getParameterTypes();
//		// 需要转换成Json的HashMap
//		Map<String, Object> maps = new HashMap<String, Object>();
//		Map<String, Object> parammaps = new HashMap<String, Object>();
//
//		try {
//			// 获取签名
//			MethodSignature signature = (MethodSignature) joinPoint
//					.getSignature();
//			String methodName = signature.getName();
//			// 请求的IP
//			InetAddress netAddress = IpUtil.getInetAddress();
//			String ip = IpUtil.getHostIp(netAddress);
////			Subject subject = SecurityUtils.getSubject();// 获取当前用户
////			logger.info(subject.getPrincipal().toString());
////			String username = subject.getPrincipal().toString();
//			String username ="";
//			String exceptionCode = ex.getClass().getName();// 异常类型代码' X+ B! k M0
//															// L) d
//			logger.info("exceptionCode:" + exceptionCode);
//			// 循环获得所有参数对象
//			for (int i = 0; i < args.length; i++) {
//				if (null != args[i]) {
//					parammaps.put("args[" + i + "]", args[i]);
//				} else {
//					parammaps.put("args[" + i + "]", "空参数");
//				}
//			}
//			logger.info("=====抛出异常后通知开始=====");
//			logger.info("请求方法:" + methodName);
//			logger.info("方法描述:" + getServiceMthodDescription(joinPoint));
//			logger.info("请求人:" + username);
//			logger.info("请求IP:" + ip);
//			logger.info("执行时间:" + "运行消耗"
//					+ (System.currentTimeMillis() - time.get()) + "ms");
//			TopLog log = new TopLog();
//			log.setId(UUID.randomUUID().toString());
//			log.setDescription(getServiceMthodDescription(joinPoint));
//			log.setMethod((joinPoint.getTarget().getClass().getName() + "."
//					+ joinPoint.getSignature().getName() + "()"));
//			log.setType("1");// 0-正常，1-异常
//			log.setRequestIp(ip);
//			log.setExceptionCode(exceptionCode);
//			JSONObject json = new JSONObject();  
//			json.put("参数", parammaps);
//			log.setParams(json.toString());
//			log.setCreateBy(username);
//			log.setExecuteTime(null);
//			log.setCreateDate(DateUtil.getCurrentDate());
//			log.setCreateTime(DateUtil.getCurrentTime());
//			// 保存数据库
//			topLogService.insert(log);
//		} catch (Exception e) {
//			// 记录本地异常日志
//			logger.error("==抛出异常后异常==");
//			e.printStackTrace();
//		}
//		logger.info("afterThrow 抛出异常后结束");
//	}

	/**
	 * 获取注解中对方法的描述信息 用于service层注解
	 * 
	 * @param joinPoint
	 *            切点
	 * @return 方法描述
	 * @throws Exception
	 */
	public static String getServiceMthodDescription(JoinPoint joinPoint)
			throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String description = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					description = method.getAnnotation(SystemServiceLog.class)
							.description();
					break;
				}
			}
		}
		return description;
	}

	/**
	 * 获取注解中对方法的描述信息 用于Controller层注解
	 * 
	 * @param joinPoint
	 *            切点
	 * @return 方法描述
	 * @throws Exception
	 */
	public static String getControllerMethodDescription(JoinPoint joinPoint)
			throws Exception {
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class targetClass = Class.forName(targetName);
		Method[] methods = targetClass.getMethods();
		String description = "";
		for (Method method : methods) {
			if (method.getName().equals(methodName)) {
				Class[] clazzs = method.getParameterTypes();
				if (clazzs.length == arguments.length) {
					description = method.getAnnotation(
							SystemControllerLog.class).description();
					break;
				}
			}
		}
		return description;
	}

}
