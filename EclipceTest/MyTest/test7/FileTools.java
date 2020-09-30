package test7;
import java.io.*;
import java.util.*;
@SuppressWarnings("unused")
public class FileTools {
	public static void main(String[] args){
		write();
		String sourceFileName="E:\\mytest1.txt";
		String objectFileName="E:\\456.txt";
		FileTools.copyFile(sourceFileName,objectFileName);
	}
	
	public static void write() {
		    try {
		      /**����һ��FileWriter ����*/
		      FileWriter fw = new FileWriter("E:\\mytest1.txt");
		      /**����һ��BufferedWriter ����*/
		      BufferedWriter bw = new BufferedWriter(fw);
		      String n=null;
		      System.out.println("Please enter a word in the txt:");
		      @SuppressWarnings("resource")
			Scanner s=new Scanner(System.in);
		      n=s.nextLine();
		      //ע���ж������á�.equals��
		      while(!n.equalsIgnoreCase("over")) {
		    	  bw.write(n);
		    	  bw.newLine();
		    	  n=s.nextLine();
		      }
		      //bw.write("first");
		      //bw.write("second");
		     
		      //bw.write("last");
		      bw.flush();
		      fw.close();
		    }
		    catch (IOException ioe) {
		      ioe.printStackTrace();
		    }
		  }
	
	public static String read(String fileName){
		    //add your code here 
			String result=null;
			try {
				//����һ��FileReader����.
			      FileReader fr = new FileReader(fileName);
			      //����һ��BufferedReader ����.
			      BufferedReader br = new BufferedReader(fr);
			      //��ȡһ������.
			      String line = br.readLine();
			      while (line != null) {
			        result+=line;
			        line = br.readLine();
			      }
			      br.close();
			      fr.close();
			    }
			    catch (IOException ioe) {
			      ioe.printStackTrace();
			    }
			return result;
		}
	
		public static void copyFile(String sourceFileName,String objectFileName) {
			
			String s=read(sourceFileName);
		    try {
		    	
		      //����һ��FileReader����.
		      FileReader fr = new FileReader(sourceFileName);
		      //����һ��BufferedReader ����.
		      BufferedReader br = new BufferedReader(fr);
		      //����һ��FileWriter ����
		      FileWriter fw = new FileWriter(objectFileName);
		      //����һ��BufferedWriter ����
		      BufferedWriter bw = new BufferedWriter(fw);
		      //��ȡһ������.
		      
		      String line = br.readLine();
		      while (line != null) {
		    	  bw.write(line);
		    	  bw.newLine();
		    	  line = br.readLine();
		      }
		      br.close();
		      fr.close();
		      
		      bw.flush();
		      fw.close();
		    }
		    catch (IOException ioe) {
		      ioe.printStackTrace();
		    }
		
	}
}