package Test;

import java.util.*;

public class NextDay {
	
	public void big(int year,int month,int day) {
		if(day+1>31){
			if(month == 12 && day == 30 || day ==31)
				year+=1;
			month=(month+1)%12;
			day = (day+1)%31;
			System.out.println(year + "年" + month + "月" + day+"日");
		}else{
			day = (day+1)%31;
			System.out.println(year + "年" + month + "月" + day+"日");
		}
	}
	
	public void small(int year,int month,int day) {
		if(day+1>30){
			month = month+1;
			day = (day+1)%30;
			System.out.println(year + "年" + month + "月" + day+"日");
		}else{
			day = day+1;
			System.out.println(year + "年" + month + "月" + day+"日");
		}
	}
	
	public void leap(int year,int month,int day) {
		switch(month){
			case 1:case 3:case 5:case 7:case 8:case 10:case 12:
				big(year,month,day);
				break;
			case 4:case 6:case 9:case 11:
				small(year,month,day);
				break;
			case 2:
				if(day>29){
					System.out.println("数据输入错误！！！");
					break;
				}
				else{
					if(day+1>29){
						month = month+1;
						day = (day+1)%29;
						System.out.println(year + "年" + month + "月" + day+"日");
						break;
					}else{
						day = (day+1)%29;
						System.out.println(year + "年" + month + "月" + day+"日");
						break;
					}
				}
		}
	}
	
	public void nonLeap(int year,int month,int day) {
		switch(month){
			case 1:case 3:case 5:case 7:case 8:case 10:case 12:
				big(year,month,day);
				break;
			case 4:case 6:case 9:case 11:
				small(year,month,day);
				break;
			case 2:
				if(day>28){
					System.out.println("数据输入错误！！！");
					break;
				}else if(day+1>28){
					month = month+1;
					day = (day+1)%28;
					System.out.println(year + "年" + month + "月" + day+"日");
					break;
				}else{
					day = (day+1)%28;
					System.out.println(year + "年" + month + "月" + day+"日");
					break;
				}
		}
	}
	
	public void judge(int year,int month,int day) {
		if(year>2050 || year<1920 || month>12 || month<1 || day>31 || day<1){
			System.out.println("数据输入错误！！！");
		}else{
			if((year%4==0 && year%100!=0) || year%400==0){
				//闰年
				leap(year,month,day);
			}else{
				//非闰年
				nonLeap(year,month,day);
			}
		}
	}
 
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入年份：");
			int year = sc.nextInt();
			System.out.println("请输入月份：");
			int month = sc.nextInt();
			System.out.println("请输入几号：");
			int day = sc.nextInt();
			NextDay nextDay=new NextDay();
			nextDay.judge(year, month, day);
		}catch(Exception e){
			System.out.println("输入的数值不符合规定");
		}
	}
}
