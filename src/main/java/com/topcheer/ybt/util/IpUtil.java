package com.topcheer.ybt.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.topcheer.ybt.aop.LogAspect;

public class IpUtil {
	private static Logger logger = LoggerFactory.getLogger(LogAspect.class);

	public static void main(String[] args) {
		InetAddress netAddress = getInetAddress();
		System.out.println("host ip:" + getHostIp(netAddress));
		System.out.println("host name:" + getHostName(netAddress));
		Properties properties = System.getProperties();
		Set<String> set = properties.stringPropertyNames(); // 获取java虚拟机和系统的信息。
		for (String name : set) {
			logger.info(name + ":" + properties.getProperty(name));
		}
	}

	public static InetAddress getInetAddress() {

		try {
			return InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			logger.info("unknown host!");
		}
		return null;

	}

	public static String getHostIp(InetAddress netAddress) {
		if (null == netAddress) {
			return null;
		}
		String ip = netAddress.getHostAddress(); // get the ip address
		return ip;
	}

	public static String getHostName(InetAddress netAddress) {
		if (null == netAddress) {
			return null;
		}
		String name = netAddress.getHostName(); // get the host address
		return name;
	}

}