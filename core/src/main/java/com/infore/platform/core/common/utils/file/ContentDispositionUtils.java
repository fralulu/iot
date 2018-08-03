/******************************************************************************
 * All Rights Reserved.
 * 本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.infore.platform.core.common.utils.file;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * All rights Reserved, Designed By www.infore.com
 *
 * @version V1.0
 * @Title: ContentDispositionUtils.java
 * @Package com.infore.rewardpunish.util
 * @Description: 解决不同浏览器上中文文件名的下载乱码问题的工具类
 * @author: ZengXiaoming
 * @date: 2017年12月4日 下午1:46:55
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2017 www.infore.com Inc. All rights reserved.
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
public class ContentDispositionUtils {

    private static Logger logger = Logger.getLogger(ContentDispositionUtils.class);

    /**
     * 解决不同浏览器上中文文件名的下载乱码问题
     *
     * @param filename  导出/下载的文件的文件名
     * @param userAgent 浏览器标识
     * @param request   req
     * @param response  resp
     */
    public static void contentDisposition(String filename, String userAgent, HttpServletRequest request, HttpServletResponse response) {
        try {
            response.reset();
            response.setCharacterEncoding("UTF-8");
            String newFilename = URLEncoder.encode(filename, "UTF-8").replace("+", " ");
            String rtn = "filename=\"" + newFilename + "\"";
            if (userAgent != null) {
                userAgent = userAgent.toLowerCase();
                if (userAgent.contains("edge")) {
                    newFilename = URLEncoder.encode(filename, "UTF-8").replace("+", " ");
                    rtn = "filename=\"" + newFilename + "\"";
                } else if (userAgent.contains("trident")) {
                    rtn = "filename=\"" + newFilename + "\"";
                } else {
                    rtn = "filename=\"" + new String(filename.getBytes("UTF-8"),"ISO8859-1") + "\"";
                }
            }
            response.setHeader("Content-Disposition","attachment;" + rtn);
        } catch (UnsupportedEncodingException e) {
            logger.error("UnsupportedEncodingException.");
        }

    }
	
	/*
	 * 此类是在以下浏览器版本上测试没问题。
	Edge 20.10240.17146.0：
	Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Safari/537.36 Edge/12.10240

	IE 11：
	Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko

	Opera 49.0：
	Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.89 Safari/537.36 OPR/49.0.2725.47

	Safari 5.1.7：
	Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.89 Safari/537.36 OPR/49.0.2725.47

	Chrome 62.0.3202.94：
	Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.89 Safari/537.36 OPR/49.0.2725.47

	FireFox 57.0.1：
	Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.89 Safari/537.36 OPR/49.0.2725.47
	*/
}
