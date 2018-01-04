package spring.beans.extend.example;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

@Service("factoryTest")
public class SpringFactoryBeanTest implements FactoryBean<String> {

    @Override
    public String getObject() throws Exception {
        return "this is a factoryBean";
    }

    @Override
    public Class<?> getObjectType() {
        return String.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
