package test3;

import test6.InvalidDateException;

public class MyDate {
	private int year;
	private int month;
	private int day;
	
	/*package test3.Studengtʱ���ã�
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
			System.out.println("��ݴ���");
		}
		if(month<0||month>12) {
			System.out.println("�·ݴ���");
		}
		if(day<0||day>31) {
			throw new InvalidDateException("���ڴ���");
		//throw new ��ִ���򲻻�ִ��������ж� ,�����������ִ��Ӧ����System.out.println
		}
	}
	
	public MyDate() {
		// TODO Auto-generated constructor stub
	}

	public void setYear(int year) throws InvalidDateException {
		this.year=year;
		if(year<0) {
			System.out.println("��ݴ���");
		}
	}
	
	public void setMonth(int month)throws InvalidDateException {
		this.month=month;
		if(month<0||month>12) {
			System.out.println("�·ݴ���");
		}
	}
	
	public void setDay(int day)throws InvalidDateException {
		this.day=day;
		if(day<0||day>31) {
			throw new InvalidDateException("���ڴ���");
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

	/*һ��������MyDate�����پ���˽�г�Ա������year��month���塢day��
	 * �Լ���Ա����setYear��getYear�ȣ���������ʵ�ַ������������á�
	 * ��4����ȡ��Ա��������isRunyear��boolean�ͣ��жϵ�ǰ���󱣴�����Ƿ�Ϊ���꣩
	 * print����ӡ���ڶ������\��\����Ϣ����
	a)��main������Ҫ�󷽷���ͨ����MyDate d1=new MyDate(); MyDate d2=new MyDate(2009,4,1);��
	�ֱ��½�������Ϊ1999��1��1�յ����ڶ����������Ϊ2009��4��1�յ����ڶ��󣬷ֱ��ӡd1ͬd2����Ϣ��
	��5��ʹd2�������d1���꣬ʹd1���µ���ԭd2���£��ֱ��ӡd1ͬd2����Ϣ��*/
	
}