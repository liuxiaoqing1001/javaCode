package Work_1.Other;

public interface Test0717 {
    public void show();



//
////    private static Test0717 ourInstance = new Test0717();//懒汉模式
////
////    public static Test0717 getInstance(){
////        System.out.println("Produce");
////        while(true){
////            synchronized (ourInstance){
////                if(ourInstance!=null){
////                    System.out.println("Produce wait");
////                    try {
////                        ourInstance.wait();
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
////                }else {
////                    ourInstance.add("Bingo");
////                    System.out.println("Produce do");
////                    ourInstance.notifyAll();
////                }
////            }
////        }
////    }
//
//
//
//
//
//
//
////    private static Test0717 ourInstance = new Test0717();//懒汉模式
////
////    public static Test0717 getInstance() {
////        while(true){
////            synchronized (ourInstance) {
////                if(ourInstance!=null){
////                    try {
////                        ourInstance.wait();
////                    } catch (InterruptedException e) {
////                        e.printStackTrace();
////                    }
////                    return ourInstance;
////                }else{
////                    ourInstance.notifyAll();
////                    return null;
////                }
////
////            }
////        }
////    }
//
//
//    private static Test0717 ourInstance = null;//饿汉模式
//    int A;
//
//    public static Test0717 getInstance() {
//        if (ourInstance == null) {
//            ourInstance = new Test0717();
//
//        } else {
//
//            return ourInstance;
//        }
//        return null;
//    }
//
//
//    private Test0717() {
////        int A=0;
//        //无锁
//        for(int i=0;i<10;i++){
//            int b=cas(A,i,i++);
//            System.out.println(b);
//        }
//
////        System.out.println("Please enter your name.");
////        Scanner s = new Scanner(System.in);
////        String name = s.nextLine();
////        System.out.println("Please enter your age.");
////        int age = s.nextInt();
////        String sentence = "I/am/" + name + "/#/I/am/" + age + "/years/old&";
////        String sentence1 = sentence.replace("/", " ");
////        String sentence2 = sentence1.replace("#", ",");
////        String sentence3 = sentence2.replace("&", ".");
////        System.out.println(sentence3);
//
//    }
//
//    private int cas(int A, int i, int i1) {
//        A=this.A;
//        i=this.A;
//        i1=++this.A;
//        return i1;
//    }
//
//    public static void main(String[] args){
//        getInstance();
//    }
//
}




