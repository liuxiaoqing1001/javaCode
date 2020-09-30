package AdapterDuckTurkey;

public class TurkeyAdapter implements Duck {

	Duck duck;
	public TurkeyAdapter(Duck duck) {
		this.duck=duck;
	}
	
	public void quack() {
		System.out.println("��ð��Ѽ�ӽ�...");
		duck.quack();
	}
	
	public void fly() {
		System.out.println("��ģ��Ѽ��...");
		duck.fly();
	}

}
