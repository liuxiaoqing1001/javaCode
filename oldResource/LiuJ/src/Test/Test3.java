package Test;

//Test考试题
//out of menmory

public class Test3 {
    public void add(){
        add();
    }
    public static void main(String[] args) {
        Test3 test3=new Test3();
        test3.add();
    }
}
