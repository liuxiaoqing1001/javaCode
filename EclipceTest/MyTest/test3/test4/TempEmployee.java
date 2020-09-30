package test4;

import test4.Employee;
import test4.TempEmployee;

public class TempEmployee extends Employee {
	private double bonus;
	private double wages;
	
	public double getBonus() {
		return bonus;
	}

	public double getWages() {
		wages=bonus+basicpay;
		return wages;
	}
	
	public TempEmployee(){
		super();
	}
	
	public TempEmployee(String n, String d, double bp,double b){
		super(n,d,bp);
		bonus=b;
	}
	
	public String toString(){	
		return "name:"+name+" department:"+department+" pay:"+getPay()+" bonus:"+bonus+" wages:"+getWages();
	}

	public static void main(String[] args) {
		TempEmployee e1=new TempEmployee();
		TempEmployee e2=new TempEmployee("����","��ԷС��1210��",500,1000);
		System.out.println(e1.toString());
		System.out.println(e2.toString());
		/*
		 * ��4����֪Employee��Ķ���(��¼1)��Ϊ���дһ������TempEmployee�����������Ϊ500��
		 * ���㹤�ʰ취Ϊ������=��������+��������Ҫ�����޸�Employee�����Եķ������η���
		 */
	}

}
