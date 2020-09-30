package test2;
public class Sushu {
	
	public static void main(String[] args) {
		//编程在屏幕上打印出100以内的所有素数
		System.out.println("100内的所有素数为：");	
		int i,j;                                                                  ;
		for(i=2;i<100;i++) {
			for(j=2;j<i;j++) {
				if(i%j==0)
				break;
			}
			if(j>=i)
				System.out.print(i+" ");
		}
	}

}
