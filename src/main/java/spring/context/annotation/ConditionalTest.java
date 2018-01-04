package spring.context.annotation;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @see ConfigurationBean
 * 该类的matches方法决定ConfigurationBean 的bean是否能够成功生成
 */
@Component
public class ConditionalTest implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return true;
    }
}

@Service("conditionBean")
@Conditional(ConditionalTest.class) //取决于ConditionalTest matches的返回值
class ConditionBean {
    public ConditionBean() {
        System.out.println("ConditionBean init...");
    }
}

