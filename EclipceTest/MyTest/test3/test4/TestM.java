package test4;

class Bird {
	  String name;
	  Bird(String n) {
	    name = n;
	  }

	  public void fly() {
	    System.out.println(name + " fly as bird");
	  }

	  public void fly(int number) {
	    System.out.println(name + " fly " + number + " times as bird");
	  }

	  protected void shout() {
	    System.out.println(name + " shout as bird");
	  }

	  @SuppressWarnings("unused")
	private void shout(int number) {
	    System.out.println(name + " shout " + number + " times as bird");
	  }
	}

	class Swan
	    extends Bird {
	  Swan(String n) {
	    super(n);
	  }

	  public void fly() {
	    System.out.println(name + " fly as Swan");
	  }

	  public void fly(int number) {
	    System.out.println(name + " fly " + number + " times as Swan");
	  }

	  protected void shout() {
	    System.out.println(name + " shout as Swan");
	  }

	  void swim() {
	    System.out.println(name + " swim as Swan");
	  }
	}
	public class TestM {
	  public static void main(String[] args) {
	  	Bird b1 = new Bird("小小鸟");
	    Swan b2 = new Swan("小天鹅");
	    b1.fly();
	    b2.swim();
	  }
	}
