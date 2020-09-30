package test4;

public class Employee{
	protected String name;
	protected String department;
	protected double basicpay;
	protected double pay;
	private double bonus;
	private double wages;
	
	public double getBonus() {
		return bonus;
	}

	public double getWages() {
		wages=bonus+basicpay;
		return wages;
	}
	
//	Employee(String name, String department, double basicpay, double bonus, double wages){
//		this.name=name;
//		this.department=department;
//		this.basicpay=
//	}
	
	Employee(){
		this("default", "default department",0.0,0.0, 0.0);
	}

	public Employee(String n, String d, double bp, double b, double w){
		name=n;  
		department=d;
		basicpay=bp;
		bonus=b;
		wages=b+bp;
	}
	
	public Employee(String n, String d, double bp){
		name=n;  
		department=d;
		basicpay=bp;
	}
	
	public double getPay(){
		pay=basicpay;	
		return pay;
	}
	
	public String toString(){	
		return "name:"+name+" department:"+department+" pay:"+getPay()+" bonus:"+bonus+" wages:"+getWages();
	}
//	public String toString(){	
//		return "name:"+name+" department:"+department+" pay:"+getPay();
//	}
}

