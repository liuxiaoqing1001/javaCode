package AbstractFactoryFruit;

public class MainClass {

    public static void main(String[] args){
        //创建中国工厂
        FruitFactory chinaFactory = new ChinaFactory();
        //通过中国工厂生产中国苹果实例
        Fruit apple = chinaFactory.getApple();
        apple.get();
        //通过中国工厂生产中国香蕉实例
        Fruit banana = chinaFactory.getBanana();
        banana.get();        
        
        //创建英国工厂
        FruitFactory englandFactory = new EnglandFactory();
        //通过英国工厂生产英国苹果实例
        Fruit apple1 = englandFactory.getApple();
        apple1.get();
        //通过英国工厂生产英国香蕉实例
        Fruit banana2 = englandFactory.getBanana();
        banana2.get();
    }
}
