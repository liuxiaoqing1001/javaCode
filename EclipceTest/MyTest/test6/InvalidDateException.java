package test6;

import test3.MyDate;

@SuppressWarnings("serial")
public class InvalidDateException extends Exception{
	/*
��ʵ�ֹ�MyDate,����һ���������Ĺ��췽��MyDate(int year, int month, int day)���������÷���setX(int arg)��
�ֱ�дһ���Զ�����쳣InvalidDateException��
�����췽�������÷������ܵĲ���������ʵ��Ҫ��ʱ���׳�һ������쳣��ʵ����
��main�����зֱ�������´��룬���񲢴�ӡ�쳣��Ϣ
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
