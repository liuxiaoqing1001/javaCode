
public class Calculate {
	//求最大公约数
		public int GCD(int data1,int data2) {
			int GCD=1;
			if(data2%data1 == 0) {
				GCD = data1;
			}else{
				for(int i=1;i<data1;i++){
					if(data1%i == 0 && data2%i == 0) {
						GCD = i;
					}
				}
			}
			return GCD;
		}
		
		//求最小公倍数
		public int LCM(int data1,int data2) {
			int LCM= data1*data2;
			for(int i=data2;i<LCM;i++){
				if(i%data1 == 0 && i%data2 == 0) {
					LCM = i;
				}
			}
			return LCM;
		}
}
