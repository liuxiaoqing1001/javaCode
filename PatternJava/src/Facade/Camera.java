package Facade;

public class Camera {
	public void TurnOn() {
		System.out.println("录像机开启");
	}
	public void TurnOff() {
		System.out.println("录像机关闭");
	}
	public void Rotate(int degress) {
		System.out.println("录像机旋转");
	}
}