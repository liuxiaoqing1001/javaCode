package test2;
import java.util.Scanner;

public class Paixu {

	public static void main(String[] args) {
		System.out.println("输入三个不同的整数，用回车键隔开：");
		@SuppressWarnings("resource")
		Scanner s1=new Scanner(System.in);
		int a=s1.nextInt();
		int b=s1.nextInt();
		int c=s1.nextInt();
		int d;
		if(a>b)
		{
			d=a;
			a=b;
			b=d;
		}
		if(a>c)
		{
			d=a;
			a=c;
			c=d;
		}
		if(b>c)
		{
			d=b;
			b=c;
			c=d;
		}
		System.out.println("按从小到大的顺序排列为："+a+","+b+","+c);
	}

}