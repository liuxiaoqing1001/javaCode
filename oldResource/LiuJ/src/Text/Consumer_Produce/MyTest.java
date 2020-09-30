package Text.Consumer_Produce;

//fork例子c++
//提炼函数：refactor->extract->method
//toString,equals,compareTo<compare接口>,hashCode，cloneable 深copy<接口>


//生产者和消费者

import java.util.LinkedList;
import java.util.List;

class Produce extends Thread{
    private List list;

    public Produce(List l){
        this.list=l;
    }

    public void run(){
        System.out.println("Produce");
        while(true){
            synchronized (list){
                if(list.size()>=MyTest.MAX_SIZE){
                    System.out.println("Produce wait");
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    list.add("Bingo");
                    System.out.println("Produce do");
                    list.notifyAll();
                }
            }
        }
    }
}

class Consumer extends Thread{
    private List list;

    public Consumer(List l){
        this.list=l;
    }

    public void run(){
        System.out.println("Consumer");
        while(true){
            synchronized (list){
                if(list.size()<=0){
                    System.out.println("Consumer wait");
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    list.remove("Bingo");
                    System.out.println("Consumer do");
                    list.notifyAll();
                }
            }
        }
    }
}

public class MyTest {
    public List list;
    final static int MAX_SIZE=5;
    public MyTest(){
        list=new LinkedList();
    }

    public static void main(String[] args) {
        MyTest mt=new MyTest();
        new Consumer(mt.list).start();
        new Produce(mt.list).start();
    }
}


//import java.util.ArrayList;
//import java.util.List;
//
//class Queue {
//    private List list = new ArrayList();
//
//    public synchronized void add(Object o) {
//        this.list.add(o);
//    }
//
//    public synchronized Object take() {
//        if (list.size() > 0) {
//            Object o = list.get(0);
//            list.remove(o);
//            return 0;
//        }
//        return null;
//    }
//}
//
//    class Myrun1 implements Runnable {
//        private Queue queue;
//
//        public Myrun1(Queue queue) {
//            this.queue = queue;
//        }
//
//        @Override
//        public void run() {
//            queue.add("h");
//        }
//    }
//
//
//    class Myrun2 implements Runnable {
//        private Queue queue;
//
//        public Myrun2(Queue queue) {
//            this.queue = queue;
//        }
//
//        @Override
//        public void run() {
//            while (true) {
//                System.out.println(queue.take());
//            }
//        }
//    }
//
//
//    public class MyTest {
//        public static void main(String[] args) {
//            Queue queue = new Queue();
//            Thread t1 = new Thread(new Myrun1(queue));
//            Thread t2 = new Thread(new Myrun2(queue));
//            t2.start();
//            t1.start();
//        }
//    }
//class MyThread extends Thread{
//
//    public void run() {
//
//    }
//}
//
//public class Test1 {
//    public  static void xxx(Object o) throws InterruptedException {
//        synchronized (o){
//            //阻塞
//            o.wait();//释放锁，睡觉sleep
//        }
//    }
//    public static void yyy(Object o){
//        synchronized (o){
//            o.notify();//唤醒
////            o.notifyAll();//产生竞争
//        }
//    }
//
//    public static void main(String[] args){
//
//    }
//}




