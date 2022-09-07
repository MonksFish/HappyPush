package cn.monksfish.happypush.api.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 操作型返回
 */
@Data
public class RpcResultTO<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 多个返回对象
     */
    private T module;

    /**
     * 列表返回对象
     */
    private List<T> modules;


    public RpcResultTO(T module) {
        this.module = module;
    }


    public RpcResultTO(List<T> moduleList) {
        this.modules = moduleList;
    }

}
