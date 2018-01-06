package spring.beans.extend.register;

@HelloAnnotations
public class DefinitionBean {
    private String user;

    public DefinitionBean() {
    }

    public DefinitionBean(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
