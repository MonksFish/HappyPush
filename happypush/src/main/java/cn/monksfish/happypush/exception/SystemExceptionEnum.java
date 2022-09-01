package cn.monksfish.happypush.exception;

import cn.monksfish.happypush.exception.ExceptionInterface;

public enum SystemExceptionEnum implements ExceptionInterface {
    PARAMETER_EXCEPTION("V0001", "参数校验异常"),


    SYS_EXCEPTION("S0001", "系统发生异常");


    private final String exceptionCode;
    private final String exceptionMsg;

    @Override
    public String getExceptionCode() {
        return this.exceptionCode;
    }

    @Override
    public String getExceptionMsg() {
        return this.exceptionMsg;
    }

    SystemExceptionEnum(String exceptionCode, String exceptionMsg) {
        this.exceptionCode = exceptionCode;
        this.exceptionMsg = exceptionMsg;
    }
}
