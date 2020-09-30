package AdapterKittiePuppie;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kittie kittie=new Kittie();
		Puppie puppie=new Puppie();
		
		//小猫模仿小狗
		KittieInterface puppieKittie=new PuppieAdapter(puppie);
		System.out.println("小猫开始模仿小狗");
		puppieKittie.miao();
		puppieKittie.catchRat();
		puppieKittie.run();
		puppieKittie.sleep();
		
//		//小狗模仿小猫
//		PuppieInterface kittiePuppie=new KittieAdapter(kittie);
//		System.out.println("小狗开始模仿小猫");
//		kittiePuppie.wao();
//		kittiePuppie.fetchBall();
//		kittiePuppie.run();
//		kittiePuppie.sleep();
	}

}
