package test3;
public class Cylinder extends Circle {
	private double height;
	
	public Cylinder(double radius,double height){
		super(radius);
		this.height=height;
	}
	
	public Cylinder(){
		super();
		height=0;
	}
	
	public void setHeight(double height) {
		if(height>=0) {
			this.height=height;
		}
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getArea() {
		 return (area)*2+(length)*height;
	}
	
	public double getTj() {
		return (Circle.area)*height;
		
	}
	
	public String toString() {
		return "半径为"+getRadius()+"，高为"+getHeight()+"的圆柱表面积为："+getArea()+" 体积为："+getTj();
	}


	public static void main(String[] args) {
		/*
		 * 私有成员变量：height（double型， 用于保存高）、
		 * radius（double型，用于保存半径），以及成员方法setRadius、getRadius等、
		 * getArea（用于获得表面积）、getTj（用于获得体积）、
		 * print（打印对象的高、半径、体积、底面积信息）。
		 * 在main方法，要求方法中通过“Cylinder y1=new Cylinder();
		 *  Cylinder y2=new Cylinder(100, 20);”
		 *  分别新建高为1、底面半径为1和高为100，底面半径为20的圆柱体对象，
		 *  分别打印y1同y2的信息；
		 *  （2）在上一节实验中，曾经定义过一个圆面积类Circle，
		 *  请在它的基础之上，重写编写（1）中的圆柱体类Cylinder。
		 *  提示，可以利用Circle类的对象表示圆柱体的底，
		 *  思考这两个类之间应该是继承还是组合关系。
		 */
		
		Cylinder y1=new Cylinder();
		y1.setHeight(1);
		y1.setRadius(1);
		System.out.println(y1.toString());
		Cylinder y2=new Cylinder(100,20);
		System.out.println(y2.toString());

	}

}
