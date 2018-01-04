package spring.context.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

public interface PrimaryTest {
    String printClass();
}

@Service
class ClassOne implements PrimaryTest {

    @Override
    public String printClass() {
        return "ClassOne";
    }
}

@Primary
@Service
class ClassTwo implements PrimaryTest {

    @Override
    public String printClass() {
        return "ClassTwo";
    }
}

@Service
class PrimaryMainClass {
    @Autowired
    private PrimaryTest primaryTest;

    public String getClassName() {
        return primaryTest.printClass();
    }
}
