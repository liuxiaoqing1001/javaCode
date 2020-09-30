package test8;

import java.util.*;

public class InputStudent {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LinkedList<String> list = new LinkedList<String>();
		System.out.println("输入学生名字(使用quit结束)");
		while(true) {
			//System.out.println("");
			String input = scanner.next();
			if(input.equals("quit")) {
				 break;
			}        
			list.addLast(input);
		}        
		System.out.println(list);
	}
}
