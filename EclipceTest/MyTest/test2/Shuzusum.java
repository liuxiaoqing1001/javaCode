package test2;
import java.util.Scanner;

public class Shuzusum {

	public static void main(String[] args) {
		//�Ӽ�������10��ʵ�������飬�ֱ�ͳ�������ĺ͡������ĺ�
		System.out.println("����ʮ��ʵ�����ûس���������");
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
		System.out.println("�����ĺ��ǣ�"+m);
		System.out.println("�����ĺ��ǣ�"+n);
	}
}