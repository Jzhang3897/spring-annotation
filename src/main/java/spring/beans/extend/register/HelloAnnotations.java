package spring.beans.extend.register;

import org.springframework.context.annotation.Import;
import spring.beans.extend.example.MyImportBeanDefinitionRegistrar;

import java.lang.annotation.*;

/**
 * Created by zhangjun on 2018/1/6.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MyImportBeanDefinitionRegistrar.class)
public @interface HelloAnnotations {
}
