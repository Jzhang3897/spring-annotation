package spring.beans.factory.annotation;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

@Service
public abstract class LookupTest {
    @Lookup("main")
    public abstract Object getObject();
}
