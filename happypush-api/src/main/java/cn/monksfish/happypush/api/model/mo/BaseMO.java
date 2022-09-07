package cn.monksfish.happypush.api.model.mo;

import lombok.Data;

import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * @author 小沙弥
 * @description api层基础的TO，所有的TO都要继承这个类
 * @date 2022/9/5 6:23 下午
 */
@Data
public class BaseMO implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 当前要调用的方法名
     */
    private String methodName;

}
