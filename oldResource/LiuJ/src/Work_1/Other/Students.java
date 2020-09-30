package Work_1.Other;

public class Students implements Test0717 {
    private String name;
    private int id;
    private int age;
    private String school;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Students() {
    }

    public Students(String name, int id,int age,String school) {
        this.name = name;
        this.id=id;
        this.age = age;
        this.school=school;
    }

    public void show() {
        System.out.println("name="+this.name+" age="+this.age+" id="+this.id+" school="+this.school);
    }
}
