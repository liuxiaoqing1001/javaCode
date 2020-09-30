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
			return "半径为"+getRadius()+"的圆,面积为："+getArea()+" 周长为："+getLength();

		}
	/*s
	* 私有成员radius（double型，用于保存半径）、area（double型，用于保存面积）、length（double型，用于保存周长），
	* 以及成员方法setRadius、getRadius（用于设置、获取半径）、getArea（用于获得面积）、getLength（用于获取周长）、
	* print（打印圆对象的半径、面积、周长信息）。
	* a)在main方法，要求方法中通过“Circle c1=new Circle(); Circle c2=new Circle(100);”
	* 分别新建半径为1和半径为100的圆对象，分别打印c1同c2的信息；
	* 使c2的半径等于c1的半径，使c1的半径等于原c2的半径，分别打印c1同c2的信息
	 */

	public static void main(String[] args) {
		Circle c1=new Circle();
		c1.setRadius(1);
		System.out.println(c1.toString());
		Circle c2=new Circle(100);
		System.out.println(c2.toString());
	}
}
