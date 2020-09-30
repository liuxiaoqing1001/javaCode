package Work_1.Other;

//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;

public class Input implements Test0717 {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Input() {
    }

    public Input(String name,int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.println("name="+this.name+" age="+this.age);
    }
//    public static void main(String[] args)  {
//        FileReader fr = new FileReader("/home/liu/桌面/message.txt");
//        BufferedReader br = new BufferedReader(fr);
//        new String();
//        String str = "";
//        while((str=br.readLine())!=null){
//            System.out.println(str);
//        }
//        char[] cbuf = new char[32];
//        int hasRead = 0;
//        while ((hasRead = fr.read(cbuf)) > 0) {
//            System.out.print(new String(cbuf, 0, hasRead));
//        }
//        fr.close();
//    }
}
