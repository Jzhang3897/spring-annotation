package spring.context.annotation;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class LazyClassTest {
    static {
        System.out.println("LazyClassTest 被已经被jvm类加载器加载...");
    }
    public LazyClassTest(){
        System.out.println("LazyClassTest 对象已经生成");
    }
}
