package test7;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadFile {
	public static String doit(String fileName) {
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
 /* public static void main(String[] args) {
    try {
       //����һ��FileReader����.
		      FileReader fr = new FileReader(sourceFileName);
		      //����һ��BufferedReader ����.
		      BufferedReader br = new BufferedReader(fr);
      //��ȡһ������.
      String line = br.readLine();
      while (line != null) {
        System.out.println(line);
        line = br.readLine();
      }
      br.close();
      fr.close();
    }
    catch (IOException ioe) {
      ioe.printStackTrace();
    }
  }*/
}