package test7;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class ReadFile {
	public static String doit(String fileName) {
	    //add your code here 
		String result=null;
		try {
			 //创建一个FileReader对象.
		      FileReader fr = new FileReader(fileName);
		      //创建一个BufferedReader 对象.
		      BufferedReader br = new BufferedReader(fr);
		      //读取一行数据.
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
       //创建一个FileReader对象.
		      FileReader fr = new FileReader(sourceFileName);
		      //创建一个BufferedReader 对象.
		      BufferedReader br = new BufferedReader(fr);
      //读取一行数据.
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