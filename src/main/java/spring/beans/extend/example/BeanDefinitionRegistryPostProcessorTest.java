package spring.beans.extend.example;

import org.mybatis.spring.mapper.ClassPathMapperScanner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Service;
import spring.beans.extend.register.DefinitionBean;
import spring.beans.extend.register.HelloAnnotations;

import java.util.Set;

/**
 * Created by zhangjun on 2017/12/27.
 * http://blog.csdn.net/elim168/article/details/78056446 如何使用BeanDefinitionRegistryPostProcessor
 * http://nobodyiam.com/2017/02/26/several-ways-to-extend-spring/  基于scheme的spring扩展举例
 */
@Service
public class BeanDefinitionRegistryPostProcessorTest implements BeanDefinitionRegistryPostProcessor {
    private String basePackage = "spring.beans.extend.register";

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        //添加用户所关心的bean属性，如果是依赖于spring框架的bean，需要获取registry中的definition
        //registry.getBeanDefinition("beanName");
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(DefinitionBean.class);
        beanDefinition.getPropertyValues().add("user", "zhangjun");
        beanDefinition.setLazyInit(false);
        registry.registerBeanDefinition("hello", beanDefinition);
        MyClassPathBeanDefinitionScanner beanScanner = new MyClassPathBeanDefinitionScanner(registry);
        //扫描basePackage 目录下的 HelloAnnotations 注解类，可以动态的将bean添加进去
        TypeFilter includeFilter = new AnnotationTypeFilter(HelloAnnotations.class);
        beanScanner.addIncludeFilter(includeFilter);
        beanScanner.scan(basePackage);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
