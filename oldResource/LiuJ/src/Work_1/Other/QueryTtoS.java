package Work_1.Other;

import java.util.Scanner;

class Stu {
    public String sname;
    public int sage;

    public Stu(String name,int age){
        this.sname=name;
        this.sage=age;
    }

    public String toString(){
        return "name="+sname+" age="+sage;
    }

    public static void main(String[] args){
        Stu s=new Stu("张三",20);
        Stu s1=new Stu("李四",23);
        Stu s2=new Stu("王五",29);
        System.out.println(s.toString()+"\n"+s1.toString()+"\n"+s2.toString());
    }
}

class Tea {
    public String tname;
    public int tage;

    public Tea(String name,int age){
        this.tname=name;
        this.tage=age;
    }

    public String toString(){
        return "name="+tname+" age="+tage;
    }

    public static void main(String[] args){
        Tea t=new Tea("张老师",42);
        Tea t1=new Tea("李老师",58);
        System.out.println(t.toString()+"\n"+t1.toString());


    }
}



public class QueryTtoS {
    public void queryT(String name){
        Tea t=new Tea("张老师",42);
        Tea t1=new Tea("李老师",58);
        if(t.tname==name|t1.tname==name){
            if(t.tname==name){
                Stu s1=new Stu("李四",23);
                Stu s2=new Stu("王五",29);
                System.out.println(s1.toString()+"\n"+s2.toString());
            }else{
                Stu s=new Stu("张三",20);
                System.out.println(s.toString());
            }
        }else{
            System.out.println("not the teacher!");
        }
    }

    public static void main(String[] args){
        QueryTtoS q=new QueryTtoS();
        System.out.println("Please enter the name of teacher");
        Scanner s=new Scanner(System.in);
        q.queryT(s.nextLine());
    }

}
