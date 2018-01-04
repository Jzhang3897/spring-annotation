package spring.beans.extend.example;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 实现 ApplicationContextAware 接口，将该类注交给spring管理则会得到applicationContext
 */
//@ComponentScan(basePackages = {"spring.annotation.context"})
public class SpringContextAwareTest implements ApplicationContextAware{

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }
}
