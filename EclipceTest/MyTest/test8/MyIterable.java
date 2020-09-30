package test8;
import java.util.*;

//import test3.MyDate;
import test4.Employee;

public class MyIterable {
//	（2）创建多个前一节编写过的MyDate、Employee或形状对象，
//	存储至LinkedList或ArrayList中（有兴趣同学可进一步比较两种容器的存储和访问的效率区别）。
//	（3）创建多个前一节编写过的MyDate、Employee或形状对象，
//	存储至HashSet（注意重写hashCode和equals方法）或TreeSet中（还须注意comparable接口）。

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
			department="东苑小区"+i+"号";
			basicpay=ran.nextInt(1000);
			bonus=i*100;
			wages=bonus+basicpay;
			te=new Employee(name,department,basicpay,bonus,wages);
			l2.add(te);
			s2.add(te);
		}
		
		System.out.println("\n-------\n用list查看\n-------\n");
		
		for(int i=0;i<l2.size();i++) {
			System.out.println(l2.get(i));
		}
		
		System.out.println("\n-------\n用set查看\n-------\n");
		
		Iterator<Employee> it=s2.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		
	}

}
