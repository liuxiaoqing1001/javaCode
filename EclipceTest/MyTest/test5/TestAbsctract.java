package test5;
abstract class AbsClass{
	abstract void absMethod();
	void commMethod(){
		System.out.println("I am a common method in a abstract class.");
	}
}
abstract class AbsSubClass extends AbsClass{
	void commMethod3(){
		System.out.println("I am a common method in a abstract sub class.");
	}
}
class SubClass extends AbsClass{
	void absMethod(){
		System.out.println("I am a implemented method in a common sub class.");
	}
}
public class TestAbsctract {
	public static void main(String [] rgs){
		SubClass sc=new SubClass();
		AbsClass ac=new SubClass();
		sc.absMethod();
		ac.absMethod();
   }
}
