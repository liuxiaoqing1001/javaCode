//package Work.Other;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.JUnitCore;
//import org.junit.runner.Result;
//import org.junit.runner.notification.Failure;
//
//import java.util.Scanner;
//
//import static org.junit.Assert.assertEquals;
//
//public class MyJunit {
//
//    @Test
//    public void equals(){
//        String string;
//        string="hello";
//        assertEquals("hello", string);
////        相当于-->
////        Scanner scanner=new Scanner(System.in);
////        if(string.equals(scanner.nextLine())){
////            System.out.println("true");
////        }else{
////            System.out.println("false");
////        }
//    }
//
//    public static void main(String[] args) {
//        Result result = JUnitCore.runClasses(MyJunit.class);
//        for (Failure failure : result.getFailures()) {
//            System.out.println(failure.toString());
//        }
//        System.out.println(result.wasSuccessful());
//    }
//}
