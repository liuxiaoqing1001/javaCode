package test2;
import java.util.Scanner;

public class BigToSmall5 {

	public static void main(String[] args) {
		//�Ӽ���¼��5��������Ȼ���ɴ�С����
		System.out.println("�������������,�ûس���������");
		Scanner s=new Scanner(System.in);
		int[] a=new int[s.next().length()];
//		@SuppressWarnings("resource")
//		Scanner sc=new Scanner(System.in);
		for(int i=0;i<a.length;i++) {
			a[i]=s.nextInt();
			}
		System.out.println("�Ӵ�С������Ϊ��");
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
