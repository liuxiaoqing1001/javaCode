package Work_2.Work1014;

//九九乘法表
public class Multiplication {
    public static void main(String[] args) {
        int row;//行
        int column;//列
        for(row=1;row<=9;row++){
            for(column=1;column<=row;column++){
                int result=row*column;
                System.out.print(row+"*"+column+"="+result+" ");
            }
            System.out.println();
        }
    }
}
