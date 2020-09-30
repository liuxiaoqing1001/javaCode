package Test;

class Student{
    private int sID;
    private String sName;

    public int getsID() {
        return sID;
    }

    public void setsID(int sID) {
        this.sID = sID;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Student(int sID, String sName) {
        this.sID=sID;
        this.sName=sName;
    }
}

class Teacher{
    private int tID;
    private String tName;
    private Student haveS;

    public int gettID() {
        return tID;
    }

    public void settID(int tID) {
        this.tID = tID;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public Student getHaveS() {
        return haveS;
    }

    public void setHaveS(Student haveS) {
        this.haveS = haveS;
    }

    public Teacher(int tID, String tName) {
        this.tID=tID;
        this.tName=tName;
    }
}

public class Test1 {

    public static void query(Teacher teacher,String name){
        if(teacher.getHaveS().getsName()==teacher.gettName()){
               System.out.println(teacher.getHaveS().getsName());
            }
        }

    public static void main(String[] args) {
        Student student=new Student(1,"A");
        Student student1=new Student(2,"b");
        Student student2=new Student(3,"c");
        Teacher teacher=new Teacher(1,"A");
        Teacher teacher1=new Teacher(2,"B");
        teacher.setHaveS(student);
        teacher.setHaveS(student1);
        query(teacher,teacher.gettName());
    }
}
