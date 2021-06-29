package com.cloud.integratedSystem.auth.exception;


import org.springframework.security.core.AuthenticationException;

public class VerificationCodeException extends AuthenticationException {
    public VerificationCodeException(String msg) {
        super("图形验证码校验失败");
    }
}
