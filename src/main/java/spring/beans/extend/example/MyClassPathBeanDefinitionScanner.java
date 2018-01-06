package spring.beans.extend.example;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;

import java.util.Set;

/**
 * Created by zhangjun on 2018/1/6.
 */
public class MyClassPathBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {
    public MyClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public MyClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters) {
        super(registry, useDefaultFilters);
    }

    public MyClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters, Environment environment) {
        super(registry, useDefaultFilters, environment);
    }

    public MyClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters, Environment environment, ResourceLoader resourceLoader) {
        super(registry, useDefaultFilters, environment, resourceLoader);
    }

    @Override
    public Set<BeanDefinitionHolder> doScan(String... basePackages) {
        //System.out.println(getRegistry().getBeanDefinitionCount());
        Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);
        System.out.println("---------------遍历BeanDefinitions，beanDefinitions.size="+beanDefinitions.size()+"-------------");
        //获取了指定annotation的类，然后动态的根据需要生产bean，类似mybatis 注解接口一样
        for (BeanDefinitionHolder holder : beanDefinitions) {
            System.out.println(holder.getBeanName());
        }
        System.out.println("---------------遍历BeanDefinitions结束-------------");
        return beanDefinitions;
    }
}
