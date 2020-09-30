package AdapterDuckTurkey;

public class WildTurkey implements Turkey {
	public void gobble() {
		System.out.println("咕咕咕");
	}
	
	public void fly() {
		System.out.println("我在飞，不过飞不远");
	}
}
