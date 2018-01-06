package spring.beans.extend.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.beans.extend.register.DefinitionBean;

public class Main {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        SpringEventObject eventObject = new SpringEventObject("this is a event");
        //测试事件发布
        //applicationContext.publishEvent(eventObject);

        //测试BeanDefinitionRegistryPostProcessor
        System.out.println("hello instance is " + applicationContext.getBean("definitionBean", DefinitionBean.class).getUser());
    }
}
