package spring.context.annotation;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

@Import(TestImport.class)
@Service
public class ImportBean {

}

class TestImport{
    public TestImport(){
        System.out.println("TestImport init...");
    }
}
