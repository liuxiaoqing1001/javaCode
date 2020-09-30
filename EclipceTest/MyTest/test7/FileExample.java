package test7;
import java.io.*;
import java.util.*;
public class FileExample {	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("请输入想创建的文件名:");
		String fileName=new Scanner(System.in).nextLine();
		File f1=new File(fileName);
		if(f1.exists()){
			if(f1.isFile()){
				System.out.println("文件名:"+f1.getName());
				System.out.println("绝对路径:"+f1.getAbsolutePath());
				System.out.println("文件大小:"+f1.length()+"字节");
			}else{
				String[] s=f1.list();
				System.out.println("文件夹"+f1+"共有"+s.length+"对象");
				for(int i=0;i<s.length;i++)
					System.out.println(s[i]);				
			}
		}else{
			f1.mkdir();
		}
	}	
}