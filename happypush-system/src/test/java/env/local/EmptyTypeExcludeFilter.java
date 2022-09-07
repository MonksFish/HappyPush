package env.local;

import env.SpringBootEmptyEnv;
import org.springframework.boot.test.autoconfigure.filter.AnnotationCustomizableTypeExcludeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.util.Collections;
import java.util.Set;

/**
 * @author 小沙弥
 * @description 单元测试过滤类
 * @date 2022/9/6 9:38 下午
 */
public class EmptyTypeExcludeFilter extends AnnotationCustomizableTypeExcludeFilter {

    private final SpringBootEmptyEnv springBootEmptyEnv;

    public EmptyTypeExcludeFilter(Class<?> springBootEmptyEnv) {
        this.springBootEmptyEnv = AnnotatedElementUtils.getMergedAnnotation(springBootEmptyEnv, SpringBootEmptyEnv.class);
    }

    @Override
    protected boolean hasAnnotation() {
        return this.springBootEmptyEnv != null;
    }

    @Override
    protected ComponentScan.Filter[] getFilters(FilterType type) {
        switch (type) {
            case INCLUDE:
                return this.springBootEmptyEnv.includeFilters();
            case EXCLUDE:
                return this.springBootEmptyEnv.excludeFilters();
            default:
                throw new IllegalStateException("Unsupported type " + type);
        }
    }

    @Override
    protected boolean isUseDefaultFilters() {
        return this.springBootEmptyEnv.useDefaultFilters();
    }

    @Override
    protected Set<Class<?>> getDefaultIncludes() {
        return Collections.emptySet();
    }

    @Override
    protected Set<Class<?>> getComponentIncludes() {
        return Collections.emptySet();
    }
}
