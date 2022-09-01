package cn.monksfish.happypush.util;

import cn.monksfish.happypush.common.BaseResponse;
import cn.monksfish.happypush.common.OperateEnum;


public final class BaseResponseUtil {
    /**
     * 成功标识
     */
    private static final Boolean SUCCESS_FLAG = Boolean.TRUE;
    /**
     * 失败标识
     */
    private static final Boolean FAIL_FLAG = Boolean.FALSE;
    /**
     * 成功码值
     */
    private static final String SUCCESS_CODE = "00000";
    /**
     * 失败码值
     */
    private static final String SUCCESS_MSG = "操作成功";

    private BaseResponseUtil(){}

    /**
     * 仅设置成功标识，可自定义返回码
     * @return 全局包装对象
     */
    public static BaseResponse<Object> success(){
        return new BaseResponse<>().setFlag(SUCCESS_FLAG);
    }

    /**
     * 操作成功返回对象
     * @param operateEnum 全局操作成功枚举
     * @return 全局包装对象
     */
    public static BaseResponse<Object> success(OperateEnum operateEnum){
        return new BaseResponse<>(operateEnum).setFlag(SUCCESS_FLAG);
    }
    /**
     * 操作成功返回对象
     * @param data 返回数据
     * @return 全局包装对象
     */
    public static BaseResponse<Object> success(Object data){
        return success().setCode(SUCCESS_CODE).setMessage(SUCCESS_MSG).setData(data);
    }
    /**
     * 操作失败返回对象
     * @param code 操作失败code，一般为exceptionCode
     * @param msg 操作失败消息，一般为exceptionMsg
     * @return 全局包装对象
     */
    public static <T> BaseResponse<T> fail(String code,String msg){
        return new BaseResponse<T>().setFlag(FAIL_FLAG).setCode(code).setMessage(msg);
    }

}
