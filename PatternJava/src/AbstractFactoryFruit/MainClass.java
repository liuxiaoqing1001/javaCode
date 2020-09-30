package AbstractFactoryFruit;

public class MainClass {

    public static void main(String[] args){
        //�����й�����
        FruitFactory chinaFactory = new ChinaFactory();
        //ͨ���й����������й�ƻ��ʵ��
        Fruit apple = chinaFactory.getApple();
        apple.get();
        //ͨ���й����������й��㽶ʵ��
        Fruit banana = chinaFactory.getBanana();
        banana.get();        
        
        //����Ӣ������
        FruitFactory englandFactory = new EnglandFactory();
        //ͨ��Ӣ����������Ӣ��ƻ��ʵ��
        Fruit apple1 = englandFactory.getApple();
        apple1.get();
        //ͨ��Ӣ����������Ӣ���㽶ʵ��
        Fruit banana2 = englandFactory.getBanana();
        banana2.get();
    }
}
