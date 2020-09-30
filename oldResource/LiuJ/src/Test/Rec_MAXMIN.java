package Test;

import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Rec_MAXMIN {

    public static void Rec_MAXMIN( int A[], int i,int j,int fmax[],int fmin[]){  //分治策略、递归算法
//    	int mid, gmax=0,gmin=0,hmax=0,hmin=0;

        if(i==j) {                             //只有一个元素
            fmax[0]=A[i];
            fmin[0]=A[i];
        } else if(i==(j-1)) {//只有两个元素
            if (A[i]>A[j]) {
                fmax[0]=A[i];
                fmin[0]=A[j];
            } else {
                fmax[0]=A[j];
                fmin[0]=A[i];
            }
        } else {
            int mid ;
            int gmax[]={0};
            int gmin[]={0};
            int hmax[]={0};
            int hmin[]={0};
            mid=(i+j)/2;
            Rec_MAXMIN(A,i,mid,gmax,gmin);//递归求解
            Rec_MAXMIN(A,mid+1,j,hmax,hmin);
            fmax[0]=max(gmax[0],hmax[0]);
            fmin[0]=min(gmin[0],hmin[0]);
        }

    }

//    private static int min(int gmin2, int hmin2) {
//        if(gmin2>hmin2)
//            return hmin2;
//        return 0;
//    }
//
//
//    private static int max(int gmax2, int hmax2) {
//        if(gmax2>hmax2)
//            return gmax2;
//        return 0;
//    }


    public static void main(String[]args) {
//		Scanner sc=new Scanner(System.in);
        int A[]= {5,4,6,3,8};
        int []fmax=new int[1];
        int []fmin=new int[1];

        Rec_MAXMIN(A,0,4,fmax,fmin);
        System.out.println(fmax[0]+"  "+fmin[0]);
//		for(int i=0;i<=5;i++) {
//			A[]=sc.nextInt(5);
//		}

    }

}