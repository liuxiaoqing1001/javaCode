package Works;

//import java.util.Scanner;
//
//public class ArraysSetOperation {
//	
//	
//	@SuppressWarnings("resource")
//	public static void main(String[] args) {
//		
//		
//		int n;//�洢�����е�Ԫ�ظ���
//		int[][] guanXi_1,guanXi_2,result;//ʹ���������ݽṹ�洢��Ԫ��ϵ
//		
//		System.out.println("������A�е�Ԫ�ظ���");
//		
//		n=new Scanner(System.in).nextInt();//����Ԫ�ظ���
//		guanXi_1=new int[n][n];//���ٹ�ϵ����
//		guanXi_2=new int[n][n];
//		result=new int[n][n];//�洢���
//		
//		System.out.print("��1�����й�ϵ������0����û�й�ϵ.\nÿ��Ԫ��֮��ʹ�ÿո������");
//		
//		//�����һ����ϵ����
//		System.out.println("�������һ����ϵ����");
//		inputArray(guanXi_1);
//		
//		//����ڶ�����ϵ����
//		System.out.println("������ڶ�����ϵ����");
//		inputArray(guanXi_2);
//		
//		//�������
//		result=outputArray(guanXi_1,guanXi_2);
//		
//		//��ӡ�����
//		System.out.println("��һ����ϵ����");
//		printArray(guanXi_1);
//		System.out.println("�ڶ�����ϵ����");
//		printArray(guanXi_2);
//		System.out.println("�ϳɽ����");
//		printArray(result);
//		
//		
//	}
//	
//	
//	public static void inputArray(int[][] Array) {//�����ϵ������
//		Scanner sc=new Scanner(System.in);
//		for(int i=0;i<Array.length;i++) {
//			for(int j=0;j<Array[0].length;j++) {
//				Array[i][j]=sc.nextInt();
//			}
//		}
//	}
//	
//	public static int[][] outputArray(int[][] Array1,int[][] Array2){//����������
//		int[][] result=new int[Array1.length][Array2[0].length];//Array.length �ֱ��������
//		
//		for(int i=0;i<Array1.length;i++) {//���Ƶ�һ����ϵ�������
//			for(int j=0;j<Array2[0].length;j++) {//���Ƶڶ����������
//				for(int k=0;k<Array1[0].length;k++) {//���Ƶ�һ�����к͵ڶ�������
//					if(Array1[i][k]==1&&Array2[k][j]==1) {
//						result[i][j]=1;//��һ������ļ�Ϊ�й�ϵ  
//					}
//	
//				}
//			}
//		}
//		return result;
//		
//	}
//	
//	public static void printArray(int[][] Array){
//		
//		for(int i=0;i<Array.length;i++) {
//			for(int j=0;j<Array[0].length;j++) {
//				System.out.print(" "+Array[i][j]);
//			}
//			System.out.println();//��ӡ�س�
//		}
//		
//	}
//}
