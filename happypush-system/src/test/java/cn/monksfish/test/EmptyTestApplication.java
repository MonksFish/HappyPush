package cn.monksfish.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动类
 * scanBasePackages : 需要跨模块扫描bean，所以一定要指定扫描的包，同时需要在maven中加入想要的包依赖
 */
@SpringBootApplication(scanBasePackages = "cn.monksfish.happypush.**")
public class EmptyTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmptyTestApplication.class, args);
    }

}
