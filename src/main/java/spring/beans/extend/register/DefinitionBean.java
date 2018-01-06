package spring.beans.extend.register;

import org.mybatis.spring.annotation.MapperScan;

@HelloAnnotations
public class DefinitionBean {
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
