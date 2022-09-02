package cn.monksfish.happypush.plugin.response.operate;

/**
 * 操作状态枚举
 *
 * @author yan_wenjie
 */
public enum OperateEnum {

    /**
     * 新增成功
     */
    ADD_SUCCESS("00000", "新增成功"),

    /**
     * 修改成功
     */
    UPDATE_SUCCESS("00000", "修改成功"),

    /**
     * 删除成功
     */
    DEL_SUCCESS("00000", "删除成功"),


    /**
     * 操作成功
     */
    OPERATE_SUCCESS("00000", "操作成功"),


    /**
     * 操作失败
     */
    OPERATE_FAIL("E0001", "操作失败");

    private final String code;
    private final String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    OperateEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}




