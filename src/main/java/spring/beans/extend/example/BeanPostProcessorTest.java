package spring.beans.extend.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;
import spring.beans.extend.register.DefinitionBean;

/**
 * Created by zhangjun on 2017/12/27.
 * <p>
 * 对于一个BeanPostProcessor来说，它的目的在于修改已经由BeanDefinitionRegistry注册的BeanDefinition
 * 在spring中定义一个bean，可能是spring自身定义的，也有可能是用户想动态生成的
 */
@Service
public class BeanPostProcessorTest implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("hello".equals(beanName)) {
            System.out.println("BeanPostProcessor interface invoked");
            ((DefinitionBean) bean).setUser("修改后的zhangjun");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
