package AdapterKittiePuppie;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kittie kittie=new Kittie();
		Puppie puppie=new Puppie();
		
		//Сèģ��С��
		KittieInterface puppieKittie=new PuppieAdapter(puppie);
		System.out.println("Сè��ʼģ��С��");
		puppieKittie.miao();
		puppieKittie.catchRat();
		puppieKittie.run();
		puppieKittie.sleep();
		
//		//С��ģ��Сè
//		PuppieInterface kittiePuppie=new KittieAdapter(kittie);
//		System.out.println("С����ʼģ��Сè");
//		kittiePuppie.wao();
//		kittiePuppie.fetchBall();
//		kittiePuppie.run();
//		kittiePuppie.sleep();
	}

}
