package spring.beans.extend.example;

import org.springframework.beans.factory.FactoryBean;

public class SpringFactoryBeanTest<T> implements FactoryBean<T> {

    private Class<T> mapperInterface;
    private GenericBeanFactory<T> beanFactory;

    @Override
    public T getObject(){
        return beanFactory.getObjectFromSession();
    }

    @Override
    public Class<T> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setMapperInterface(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public void setBeanFactory(GenericBeanFactory<T> beanFactory) {
        this.beanFactory = beanFactory;
    }
}
