package test6;

import test3.MyDate;

@SuppressWarnings("serial")
public class InvalidDateException extends Exception{
	/*
曾实现过MyDate,包含一个含参数的构造方法MyDate(int year, int month, int day)及三个设置方法setX(int arg)。
现编写一个自定义的异常InvalidDateException。
当构造方法或设置方法接受的参数不符合实际要求时，抛出一个这个异常的实例。
在main函数中分别包含以下代码，捕获并打印异常信息
MyDate d1=new MyDate(-1, 13, 32);
MyDate d2=new MyDate();	d2.setDay(100);
	 */
	
	public InvalidDateException(String Massage) throws InvalidDateException{
		super(Massage);
	}

	public static void main(String[] args) throws Exception{
		try {
			MyDate d3=new MyDate(1997, 10, 1);
			MyDate d1=new MyDate(-1, 13, 32);
			MyDate d2=new MyDate();	
			d2.setDay(100);
		}catch(InvalidDateException e) {
			System.out.println(e);
		}
	}

}
