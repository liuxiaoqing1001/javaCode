package StrategyCoffee;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//拿出牛奶
		CoffeeImpSingleton coffeeImpSingleton = new CoffeeImpSingleton(new MilkCoffeeImp());

		//中杯加奶
		System.out.println("---中杯加奶---");
		MediumCoffee mediumCoffee = new MediumCoffee();
		mediumCoffee.pourCoffee();

		//大杯加奶
		System.out.println("---大杯加奶---");
		SuperSizeCoffee superSizeCoffee = new SuperSizeCoffee();
		superSizeCoffee.pourCoffee();
		
		//不拿牛奶
		CoffeeImpSingleton coffeeImpSingletonNo = new CoffeeImpSingleton(new FragrantCoffeeImp());
		
		//中杯不加奶
		System.out.println("---中杯不加奶---");
		MediumCoffee mediumCoffeeNo = new MediumCoffee();
		mediumCoffeeNo.pourCoffee();

		//大杯不加奶
		System.out.println("---大杯不加奶---");
		SuperSizeCoffee superSizeCoffeeNo = new SuperSizeCoffee();
		superSizeCoffeeNo.pourCoffee();
	}

}
