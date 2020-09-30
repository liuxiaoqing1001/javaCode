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
//		Student  s2=new Student(1989,7,7,"����","022401");
//		s1.setName("default");
//		s1.setYear(1999);
//		s1.setMonth(1);
//		s1.setDay(1);
//		Student  s3=new Student("����",new MyDate());
//		Student  s4=new Student("����",new MyDate(2009,4,1));
//		/*����һ��ѧ����Student��Ҫ�������name��String���ͣ�������������
//		birthday����һ�ڶ������MyDate���ͣ����Ա������գ��Լ���Ա����set��get�ȡ�
//		print����ӡ������Ϣ������main������Ҫ�󷽷���ͨ����Student  s1=new Student(); ��
//		�½�����Ϊ"default"������Ϊ1999��1��1�յĶ���
//		��ͨ�����ơ�Student  s2=new Student("����",1989,7,7); ���ķ���
//		�½������Լ���Ϣ��ͬ��ѧ�����󣬷ֱ��ӡs1ͬs2����Ϣ������µĹ��캯����
//		�Ա��ܹ�ͨ����Student  s3=new Student("���� new MyDate());
//		 Student  s4=new Student("����",new MyDate(2009,4,1)); ��
//		��䴴���������¶��󣬲��ֱ��ӡ����Ϣ��
//		*/
//	}
}
