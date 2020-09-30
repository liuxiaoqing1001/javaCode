package Text;

class Person{
    public void getP(){
        System.out.println("Person");
    }
}

class Student extends Person{
    public void getP(){
        System.out.println("Student");
    }
}

public class Test {
    public static void main(String[] args){
        Student s=new Student();
        s.getP();
    }
}
