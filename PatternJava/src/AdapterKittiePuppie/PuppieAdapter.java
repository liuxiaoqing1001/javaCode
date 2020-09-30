package AdapterKittiePuppie;

public class PuppieAdapter implements KittieInterface {
	Puppie puppie;
	public PuppieAdapter(Puppie puppie) {
		this.puppie=puppie;
	}
	public void miao() {
		System.out.println("...Ä£Äâ½Ğ...");
		puppie.wao();
	}
	public void run() {
		System.out.println("...Ä£Äâ±¼ÅÜ...");
		puppie.run();
	}
	public void sleep() {
		System.out.println("...Ä£ÄâË¯¾õ...");
		puppie.sleep();
	}
	public void catchRat() {
		System.out.println("...Ä£Äâ½ÓÇò...");
		puppie.fetchBall();
	}
}
