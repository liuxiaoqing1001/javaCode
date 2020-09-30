package AdapterRobot;

public class DogAdapter implements Robot{
	Dog dog;
	public DogAdapter(Dog dog) {
		this.dog=dog;
	}
	public void cry() {
		System.out.println("������ģ�⹷��...");
		dog.wang();
	}
	public void move() {
		System.out.println("������ģ�⹷��...");
		dog.run();
	}
	
}
