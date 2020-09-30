package AdapterKittiePuppie;

public class KittieAdapter implements PuppieInterface{
	Kittie kittie;
	public KittieAdapter(Kittie kittie) {
		this.kittie=kittie;
	}
	public void wao() {
		System.out.println("...ģ���...");
		kittie.miao();
	}
	public void fetchBall() {
		System.out.println("...ģ��ץ����...");
		kittie.catchRat();
	}
	public void run() {
		System.out.println("...ģ�ⱼ��...");
		kittie.run();
	}
	public void sleep() {
		System.out.println("...ģ��˯��...");
		kittie.sleep();
	}
}
