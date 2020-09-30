package Work_2.Work1014;

import java.util.Scanner;

public class Grade {

    public void query(int a){
        if (a>=0){
            if (a<60){
                System.out.println(a+" D等");
            }else if (a<70){
                System.out.println(a+" C等");
            }else if (a<90){
                System.out.println(a+" B等");
            }else if (a<=100){
                System.out.println(a+" A等");
            }
        }
    }


    public static void main(String[] args) {
        Grade grade=new Grade();
        Scanner s=new Scanner(System.in);
        int a=s.nextInt();
        grade.query(a);
    }
}
