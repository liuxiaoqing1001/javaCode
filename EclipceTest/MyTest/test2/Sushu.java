package test2;
public class Sushu {
	
	public static void main(String[] args) {
		//�������Ļ�ϴ�ӡ��100���ڵ���������
		System.out.println("100�ڵ���������Ϊ��");	
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
