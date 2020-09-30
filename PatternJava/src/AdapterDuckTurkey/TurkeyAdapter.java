package AdapterDuckTurkey;

public class TurkeyAdapter implements Duck {

	Duck duck;
	public TurkeyAdapter(Duck duck) {
		this.duck=duck;
	}
	
	public void quack() {
		System.out.println("»ð¼¦Ã°³äÑ¼×Ó½Ð...");
		duck.quack();
	}
	
	public void fly() {
		System.out.println("»ð¼¦Ä£·ÂÑ¼×Ó...");
		duck.fly();
	}

}
