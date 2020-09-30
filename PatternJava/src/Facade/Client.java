package Facade;

public class Client {
//·非Facade模式
//	private static Camera camera1,camera2;
//	private static Light light1,light2,light3;
//	private static Sensor sensor;
//	private static Alarm alarm;
//	
//	static Client() {
//		camera1=new Camera();
//		camera2=new Camera();
//		light1=new Light();
//		light2=new Light();
//		light3=new Light();
//		sensor=new Sensor();
//		alarm=new Alarm();
//		
//	}
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		camera1.TurnOn();
//		camera2.TurnOn();
//		light1.TurnOn();
//		light2.TurnOn();
//		light3.TurnOn();
//		sensor.Activate();
//		alarm.Activate();
//	}
	
//·Facade模式
	private static SecurityFacade security;
	public static void main(String[] args) {
		security=new SecurityFacade();
		security.Activate();
		security.Deactivate();
	}
}
