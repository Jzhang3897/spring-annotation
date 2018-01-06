package spring.beans.extend.example;

import org.springframework.stereotype.Service;
import spring.beans.extend.register.DefinitionBean;

/**
 * Created by zhangjun on 2018/1/6.
 */
public class GenericBeanFactory <T>{
    /**
     * 假设这是ResourceLoader子类所对接的工厂类，从配置中可以获取一个Bean
     * 从配置文件中读出一个Bean
     */
    public T getObjectFromSession(){
        return (T)new DefinitionBean("zhangsan");
    }
}
