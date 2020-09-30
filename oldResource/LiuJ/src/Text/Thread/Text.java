package Text.Thread;

//线程

//1>
//class MyThread extends Thread{
//    public void run() {
//        while (true) {
//            try{
//                Thread.sleep(1000);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            System.out.println("ok");
//        }
//    }
//
//}

//2>
//class MyRun implements Runnable{
//
//    @Override
//    public void run() {
//        System.out.println("ok");
//    }
//}

//3>多线程不安全
//安全性和性能
//class MyRun implements Runnable{
//    public static int i;
//    @Override
//    public synchronized void run() {//加 synchronized (锁)就安全了

//锁：

//        for(int i=0;i<1000;i++){
//            MyRun.i++;
////            Thread.currentThread();//本线程
//
//        }
//    }
//}

//4>
class MyRun implements Runnable {

    @Override
    public void run() {
//        System.out.println(Thread.currentThread().getName());
//        while (true);//主进程结束，子进程没有结束
        Thread t=new Thread();
    }
}


public class Text {
    public static void main(String[] args){

//1>
//        MyThread myThread=new MyThread();
//        myThread.start();

//2>
//        MyRun run=new MyRun();
//        Thread t=new Thread(run);
//        t.start();
//        System.out.println("ok");

//3>
//        MyRun run=new MyRun();
//        Thread t1=new Thread(run);
//        Thread t2=new Thread(run);
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
//        System.out.println(MyRun.i);

//4>
        MyRun run=new MyRun();
        Thread t1=new Thread(run,"t1");
        Thread t2=new Thread(run,"t2");
        t1.setPriority(Thread.MIN_PRIORITY);//nice值
        t1.setDaemon(true);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        System.out.println("ok");

    }
}
