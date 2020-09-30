package test3;

import test6.InvalidDateException;

public class Student extends MyDate implements Comparable<Student>{
	int age;
	double grade;
	private String name;
	private String number;
	String end;
	String string=number+end;
	
	Student(String string, MyDate myDate){
		super();
		
	}
	
	Student(int year,int month,int day,String name,String number) throws InvalidDateException{
		super(year,month,day);
		this.name=name;
		this.number=number;
	}

	Student() {
		
	}

	public Student(String string, String name, int age, double grade) {
		this.string=string;
		this.name=name;
		this.age=age;
		this.grade=grade;
	}
	
	

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public int compareTo (Student o) {
		number.compareTo(o.number);
		return 0;
	}

//	public static void main(String[] args) throws InvalidDateException {
//		Student  s1=new Student();
//		Student  s2=new Student(1989,7,7,"张三","022401");
//		s1.setName("default");
//		s1.setYear(1999);
//		s1.setMonth(1);
//		s1.setDay(1);
//		Student  s3=new Student("张三",new MyDate());
//		Student  s4=new Student("张三",new MyDate(2009,4,1));
//		/*定义一个学生类Student，要求其包含name（String类型，保存姓名）、
//		birthday（上一节定义过的MyDate类型，用以保存生日）以及成员方法set、get等、
//		print（打印对象信息）。在main方法，要求方法中通过“Student  s1=new Student(); ”
//		新建姓名为"default"、生日为1999年1月1日的对象，
//		再通过类似“Student  s2=new Student("张三",1989,7,7); ”的方法
//		新建与你自己信息相同的学生对象，分别打印s1同s2的信息；添加新的构造函数，
//		以便能够通过“Student  s3=new Student("张三 new MyDate());
//		 Student  s4=new Student("张三",new MyDate(2009,4,1)); ”
//		语句创建的两个新对象，并分别打印其信息；
//		*/
//	}
}
