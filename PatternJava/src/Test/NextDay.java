package Test;

import java.util.*;

public class NextDay {
	
	public void big(int year,int month,int day) {
		if(day+1>31){
			if(month == 12 && day == 30 || day ==31)
				year+=1;
			month=(month+1)%12;
			day = (day+1)%31;
			System.out.println(year + "��" + month + "��" + day+"��");
		}else{
			day = (day+1)%31;
			System.out.println(year + "��" + month + "��" + day+"��");
		}
	}
	
	public void small(int year,int month,int day) {
		if(day+1>30){
			month = month+1;
			day = (day+1)%30;
			System.out.println(year + "��" + month + "��" + day+"��");
		}else{
			day = day+1;
			System.out.println(year + "��" + month + "��" + day+"��");
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
					System.out.println("����������󣡣���");
					break;
				}
				else{
					if(day+1>29){
						month = month+1;
						day = (day+1)%29;
						System.out.println(year + "��" + month + "��" + day+"��");
						break;
					}else{
						day = (day+1)%29;
						System.out.println(year + "��" + month + "��" + day+"��");
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
					System.out.println("����������󣡣���");
					break;
				}else if(day+1>28){
					month = month+1;
					day = (day+1)%28;
					System.out.println(year + "��" + month + "��" + day+"��");
					break;
				}else{
					day = (day+1)%28;
					System.out.println(year + "��" + month + "��" + day+"��");
					break;
				}
		}
	}
	
	public void judge(int year,int month,int day) {
		if(year>2050 || year<1920 || month>12 || month<1 || day>31 || day<1){
			System.out.println("����������󣡣���");
		}else{
			if((year%4==0 && year%100!=0) || year%400==0){
				//����
				leap(year,month,day);
			}else{
				//������
				nonLeap(year,month,day);
			}
		}
	}
 
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("��������ݣ�");
			int year = sc.nextInt();
			System.out.println("�������·ݣ�");
			int month = sc.nextInt();
			System.out.println("�����뼸�ţ�");
			int day = sc.nextInt();
			NextDay nextDay=new NextDay();
			nextDay.judge(year, month, day);
		}catch(Exception e){
			System.out.println("�������ֵ�����Ϲ涨");
		}
	}
}
