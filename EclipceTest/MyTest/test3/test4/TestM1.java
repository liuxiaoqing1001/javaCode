package test4;
class Bird1 {
	  String name;
	  Bird1(String n) {
	    name = n;
	  }

	  public void fly() {
	    System.out.println(name+" fly as bird");
	  }
	  
	  public void shout() {
	    System.out.println(name+" shout as bird");
	  }
	  public void shout(int number) {
	    System.out.println(name+" shout "+number+" times as bird");
	  }

	public void swin() {
		// TODO Auto-generated method stub
		
	}
	}

	class Swan1 extends Bird1 {
	  Swan1(String n) {
	    super(n);
	  }

	  public void fly() {
	    System.out.println(name+" fly as Swan");
	  }

	  public void shout() {
	    System.out.println(name+" shout as Swan");
	  }

	  public void swim() {
	    System.out.println(name+" swim as Swan");
	  }
	}

	class Duck extends Bird1 {
	  Duck(String n) {
	    super(n);
	  }

	  public void fly() {
	    System.out.println(name+" fly as Duck");
	  }

	  public void shout() {
	    System.out.println(name+" shout as Duck");
	  }

	  public void swim() {
	    System.out.println(name+" swim as Duck");
	  }
	}

	public class TestM1 {
	  public static void main(String[] args) {
	    Bird1 b1 = new Bird1("СС��");
	    Bird1 b2 = new Swan1("С���");
	    Bird1 b3 = new Duck("����Ѽ");
	    
//������������������ԭ��*/
	   /* b1.swin();
	    b2.swin();
	    b3.swin();
		(Duck)b3.swim();      
		�ȷ��������������н������ִ����֤
		*/    	
	    b1.fly();
	    b2.fly();
	    b3.fly();
	    
	    b1.shout(1);
	    b1.shout(2); 
	    b1.shout(3);
	 
	    Swan1 s2=(Swan1)b2;
	    s2.swim();    
	    
	    s2=(Swan1)b1;
	    s2.swim();
	    
	    s2=(Swan1)b3;
	    s2.swim();     

	    ((Duck)b3).swim();	
	    /****************************/    	
	  }
	}

