package cn.monksfish.happypush.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 全局返回对象
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class BaseResponse<T> {
    /**
     * 操作标识
     */
    private Boolean flag;
    /**
     * 返回码
     */
    private String code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回数据本身
     */
    private T data;

    public BaseResponse(OperateEnum operateEnum){
        this.code = operateEnum.getCode();
        this.message = operateEnum.getMessage();
    }
}
