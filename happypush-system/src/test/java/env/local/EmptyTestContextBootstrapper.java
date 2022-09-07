package env.local;

import env.SpringBootEmptyEnv;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.core.annotation.AnnotatedElementUtils;

/**
 * @author 小沙弥
 * @description 单元测试空环境
 * @date 2022/9/6 9:09 下午
 */
public class EmptyTestContextBootstrapper extends SpringBootTestContextBootstrapper {

    @Override
    protected String[] getProperties(Class<?> testClass) {
        SpringBootEmptyEnv annotation = AnnotatedElementUtils.getMergedAnnotation(testClass, SpringBootEmptyEnv.class);
        return (annotation != null) ? annotation.properties() : null;
    }

}
