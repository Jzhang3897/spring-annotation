package spring.beans.extend.example;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class SpringEventListener implements ApplicationListener<SpringEventObject> {

    @Override
    public void onApplicationEvent(SpringEventObject event) {
        System.out.println("spring 事件触发 event "+event);
    }
}