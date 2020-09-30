import static org.junit.Assert.*;

import java.util.Scanner;
import static org.junit.Assert.*;
import org.junit.Test;

@SuppressWarnings("unused")
public class CalculateTest {
	
	Calculate calculate=new Calculate();
	
	@Test
	public void testGCD() {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入两个正整数：");
		int data1 = sc.nextInt();
		int data2 = sc.nextInt();
		int result=calculate.GCD(data1, data2);
		assertEquals(1,result);
	}

	@Test
	public void testLCM() {
		Scanner sc = new Scanner(System.in);
		System.out.println("输入两个正整数：");
		int data1 = sc.nextInt();
		int data2 = sc.nextInt();
		int result=calculate.LCM(data1, data2);
		assertEquals(28,result);
	}
}
