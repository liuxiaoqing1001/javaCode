package AdapterKittiePuppie;

public class PuppieAdapter implements KittieInterface {
	Puppie puppie;
	public PuppieAdapter(Puppie puppie) {
		this.puppie=puppie;
	}
	public void miao() {
		System.out.println("...ģ���...");
		puppie.wao();
	}
	public void run() {
		System.out.println("...ģ�ⱼ��...");
		puppie.run();
	}
	public void sleep() {
		System.out.println("...ģ��˯��...");
		puppie.sleep();
	}
	public void catchRat() {
		System.out.println("...ģ�����...");
		puppie.fetchBall();
	}
}
