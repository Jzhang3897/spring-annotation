package spring.context.annotation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Configuration {@link Main#testConfiguration}
 * @Bean@Inject
 * @ComponentScan 相当于<context:component-scan  />
 * @Conditional {@link Main#testConditional}
 * @Lazy {@link Main#testLazy()}
 * @DependsOn {@link Main#testDependsOn()}
 * @Import {@link Main#testImport()}
 * @Primary {@link Main#testPrimary()}
 * @Scope 很常用，singleton 或者 prototype 单例或者原型
 * @PropertySource {@link Main#testPropertySource()}
 * @PropertySources 下面几个是一点用也没有的
 * @Description 加说明
 * @Profile 相当于pom的profile
 * @ComponentScans
 * @ImportResource 引入spring文件
 */
@Description(value = "Adds a textual description to bean definitions")
public class Main {
    private static ApplicationContext applicationContext;

    static {
        //运行本类请去掉注释，其他包加载spring配置请注释掉这个加载（会加载两次）
        //new ClassPathXmlApplicationContext("spring-config.xml");
        applicationContext = SpringContextAwareTest.getApplicationContext();
    }

    /**
     * @see SpringContextAwareTest
     * 测试 ApplicationContextAware 接口
     */
    @Test
    public void testApplicationContextAware() {
        applicationContext.getBean("main", Main.class);
    }

    /**
     * @see ConfigurationBean
     * 测试 @Configuration @Bean 注解
     */
    @Test
    public void testConfiguration() {
        System.out.println(applicationContext.getBean("config", String.class));
    }

    /**
     * @see ConditionalTest
     * 测试 @Conditional 注解
     */
    @Test
    public void testConditional() {
        applicationContext.getBean("conditionBean", ConditionBean.class);
    }

    /**
     * @see DependsOnTest
     * @see ConditionalTest
     * 测试 @DependsOn注解，依赖ConditionBean这个bean
     */
    @Test
    public void testDependsOn() {
        System.out.println(applicationContext.getBean("dependsOnTest", DependsOnTest.class));
    }

    /**
     * @see LazyClassTest
     * 测试 @Lazy注解 加了@Lazy注解在spring启动完时候，并没有加载
     */
    @Test
    public void testLazy() {
        System.out.println("spring 启动完成，接下来才加载");
        applicationContext.getBean("lazyClassTest", LazyClassTest.class);
    }

    /**
     * @see TestImport
     * 测试 @Import 也是解决依赖关系的注解，与@DependsOn不同的是
     */
    @Test
    public void testImport() {
        applicationContext.getBean(TestImport.class);
    }

    /**
     * @see PrimaryTest
     * 测试 @Primary注解 一个接口有多个实现时候，用@Autowired注解 则抛出 NoUniqueBeanDefinitionException 异常
     * 使用@Primary 则为默认的装配类
     */
    @Test
    public void testPrimary() {
        Assertions.assertEquals("ClassTwo", applicationContext.getBean(PrimaryMainClass.class).getClassName());
    }

    /**
     * @see TestPropertySource
     * 测试 @PropertySource
     */
    @Test
    public void testPropertySource() {
        Assertions.assertEquals("zhangjun", applicationContext.getBean(TestPropertySource.class).getName());
    }
}
