package cn.monksfish.happypush.api.model.to;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 小沙弥
 * @description api层基础的TO，所有的TO都要继承这个类
 * @date 2022/9/5 6:23 下午
 */
@Data
public class BaseTO implements Serializable {

    private static final long serialVersionUID = 1L;

}
