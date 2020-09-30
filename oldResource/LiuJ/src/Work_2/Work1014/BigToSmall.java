package Work_2.Work1014;

import java.util.Scanner;

public class BigToSmall {

    public static void main(String[] args) {
        System.out.println("Please inter four numbers:");
        Scanner s=new Scanner(System.in);
        int[] a=new int[s.next().length()];
        for(int i=0;i<a.length;i++) {
            a[i]=s.nextInt();
        }

        System.out.println("From big to small：");
        for(int i=0;i<a.length;i++) {
            for(int j=i+1;j<a.length;j++) {
                if(a[i]<a[j]) {
                    int k=a[i];
                    a[i]=a[j];
                    a[j]=k;
                }
            }
            System.out.print(a[i]+" ");
        }
    }
}