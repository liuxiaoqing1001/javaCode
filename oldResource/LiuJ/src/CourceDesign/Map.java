package CourceDesign;

import java.util.Scanner;

//class Building{
//    public String bName;//建筑名字
//    public Load load[];//路径
//}

class Load{
    public char lName;//路径名字
    public String building1;
    public String building2;
    public int distance;//距离
    public int time;

    //    public Load(String lName,String building1,String building2,int distance,int time){
//        lName=this.lName;
//        building1=this.building1;
//        building2=this.building2;
//        distance=this.distance;
//        time=this.time;
//    }
}

public class Map {

    public void Build(Load load[],int n){
//        char x='a';
//        for(int i=0;i<n;i++){
            load[0].distance=1;
//            x++;
            System.out.println(load[0].distance);

//        }

    }

    public static void main(String[] args) {
//        Building[] b=new Building[100];
        Map map=new Map();
        Load[] load=new Load[100];
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        map.Build(load,n);

//        Load l1=new Load("A","七号宿舍楼","篮球场",300,3);
//        Load l2=new Load("b","篮球场","体育馆",300,3);
//        Load l3=new Load("c","体育场","七号宿舍楼",300,3);
//        Load l4=new Load("d","体育馆","操场",300,3);
//        Load l5=new Load("e","操场","第四食堂",300,3);
//        System.out.println(l1.toString());
//        Load l6=new Load("f","","篮球场",300,3);



    }
}
