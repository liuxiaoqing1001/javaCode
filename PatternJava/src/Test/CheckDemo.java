package Test;

public class CheckDemo {
    public String name;
    public String psw;
    public CheckDemo(String name,String psw){//������
        this.name = name;
        this.psw = psw;
    }
    public boolean check() {
        // �û��� ���벻��Ϊ��. �û���=admin ���� = 123
        if (name != null && psw != null && name.equals("admin") && psw.equals("123")) {
            return true;
        }
        return false;
    }
}
