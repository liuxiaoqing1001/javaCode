package test8;
import java.util.*;

//import test3.MyDate;
import test4.Employee;

public class MyIterable {
//	��2���������ǰһ�ڱ�д����MyDate��Employee����״����
//	�洢��LinkedList��ArrayList�У�����Ȥͬѧ�ɽ�һ���Ƚ����������Ĵ洢�ͷ��ʵ�Ч�����𣩡�
//	��3���������ǰһ�ڱ�д����MyDate��Employee����״����
//	�洢��HashSet��ע����дhashCode��equals��������TreeSet�У�����ע��comparable�ӿڣ���

	public static void main(String[ ] args) {
		//List<MyDate> l1=new LinkedList<MyDate>();
		List<Employee> l2=new ArrayList<Employee>();
		Set<Employee> s2=new HashSet<Employee>();

		String name;
		String department;
		double basicpay;
		double bonus;
		double wages;
		Employee te;
		
		Random ran=new Random();
		
		for(int i=0;i<10;i++) {
			name="S"+i;
			department="��ԷС��"+i+"��";
			basicpay=ran.nextInt(1000);
			bonus=i*100;
			wages=bonus+basicpay;
			te=new Employee(name,department,basicpay,bonus,wages);
			l2.add(te);
			s2.add(te);
		}
		
		System.out.println("\n-------\n��list�鿴\n-------\n");
		
		for(int i=0;i<l2.size();i++) {
			System.out.println(l2.get(i));
		}
		
		System.out.println("\n-------\n��set�鿴\n-------\n");
		
		Iterator<Employee> it=s2.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		
	}

}
