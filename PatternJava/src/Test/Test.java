package Test;
import java.util.Scanner;

public class Test{
	
	public void Calculate(int data1,int data2) {
		//�ж������Ĵ�С
		if(data1 > data2){
			int temp = data2;
			data2 = data1;
			data1 = temp;
		}
		System.out.println(data1+"��"+data2);
		System.out.println("���Լ����"+GCD(data1, data2));
		System.out.println("��С��������"+LCM(data1,data2));
	}
	
	//�����Լ��
	public int GCD(int data1,int data2) {
		int GCD=1;
		if(data2%data1 == 0) {
			GCD = data1;
		}else{
			for(int i=1;i<data1;i++){
				if(data1%i == 0 && data2%i == 0) {
					GCD = i;
				}
			}
		}
		return GCD;
	}
	
	//����С������
	public int LCM(int data1,int data2) {
		int LCM= data1*data2;
		for(int i=data2;i<LCM;i++){
			if(i%data1 == 0 && i%data2 == 0) {
				LCM = i;
			}
		}
		return LCM;
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args){
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("����������������");
			int data1 = sc.nextInt();
			int data2 = sc.nextInt();
			Test test=new Test();
			test.Calculate(data1,data2);
		}catch(Exception e){
			System.out.println("�������ֵ�����Ϲ涨");
		}
		
	}	
}

