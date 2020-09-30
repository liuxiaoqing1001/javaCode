package AdapterKittiePuppie;

public class KittieAdapter implements PuppieInterface{
	Kittie kittie;
	public KittieAdapter(Kittie kittie) {
		this.kittie=kittie;
	}
	public void wao() {
		System.out.println("...模拟叫...");
		kittie.miao();
	}
	public void fetchBall() {
		System.out.println("...模拟抓老鼠...");
		kittie.catchRat();
	}
	public void run() {
		System.out.println("...模拟奔跑...");
		kittie.run();
	}
	public void sleep() {
		System.out.println("...模拟睡觉...");
		kittie.sleep();
	}
}
