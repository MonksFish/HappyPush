package cn.monksfish.happypush.plugin.exception.enums;

import cn.monksfish.happypush.plugin.exception.ExceptionInterface;

public enum SystemExceptionEnum implements ExceptionInterface {

    /**
     * 参数校验异常
     */
    PARAMETER_EXCEPTION("V0001", "参数校验异常"),

    /**
     * 系统发生异常
     */
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
