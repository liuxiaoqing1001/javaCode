package test7;
import java.io.*;
import java.util.*;
public class FileExample {	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("�������봴�����ļ���:");
		String fileName=new Scanner(System.in).nextLine();
		File f1=new File(fileName);
		if(f1.exists()){
			if(f1.isFile()){
				System.out.println("�ļ���:"+f1.getName());
				System.out.println("����·��:"+f1.getAbsolutePath());
				System.out.println("�ļ���С:"+f1.length()+"�ֽ�");
			}else{
				String[] s=f1.list();
				System.out.println("�ļ���"+f1+"����"+s.length+"����");
				for(int i=0;i<s.length;i++)
					System.out.println(s[i]);				
			}
		}else{
			f1.mkdir();
		}
	}	
}