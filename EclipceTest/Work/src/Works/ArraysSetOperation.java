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
//		int n;//存储集合中的元素个数
//		int[][] guanXi_1,guanXi_2,result;//使用数组数据结构存储二元关系
//		
//		System.out.println("请输入A中的元素个数");
//		
//		n=new Scanner(System.in).nextInt();//输入元素个数
//		guanXi_1=new int[n][n];//开辟关系矩阵
//		guanXi_2=new int[n][n];
//		result=new int[n][n];//存储结果
//		
//		System.out.print("“1代表有关系”，“0代表没有关系.\n每个元素之间使用空格隔开”");
//		
//		//输入第一个关系矩阵
//		System.out.println("请输入第一个关系矩阵");
//		inputArray(guanXi_1);
//		
//		//输入第二个关系矩阵
//		System.out.println("请输入第二个关系矩阵");
//		inputArray(guanXi_2);
//		
//		//输出矩阵
//		result=outputArray(guanXi_1,guanXi_2);
//		
//		//打印出结果
//		System.out.println("第一个关系矩阵：");
//		printArray(guanXi_1);
//		System.out.println("第二个关系矩阵：");
//		printArray(guanXi_2);
//		System.out.println("合成结果：");
//		printArray(result);
//		
//		
//	}
//	
//	
//	public static void inputArray(int[][] Array) {//输入关系到矩阵
//		Scanner sc=new Scanner(System.in);
//		for(int i=0;i<Array.length;i++) {
//			for(int j=0;j<Array[0].length;j++) {
//				Array[i][j]=sc.nextInt();
//			}
//		}
//	}
//	
//	public static int[][] outputArray(int[][] Array1,int[][] Array2){//计算结果矩阵
//		int[][] result=new int[Array1.length][Array2[0].length];//Array.length 分别控制行列
//		
//		for(int i=0;i<Array1.length;i++) {//控制第一个关系矩阵的行
//			for(int j=0;j<Array2[0].length;j++) {//控制第二个矩阵的列
//				for(int k=0;k<Array1[0].length;k++) {//控制第一个的列和第二个的行
//					if(Array1[i][k]==1&&Array2[k][j]==1) {
//						result[i][j]=1;//有一个满足的即为有关系  
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
//			System.out.println();//打印回车
//		}
//		
//	}
//}
