package StrategyCoffee;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�ó�ţ��
		CoffeeImpSingleton coffeeImpSingleton = new CoffeeImpSingleton(new MilkCoffeeImp());

		//�б�����
		System.out.println("---�б�����---");
		MediumCoffee mediumCoffee = new MediumCoffee();
		mediumCoffee.pourCoffee();

		//�󱭼���
		System.out.println("---�󱭼���---");
		SuperSizeCoffee superSizeCoffee = new SuperSizeCoffee();
		superSizeCoffee.pourCoffee();
		
		//����ţ��
		CoffeeImpSingleton coffeeImpSingletonNo = new CoffeeImpSingleton(new FragrantCoffeeImp());
		
		//�б�������
		System.out.println("---�б�������---");
		MediumCoffee mediumCoffeeNo = new MediumCoffee();
		mediumCoffeeNo.pourCoffee();

		//�󱭲�����
		System.out.println("---�󱭲�����---");
		SuperSizeCoffee superSizeCoffeeNo = new SuperSizeCoffee();
		superSizeCoffeeNo.pourCoffee();
	}

}
