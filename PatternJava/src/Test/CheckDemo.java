package Test;

public class CheckDemo {
    public String name;
    public String psw;
    public CheckDemo(String name,String psw){//构造器
        this.name = name;
        this.psw = psw;
    }
    public boolean check() {
        // 用户名 密码不能为空. 用户名=admin 密码 = 123
        if (name != null && psw != null && name.equals("admin") && psw.equals("123")) {
            return true;
        }
        return false;
    }
}
