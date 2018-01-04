package spring.context.annotation;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 测试 @Configuration @Bean用法，产生一个String类型的bean
 */
@Configuration
public class ConfigurationBean {

    @Bean(name = "config", autowire = Autowire.BY_NAME)
    public String getConfiguration() {
        return "this is a BeanFactory";
    }
}
