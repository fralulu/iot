/******************************************************************************
 * All Rights Reserved.
 * 本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、
 * 复制、修改或发布本软件.
 *****************************************************************************/
package com.infore.platform.core.common.errorcode;

/**
 * All rights Reserved, Designed By www.infore.com
 *
 * @version V1.0
 * @Title: PlatformErrorEnum.java
 * @Package com.infore.platform.core.common.errorcode
 * @Description: 错误码枚举
 * @author: Administrator
 * @date: 2017年8月23日 下午2:29:11
 * @company:深圳盈峰环境网络技术有限公司
 * @Copyright: 2017 www.infore.com Inc. All rights reserved.
 * 注意：本软件为深圳盈峰环境网络技术有限公司开发研制。未经本公司正式书面同意，其他任何个人、团体不得使用、复制、修改或发布本软件.
 */
public enum PlatformErrorEnum implements IMessageEnum {
    //---------------------------------------------
    OK(0, "成功"),
    // -1为通用失败
    FAIL(-1, "失败"),
    TOKEN_ERROR(2, "Token异常"),
    ALERT(3, "弹窗信息"),
    REQUEST_INPUT_ERROR(4, "输入项中不能包含非法字符。"),
    NO_CONTENT(204, "No Content"),
    NOT_MODIFIED(304, "Not Modified"),
    BAD_REQUEST(400, "参数错误"),
    NO_PERMISSION(401, "权限不足"),
    ERROR(500, "Error"),
    NOT_FOUND(404, "Not Found"),
    ERROR_A(100, "错误A"),
    ERROR_B(200, "错误B");

    //-----------------------1000内属于平台错误信息--------------------

    /**
     * @Title: PlatformErrorEnum
     * @param: @param code
     * @param: @param message
     */
    PlatformErrorEnum(int code, String message) {
        this.messageCode = code;
        this.messageCodeDesc = message;
    }

    /**
     * 信息编码
     */
    private int messageCode;
    /**
     * 信息描述
     */
    private String messageCodeDesc;

    /**
     * <p>Title: getMessageCode</p>
     * <p>Description: </p>
     *
     * @return int
     * @see com.infore.platform.core.common.errorcode.IMessageEnum#getMessageCode()
     */
    @Override
    public int getMessageCode() {
        return messageCode;
    }

    /**
     * <p>Title: getMessageCodeDesc</p>
     * <p>Description: </p>
     *
     * @return string
     * @see com.infore.platform.core.common.errorcode.IMessageEnum#getMessageCodeDesc()
     */
    @Override
    public String getMessageCodeDesc() {
        return messageCodeDesc;
    }

    /**
     * @Title: getMessageCodeDesc
     * @Description: 根据信息编码获取信息描述
     * @param code code
     * @return: String
     */
    public static String getMessageCodeDesc(int code) {

        for (PlatformErrorEnum err : PlatformErrorEnum.values()) {
            if (err.messageCode == code) {
                return err.messageCodeDesc;
            }
        }
        return "errorCode not defined ";
    }

    /**
     * @Title: getMessageCode
     * @Description: 根据枚举获取信息码
     * @param mune mune
     * @param: @return
     * @return: int
     */
    public static int getMessageCode(String mune) {
        try {
            return PlatformErrorEnum.valueOf(mune).messageCode;
        } catch (IllegalArgumentException e) {
            return FAIL.getMessageCode();
        }
    }

    /**
     * @Title: getMessageCodeDesc
     * @Description: 根据枚举值获取信息
     * @param mune mune
     * @param: @return
     * @return: String
     */
    public static String getMessageCodeDesc(String mune) {
        try {
            return PlatformErrorEnum.valueOf(mune).messageCodeDesc;
        } catch (IllegalArgumentException e) {
            return FAIL.getMessageCodeDesc();
        }
    }

    /**
     * @Title: main
     * @Description: 示例用法
     * @param args args
     * @return: void
     */
    public static void main(String[] args) {
        System.out.println(PlatformErrorEnum.ERROR_A.getMessageCode());
        System.out.println(PlatformErrorEnum.ERROR_A.getMessageCodeDesc());
        System.out.println(PlatformErrorEnum.getMessageCodeDesc(200));
        System.out.println(PlatformErrorEnum.getMessageCode("OK"));
        System.out.println(PlatformErrorEnum.getMessageCode("ok"));
        System.out.println(PlatformErrorEnum.getMessageCodeDesc("OK"));

    }

}
