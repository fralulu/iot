package com.infore.platform.core.exception;

import org.springframework.core.NestedRuntimeException;

@SuppressWarnings("serial")
public class ServerRuntimeException extends NestedRuntimeException {

    public ServerRuntimeException(String code, String msg) {
        super(code+":"+msg);
    }

    public ServerRuntimeException(String msg) {
        super(msg);
    }
}
