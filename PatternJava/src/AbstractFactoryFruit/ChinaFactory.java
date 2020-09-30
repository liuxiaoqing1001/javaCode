package AbstractFactoryFruit;

public class ChinaFactory implements FruitFactory {

    @Override
    public Fruit getApple() {
        return new ChinaApple();
    }
    
    @Override
    public Fruit getBanana() {
        return new ChinaBanana();
    }
}
