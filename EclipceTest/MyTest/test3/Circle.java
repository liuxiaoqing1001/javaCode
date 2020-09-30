package test3;
@SuppressWarnings("static-access")

public class Circle {
		protected static double radius;
		protected static double area;
		protected static double length;
		
		public Circle(double radius) {
			this.radius=radius;
		}

		public Circle() {
			this(0.0);
		}

		public void setRadius(double radius) {
			if(radius>=0) {
				this.radius=radius;
			}
		}
		
		public double getRadius() {
			return radius;
		}
		
		public double getArea() {
			area=Math.PI*radius*radius;
			return area;
		}
		
		public double getLength(){
			length=Math.PI*2*radius;
			return length;
		}
		
		public String toString() {
			return "�뾶Ϊ"+getRadius()+"��Բ,���Ϊ��"+getArea()+" �ܳ�Ϊ��"+getLength();

		}
	/*s
	* ˽�г�Աradius��double�ͣ����ڱ���뾶����area��double�ͣ����ڱ����������length��double�ͣ����ڱ����ܳ�����
	* �Լ���Ա����setRadius��getRadius���������á���ȡ�뾶����getArea�����ڻ���������getLength�����ڻ�ȡ�ܳ�����
	* print����ӡԲ����İ뾶��������ܳ���Ϣ����
	* a)��main������Ҫ�󷽷���ͨ����Circle c1=new Circle(); Circle c2=new Circle(100);��
	* �ֱ��½��뾶Ϊ1�Ͱ뾶Ϊ100��Բ���󣬷ֱ��ӡc1ͬc2����Ϣ��
	* ʹc2�İ뾶����c1�İ뾶��ʹc1�İ뾶����ԭc2�İ뾶���ֱ��ӡc1ͬc2����Ϣ
	 */

	public static void main(String[] args) {
		Circle c1=new Circle();
		c1.setRadius(1);
		System.out.println(c1.toString());
		Circle c2=new Circle(100);
		System.out.println(c2.toString());
	}
}
