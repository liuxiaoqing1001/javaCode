package Facade;

public class SecurityFacade {
	private static Camera camera1,camera2;
	private static Light light1,light2,light3;
	private static Sensor sensor;
	private static Alarm alarm;
	
	SecurityFacade() {
		camera1=new Camera();
		camera2=new Camera();
		light1=new Light();
		light2=new Light();
		light3=new Light();
		sensor=new Sensor();
		alarm=new Alarm();
		
	}
	
	public void Activate() {
		camera1.TurnOn();
		camera2.TurnOn();
		light1.TurnOn();
		light2.TurnOn();
		light3.TurnOn();
		sensor.Activate();
		alarm.Activate();
	}
	
	public void Deactivate() {
		camera1.TurnOff();
		camera2.TurnOff();
		light1.TurnOff();
		light2.TurnOff();
		light3.TurnOff();
		sensor.Deactivate();
		alarm.Deactivate();
	}
}
