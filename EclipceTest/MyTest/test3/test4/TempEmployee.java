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
		TempEmployee e2=new TempEmployee("张三","东苑小区1210号",500,1000);
		System.out.println(e1.toString());
		System.out.println(e2.toString());
		/*
		 * （4）已知Employee类的定义(附录1)，为其编写一个子类TempEmployee，其基本工资为500，
		 * 计算工资办法为：工资=基本工资+奖金；如需要可以修改Employee类属性的访问修饰符。
		 */
	}

}
