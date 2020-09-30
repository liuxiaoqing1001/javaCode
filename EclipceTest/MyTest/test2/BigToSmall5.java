package test2;
import java.util.Scanner;

public class BigToSmall5 {

	public static void main(String[] args) {
		//从键盘录入5个整数，然后由大到小排序。
		System.out.println("键盘输入五个数,用回车键隔开：");
		Scanner s=new Scanner(System.in);
		int[] a=new int[s.next().length()];
//		@SuppressWarnings("resource")
//		Scanner sc=new Scanner(System.in);
		for(int i=0;i<a.length;i++) {
			a[i]=s.nextInt();
			}
		System.out.println("从大到小的排序为：");
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
