package spring.beans.extend.example;

import org.springframework.context.ApplicationEvent;

/**
 * 实际应用：项目中拿到applicationContext，对已经受spring管理的listener 发布一个事件，则实现此listenet的bean则会执行onEvent方法
 * 举例：发布一个事件，清空各自业务的缓存，在某个接口被调用后，发布一个事件，所有收到此事件的服务清除各自的缓存
 */
public class SpringEventObject extends ApplicationEvent {
    private String eventName = "myTestEvent";

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public SpringEventObject(Object source) {
        super(source);
    }

    public String getEventName() {
        return this.eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
