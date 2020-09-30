package AdapterRobot;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BioRobot robot=new BioRobot();
//		Dog dog=new Dog();
//		Robot dogRobot=new DogAdapter(dog);
//		System.out.println("BioRobot cry...");
//		dogRobot.cry();
//		dogRobot.move();
		
		Bird bird=new Bird();
		Robot birdRobot=new BirdAdapter(bird);
		System.out.println("birdRobot...");
		birdRobot.cry();
		birdRobot.move();
	}

}
