package spring.beans.factory.annotation;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.context.annotation.SpringContextAwareTest;

/**
 * @Autowired
 * @Qualifier
 * @Required
 * @Scope
 * @Lookup
 * @Value
 * @Configurable
 */
public class Main {

    private static ApplicationContext applicationContext;

    static {
        new ClassPathXmlApplicationContext("spring-config.xml");
        applicationContext = SpringContextAwareTest.getApplicationContext();
    }

    /**
     * 测试 @Value 扩展PropertySourcesPlaceholderConfigurer类，实现自己的properties加载方式
     */
    @Test
    public void testValue() {
        System.out.println(applicationContext.getBean("testPropertySource",TestPropertySource.class).getName());
    }

    @Test
    public void testLoopUp() {
        System.out.println(applicationContext.getBean("lookupTest"));
    }

    @Test
    public void testConfigurable() {
        System.out.println(applicationContext);
    }
}
