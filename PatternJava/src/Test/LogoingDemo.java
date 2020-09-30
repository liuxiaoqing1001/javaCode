package Test;

import java.util.Scanner;

public class LogoingDemo {
    public static void main(String[] args) {
        System.out.println("请输入用户名");
        Scanner sc  = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("请输入密码");
        String psw  = sc.nextLine();
        sc.close();
        CheckDemo cd = new CheckDemo(name,psw);//
        boolean bo = cd.check();//
        if(bo){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败:提示 用户名 admin 密码123");
        }
    }
}