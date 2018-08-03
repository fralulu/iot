package com.infore.platform.core.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * 对RESTful请求抛出的异常统一处理类
 *
 * @param <T>
 */
@ControllerAdvice
public class ResponseExceptionHandler<T> {

   /* @ExceptionHandler(ServerRuntimeException.class)
    @ResponseBody
    public Response handlerValidateException(ServerRuntimeException exception, HttpServletRequest request) {
        //exception.printStackTrace();
        return new Response(PlatformErrorEnum.FAIL.getMessageCode(), "Internal Server Error");
    }*/
}
