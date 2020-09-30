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
		return "�뾶Ϊ"+getRadius()+"����Ϊ"+getHeight()+"��Բ�������Ϊ��"+getArea()+" ���Ϊ��"+getTj();
	}


	public static void main(String[] args) {
		/*
		 * ˽�г�Ա������height��double�ͣ� ���ڱ���ߣ���
		 * radius��double�ͣ����ڱ���뾶�����Լ���Ա����setRadius��getRadius�ȡ�
		 * getArea�����ڻ�ñ��������getTj�����ڻ���������
		 * print����ӡ����ĸߡ��뾶��������������Ϣ����
		 * ��main������Ҫ�󷽷���ͨ����Cylinder y1=new Cylinder();
		 *  Cylinder y2=new Cylinder(100, 20);��
		 *  �ֱ��½���Ϊ1������뾶Ϊ1�͸�Ϊ100������뾶Ϊ20��Բ�������
		 *  �ֱ��ӡy1ͬy2����Ϣ��
		 *  ��2������һ��ʵ���У����������һ��Բ�����Circle��
		 *  �������Ļ���֮�ϣ���д��д��1���е�Բ������Cylinder��
		 *  ��ʾ����������Circle��Ķ����ʾԲ����ĵף�
		 *  ˼����������֮��Ӧ���Ǽ̳л�����Ϲ�ϵ��
		 */
		
		Cylinder y1=new Cylinder();
		y1.setHeight(1);
		y1.setRadius(1);
		System.out.println(y1.toString());
		Cylinder y2=new Cylinder(100,20);
		System.out.println(y2.toString());

	}

}
