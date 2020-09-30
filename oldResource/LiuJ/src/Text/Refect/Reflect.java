package Text.Refect;

import java.lang.reflect.*;

public class Reflect{

    public static void attribute(Class c) {
        Field fields[] = c.getDeclaredFields();
        for (Field f : fields) {
            String m = Modifier.toString(f.getModifiers());
            Class type = f.getType();
            String t = type.getName();
            String n = f.getName();
            System.out.println(m + " " + t + " " + n);
        }
    }

    public static void constructors(Class c) {
        Constructor[] cons = c.getDeclaredConstructors();
        for (Constructor con : cons) {
            String m = Modifier.toString(con.getModifiers());
            String n = con.getName();
            System.out.print(m + " " + n + "(");
            Class[] params = con.getParameterTypes();
            for (int j = 0; j < params.length; j++) {
                if (j == params.length - 1) {
                    System.out.print(params[j].getSimpleName());
                } else
                    System.out.print(params[j].getSimpleName() + ",");
            }
            System.out.println(")");
        }
    }

    public static void methods(Class c) {
        Method[] m = c.getMethods();
        for (int i = 0; i < m.length; i++) {
            String modify = Modifier.toString(m[i].getModifiers());
            System.out.print(modify + " ");
            Class returntype = m[i].getReturnType();
            System.out.print(returntype.getName() + " ");
            String name = m[i].getName();
            System.out.print(name + "(");
            Class[] params = m[i].getParameterTypes();
            for (int j = 0; j < params.length; j++) {
                if (j == params.length - 1) {
                    System.out.print(params[j].getSimpleName());
                } else
                    System.out.print(params[j].getSimpleName() + ",");
            }
            System.out.println(")");
        }
    }


    public static void main(String[] args) {

//        try {
////            Reflect reflect=new Reflect();
////            System.out.println(reflect instanceof Object);
////            System.out.println(reflect.getClass()==new Object().getClass());
//            Class c = Class.forName("Work.Other.Students");// X
//            Constructor cc=c.getConstructor();
//            Test0717 t1 = (Test0717) cc.newInstance();
//            Test0717 t = (Test0717) c.newInstance(); // 反射相应的一个子类对象
//
//
//            t.show(); // 动态运行不同类的方法
//            Test0717 s = new Students(); // X Class
//            Class xc = Class.forName("Work.Other.Input");
//            System.out.println(xc.isInstance(s));// true
//            System.out.println(t instanceof Test0717); // true
////            System.out.println(t instanceof X); // false
////            System.out.println(t instanceof Y);// true
////            System.out.println(t.getClass()==Y.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            String className = "Work.Other.Students";
            Class c = Class.forName(className);
            attribute(c);
            constructors(c);
            methods(c);

            String className1 = "Work.Other.Input";
            Class c1 = Class.forName(className1);
            attribute(c1);
            constructors(c1);
            methods(c1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}