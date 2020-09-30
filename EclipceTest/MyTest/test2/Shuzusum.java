package test2;
import java.util.Scanner;

public class Shuzusum {

	public static void main(String[] args) {
		//从键盘输入10个实数到数组，分别统计正数的和、负数的和
		System.out.println("输入十个实数，用回车键隔开：");
		int i,m=0,n=0;
		@SuppressWarnings("resource")
		Scanner s2=new Scanner(System.in);
		int[] a=new int[10];
		for(i=0;i<a.length;i++) {
			a[i]=s2.nextInt();
			if(a[i]>0) {
				m+=a[i];
			}else {
				n+=a[i];
			}
		}
		System.out.println("正数的和是："+m);
		System.out.println("负数的和是："+n);
	}
}