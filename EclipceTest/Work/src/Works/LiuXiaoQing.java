package Works;
import java.util.Random;  
import java.util.Scanner;  

//A��������Ԫ��ϵ�ĺϳ�(������ϵ��������������)

//class Goup {                                                                  //���뼯��A����
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
	
	 
    public static int[][] createMatrix(int row,int column ) {                 //�������һ��n�׾���,����ӡ�˾��� 
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
   
  
    public static int randomNumber(){                                         //�����
    	Random num=new Random();
        int number;  
        number = num.nextInt(2); 
        return number;  
    }  
    
    public static void synthetic(int[][] Array){                              //������ϵ����ĺϳ�
		for(int i=0;i<Array.length;i++) {
			for(int j=0;j<Array[0].length;j++) {
				System.out.print(Array[i][j]+" ");
			}
			System.out.println(); 
		}
		
	}

    
	public static int[][] calculate(int[][] Array1,int[][] Array2){
		int[][] rs=new int[Array1.length][Array2[0].length];                  //�ֱ�����к���
		for(int i=0;i<Array1.length;i++) {                                    //����R��ϵ�������
			for(int j=0;j<Array2[0].length;j++) {                             //����S��ϵ�������
				for(int k=0;k<Array1[0].length;k++) {                         //����R���к�S����
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
		int row;                                                              //��ϵ���������  
        int column;
		
		
//		System.out.println("������һ������A���Զ��Ÿ�����,�س�ȷ��:");
//		Scanner goupA=new Scanner(System.in);
//		Goup goup=new Goup(goupA.nextLine());
//		System.out.println(goup.toString());
//		System.out.println("����Ҫ��n����Ľ���(�س�ȷ��)��\n"); 
//		n=goupA.nextLine().length();
//		System.out.println(n);
		
		System.out.print("����������Ҫ��n�׾���Ľ���(�س�ȷ��)��\n"); 
		Scanner sc = new Scanner(System.in);  
        n = sc.nextInt();  
              
		row = n;                                                               //��ϵ���������  
	    column = n;
                                                                               //��ϵ���������
          
        System.out.println("������ɵĹ�ϵ����RΪ��");  
        arrayR=createMatrix(row,column);                                       //���������ϵ���� R  
        
        System.out.println("������ɵĹ�ϵ����SΪ��");  
        arrayS=createMatrix(row,column);                                       //���������ϵ����S
        
        rs=calculate(arrayR,arrayS);
        System.out.println("R��S�ĺϳ�Ϊ��");
        synthetic(rs);
    
    }  
}

  