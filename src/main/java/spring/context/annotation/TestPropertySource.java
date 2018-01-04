package spring.context.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource({"classpath:application.properties"})
public class TestPropertySource {
    @Value("${name}")
    private String name;

    public String getName() {
        return this.name;
    }
}
