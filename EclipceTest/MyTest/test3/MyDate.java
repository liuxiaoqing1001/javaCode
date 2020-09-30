package test3;

import test6.InvalidDateException;

public class MyDate {
	private int year;
	private int month;
	private int day;
	
	/*package test3.Studengt时所用：
	 * 
	 * public MyDate(int year, int month, int day, String name, double number) {
		MyDate(year,month,day);
	}
	
	private void MyDate(int year, int month, int day) {
		this.year=year;
		this.month=month;
		this.day=day;
	}*/

	public MyDate(int year, int month, int day) throws InvalidDateException{
		this.year=year;
		this.month=month;
		this.day=day;
		if(year<0) {
			System.out.println("年份错误！");
		}
		if(month<0||month>12) {
			System.out.println("月份错误！");
		}
		if(day<0||day>31) {
			throw new InvalidDateException("日期错误！");
		//throw new 若执行则不会执行下面的判断 ,若想继续向下执则应该用System.out.println
		}
	}
	
	public MyDate() {
		// TODO Auto-generated constructor stub
	}

	public void setYear(int year) throws InvalidDateException {
		this.year=year;
		if(year<0) {
			System.out.println("年份错误！");
		}
	}
	
	public void setMonth(int month)throws InvalidDateException {
		this.month=month;
		if(month<0||month>12) {
			System.out.println("月份错误！");
		}
	}
	
	public void setDay(int day)throws InvalidDateException {
		this.day=day;
		if(day<0||day>31) {
			throw new InvalidDateException("日期错误！");
			}
	}
	
	
	
	/*
	 * public void isRunyear(boolean b) {
		
	}
	 * public static void main(String[] args) throws InvalidDateException {
		MyDate d1=new MyDate(); 
		d1.setYear(1999);
		d1.setMonth(1);
		d1.setDay(1);
		MyDate d2=new MyDate(2009,4,1);
		System.out.println(d1.getYear()+"."+d1.getMonth()+"."+d1.getDay());
		System.out.println(d2.getYear()+"."+d2.getMonth()+"."+d2.getDay());
	}*/

	/*一个日期类MyDate，至少具有私有成员变量：year、month定义、day，
	 * 以及成员方法setYear、getYear等（具体隐藏实现方法，用于设置、
	 * （4）获取成员变量）、isRunyear（boolean型，判断当前对象保存的年是否为闰年）
	 * print（打印日期对象的年\月\日信息）。
	a)在main方法，要求方法中通过“MyDate d1=new MyDate(); MyDate d2=new MyDate(2009,4,1);”
	分别新建年月日为1999年1月1日的日期对象和年月日为2009年4月1日的日期对象，分别打印d1同d2的信息；
	（5）使d2的年等于d1的年，使d1的月等于原d2的月，分别打印d1同d2的信息；*/
	
}