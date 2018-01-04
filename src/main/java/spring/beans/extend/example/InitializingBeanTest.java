package spring.beans.extend.example;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public class InitializingBeanTest implements InitializingBean,DisposableBean{
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("spring bean初始化完成后的操作");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("spring bean销毁时候的操作");
    }
}
