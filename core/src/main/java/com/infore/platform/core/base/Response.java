package com.infore.platform.core.base;

import com.infore.platform.core.common.errorcode.PlatformErrorEnum;
import com.infore.platform.core.common.utils.json.Json;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 * All rights Reserved, Designed By www.infore.com
 *
 * @version V1.0
 * @Title: Response
 * @Package com.infore.platform.core.common.base
 * @Description: 返回信息封装
 * @author: xing.guanghui
 * @date: 2017/8/30 10:42
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2017 www.infore.com Inc. All rights reserved.
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
public class Response implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2971008691550120409L;

    private Integer code;
    private String msg;
    private Object data = "";

    public Response() {
    }

    public Response(Object data) {
        this.data = data;
    }

    public Response(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Response(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(Integer code) {
        this.code = code;
    }

    public Response(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    /**
     * 未找到资源
     *
     * @return resp
     */
    public static Response notFound() {
        int code = PlatformErrorEnum.NOT_FOUND.getMessageCode();
        String desc = PlatformErrorEnum.NOT_FOUND.getMessageCodeDesc();
        return new Response(code, desc);
    }

    /**
     * 服务器已经接受请求并且没必要返回实体数据，比如修改数据成功，可直接返回nocontent
     *
     * @return
     */
    public static Response noContent() {
        int code = PlatformErrorEnum.NO_CONTENT.getMessageCode();
        String desc = PlatformErrorEnum.NO_CONTENT.getMessageCodeDesc();
        return new Response(code, desc);
    }

    /**
     * 错误请求，在参数错误的情况下返回给前端
     *
     * @return resp
     */
    public static Response badRequest() {
        int code = PlatformErrorEnum.BAD_REQUEST.getMessageCode();
        String desc = PlatformErrorEnum.BAD_REQUEST.getMessageCodeDesc();
        return new Response(code, desc);
    }

    /**
     * 请求成功，不返回实体数据到前端
     *
     * @return
     */
    public static Response ok() {
        int code = PlatformErrorEnum.OK.getMessageCode();
        String desc = PlatformErrorEnum.OK.getMessageCodeDesc();
        return new Response(code, desc, "");
    }

    /**
     * 请求成功，并返回实体数据到前端
     *
     * @param data 数据（字符串，boolean，map，list等）
     * @return resp
     */
    public static Response ok(Object data) {
        int code = PlatformErrorEnum.OK.getMessageCode();
        String desc = PlatformErrorEnum.OK.getMessageCodeDesc();
        return new Response(code, desc, data);
    }

    /**
     * 请求失败，切前端需要把msg内容提示给用户
     * @param msg
     * @return
     */
    public static Response alert(String msg) {
        int code = PlatformErrorEnum.ALERT.getMessageCode();
        return new Response(code, msg);
    }

    /**
     * 请求失败，没有实体数据返回
     * @return resp
     */
    public static Response fail() {
        int code = PlatformErrorEnum.FAIL.getMessageCode();
        String desc = PlatformErrorEnum.FAIL.getMessageCodeDesc();
        return new Response(code, desc);
    }

    /**
     * 请求失败，返回提示信息
     * @param msg 提示信息
     * @return resp
     */
    public static Response fail(String msg) {
        int code = PlatformErrorEnum.FAIL.getMessageCode();
        return new Response(code, msg);
    }

    /**
     * 请求失败
     * @param errorEnum
     * @return
     */
    public static Response fail(PlatformErrorEnum errorEnum) {
        int code = errorEnum.getMessageCode();
        String desc = errorEnum.getMessageCodeDesc();
        return new Response(code, desc);
    }

    /**
     * 过滤器返回实体数据到前端，因为filter 不能直接return实体，所以用response 打印
     * @param response
     * @param code
     * @param msg
     */
    public static void filterError(HttpServletResponse response, Integer code, String msg) {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            Response resp = new Response();
            resp.setCode(code);
            resp.setMsg(msg);
            writer.print(Json.getJsonFromObject(resp));
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
