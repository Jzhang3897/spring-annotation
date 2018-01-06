package spring.beans.extend.example;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by zhangjun on 2018/1/6.
 */
public class NamespaceHandlerHelper extends NamespaceHandlerSupport {
    @Override
    public void init() {
        System.out.println("NamespaceHandlerHelper........");
    }
}
