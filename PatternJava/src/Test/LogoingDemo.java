package Test;

import java.util.Scanner;

public class LogoingDemo {
    public static void main(String[] args) {
        System.out.println("�������û���");
        Scanner sc  = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("����������");
        String psw  = sc.nextLine();
        sc.close();
        CheckDemo cd = new CheckDemo(name,psw);//
        boolean bo = cd.check();//
        if(bo){
            System.out.println("��¼�ɹ�");
        }else{
            System.out.println("��¼ʧ��:��ʾ �û��� admin ����123");
        }
    }
}