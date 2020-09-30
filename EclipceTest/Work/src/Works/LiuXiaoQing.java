package Works;
import java.util.Random;  
import java.util.Scanner;  

//A上两个二元关系的合成(两个关系矩阵均是随机生成)

//class Goup {                                                                  //输入集合A的类
//	String A;
//	
//	Goup(String string){
//		this.A=string;
//		}
//	
//	public String toString() {
//		return "A={"+A+"}";
//	}
//}

@SuppressWarnings("unused")
public class LiuXiaoQing {
	
	 
    public static int[][] createMatrix(int row,int column ) {                 //随机创建一个n阶矩阵,并打印此矩阵 
        int matrix[][] = new int[row][column];  
        for (int i = 0; i <= row - 1; i++) {  
            for (int j = 0; j <= column - 1; j++) {  
                matrix[i][j] = randomNumber();  
                System.out.print(matrix[i][j] + " ");  
            }  
            System.out.println();  
        }  
        return matrix;  
    } 
   
  
    public static int randomNumber(){                                         //随机数
    	Random num=new Random();
        int number;  
        number = num.nextInt(2); 
        return number;  
    }  
    
    public static void synthetic(int[][] Array){                              //两个关系矩阵的合成
		for(int i=0;i<Array.length;i++) {
			for(int j=0;j<Array[0].length;j++) {
				System.out.print(Array[i][j]+" ");
			}
			System.out.println(); 
		}
		
	}

    
	public static int[][] calculate(int[][] Array1,int[][] Array2){
		int[][] rs=new int[Array1.length][Array2[0].length];                  //分别控制行和列
		for(int i=0;i<Array1.length;i++) {                                    //控制R关系矩阵的行
			for(int j=0;j<Array2[0].length;j++) {                             //控制S关系矩阵的列
				for(int k=0;k<Array1[0].length;k++) {                         //控制R的列和S的行
					if(Array1[i][k]==1&&Array2[k][j]==1) {
						rs[i][j]=1;  
					}
				}
			}
		}
		return rs;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int n;	
		int [][]rs;
		int [][]arrayR;
		int [][]arrayS;
		int row;                                                              //关系矩阵的行数  
        int column;
		
		
//		System.out.println("请输入一个集合A（以逗号隔开）,回车确认:");
//		Scanner goupA=new Scanner(System.in);
//		Goup goup=new Goup(goupA.nextLine());
//		System.out.println(goup.toString());
//		System.out.println("所需要的n矩阵的阶数(回车确认)：\n"); 
//		n=goupA.nextLine().length();
//		System.out.println(n);
		
		System.out.print("请输入所需要的n阶矩阵的阶数(回车确认)：\n"); 
		Scanner sc = new Scanner(System.in);  
        n = sc.nextInt();  
              
		row = n;                                                               //关系矩阵的行数  
	    column = n;
                                                                               //关系矩阵的列数
          
        System.out.println("随机生成的关系矩阵R为：");  
        arrayR=createMatrix(row,column);                                       //随机创建关系矩阵 R  
        
        System.out.println("随机生成的关系矩阵S为：");  
        arrayS=createMatrix(row,column);                                       //随机创建关系矩阵S
        
        rs=calculate(arrayR,arrayS);
        System.out.println("R与S的合成为：");
        synthetic(rs);
    
    }  
}

  