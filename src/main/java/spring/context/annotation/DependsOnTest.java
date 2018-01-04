package spring.context.annotation;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;


@DependsOn({"conditionBean"})
@Service
public class DependsOnTest {
    public DependsOnTest(){
        System.out.println("DependsOnTest init...");
    }
}
