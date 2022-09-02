package cn.monksfish.happypush.plugin.exception;

/**
 * 定义异常行为
 */
public interface ExceptionInterface {

    /**
     * 获取异常码
     */
    String getExceptionCode();


    /**
     * 获取异常信息
     */
    String getExceptionMsg();
}
