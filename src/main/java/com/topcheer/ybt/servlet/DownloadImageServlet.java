package com.topcheer.ybt.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import com.google.common.base.Strings;

/** 
 * @ClassName: DownloadImageServlet 
 * @Description: 
 * @author XUTAO 
 * @date 2016-6-29 上午10:33:02 
 *  
 */
public class DownloadImageServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private static Logger log = LoggerFactory.getLogger(DownloadImageServlet.class);
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		this.download(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		this.download(request, response);
	}

	private void download(HttpServletRequest request,
			HttpServletResponse response) {
		/*try {
			request.setCharacterEncoding("ISO8859-1");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		String filePath = request.getParameter("filePath");
		if(Strings.isNullOrEmpty(filePath)){
			log.info("filePath为空");
			response.setStatus(500);
			try {
				response.getWriter().print("filePath为空");
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			filePath = new String(filePath.getBytes("GBK"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		log.info("开始下载,filePath为{}",filePath);
		File file =  new File(filePath);
		if(file.isFile()){
			ServletOutputStream outputStream = null;
			InputStream in = null;
			try {
				outputStream = response.getOutputStream();
				in = new FileInputStream(file);
				byte[] returnData =  new byte[(int) file.length()];
				in.read(returnData);
				outputStream.write(returnData);
				log.info("下载完成");
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					outputStream.close();
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else {
			log.info("文件不存在!");
			response.setStatus(500);
			try {
				response.getWriter().print("filePath为空");
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
