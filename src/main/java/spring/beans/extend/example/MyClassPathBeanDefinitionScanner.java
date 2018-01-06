package spring.beans.extend.example;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
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
            GenericBeanDefinition beanDefinition = (GenericBeanDefinition) holder.getBeanDefinition();
            beanDefinition.getPropertyValues().addPropertyValue("mapperInterface",beanDefinition.getBeanClassName());
            beanDefinition.setBeanClass(SpringFactoryBeanTest.class);
            beanDefinition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_NAME);
            //注意这里，如果是myBatis的sessionFactory，这样就能将配置中独到的beanList 交给自定义注解，然后交给spring管理
            beanDefinition.getPropertyValues().addPropertyValue("beanFactory",new GenericBeanFactory<>());
        }
        System.out.println("---------------遍历BeanDefinitions结束-------------");
        return beanDefinitions;
    }
}
