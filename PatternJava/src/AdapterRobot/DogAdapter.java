package AdapterRobot;

public class DogAdapter implements Robot{
	Dog dog;
	public DogAdapter(Dog dog) {
		this.dog=dog;
	}
	public void cry() {
		System.out.println("机器人模拟狗叫...");
		dog.wang();
	}
	public void move() {
		System.out.println("机器人模拟狗跑...");
		dog.run();
	}
	
}
