package spring.beans.factory.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
public class TestPropertySource {
    @Value("${local}")
    private String name;
    @Value("${profile}")
    private String profile;
    public String getName() {
        System.out.println(profile);
        return this.name;
    }
}
