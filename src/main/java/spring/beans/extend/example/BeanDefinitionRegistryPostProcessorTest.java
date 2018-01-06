package spring.beans.extend.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Service;
import spring.beans.extend.register.DefinitionBean;

/**
 * Created by zhangjun on 2017/12/27.
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
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
