package Work_1.Other;


//张家梁的例子
//import java.io.*;
//import java.lang.reflect.InvocationTargetException;
//
//public class TestClassLoader {
//    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        ReadConfig readConfig = new ReadConfig();
//        try {
//            readConfig.read("config","src/org/configread/Cconfig.java");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        String cmd = "javac  ~/桌面/untitled/src/org/configread/C*.java";
//        Process p = Runtime.getRuntime().exec(cmd);
////        Process p = Runtime.getRuntime().exec("src/org/configread/Run.sh");
//        int A = p.waitFor();
//        System.out.println(A);
//
//        MyClassLoader myClassLoader = new MyClassLoader();
//        Class configClass = myClassLoader.loadClass("org.configread.Cconfig");
//        ConfigInter configInter = (ConfigInter)configClass.newInstance();
//        ConfigInter configInter1 = (ConfigInter)configClass.newInstance();
//
//        String[] s = readConfig.readWri("config1");
//        String[] s1 = readConfig.readWri("config2");
//
//        for (int i = 0; i < s.length; i++) {
//            configInter.setSize(Integer.parseInt(s[0]));
//            configInter.setHight(Double.parseDouble(s[1]));
//            configInter.setLength(Float.parseFloat(s[2]));
//
//            configInter1.setSize(Integer.parseInt(s1[0]));
//            configInter1.setHight(Double.parseDouble(s1[1]));
//            configInter1.setLength(Float.parseFloat(s1[2]));
//
//        }
//        configInter.dis();
//        configInter1.dis();
//
//
//
//
////
////        Method method = configClass.getMethod("getSize");
////        int s = (int)method.invoke(configClass.newInstance());
////        System.out.println(s);
//
//
//    }
//}
//
//
//class ReadConfig{
//    private FileReader fileReader;
//    private FileWriter fileWriter;
//    private BufferedReader bufferedReader;
//    private StringBuilder stringBuilder;
//
//    public void read(String contentRead, String contentWrite) throws IOException {
//        File fileReaded = new File(contentRead);
//        File fileWrited = new File(contentWrite);
//
//
//        try {
//
//            fileReader = new FileReader(fileReaded);
//            fileWriter = new FileWriter(fileWrited);
//            bufferedReader = new BufferedReader(fileReader);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        byte[] bytes = new byte[100];
//
//        String tmp = "";
//        String className = fileReaded.getName();
//        stringBuilder = new StringBuilder(className);
//        char c1 = (char)(stringBuilder.charAt(0)-32);
//        stringBuilder.deleteCharAt(0);
//        stringBuilder.insert(0,c1);
//        className = stringBuilder.toString();
//
//        fileWriter.append("package org.configread;\n\n");
//        fileWriter.append("public class "+"Cconfig "+ "implements org.configread.ConfigInter{\n");
//        fileWriter.flush();
//
//        String disString = "    public void dis(){\n";
//
//        while((tmp = bufferedReader.readLine()) != null){
//            String[] strings = tmp.split(" ");
//            int lengthType = strings[1].length();
//
//            fileWriter.append("    private "+strings[1]+" "+strings[0]+";\n\n");
//
//            char c = (char)(strings[0].charAt(0)-32);
//            String stringSet = "    public void set"+strings[0]+"("+strings[1]+" "+strings[0]+")"+"{\n";
//            String stringGet = "    public "+strings[1]+" get"+strings[0]+"(){\n";
//
//            String stringSet2 = "    public void set"+strings[0]+"("+strings[1]+" "+strings[0]+")"+";\n";
//            String stringGet2 = "    public "+strings[1]+" get"+strings[0]+"();\n";
//
//            stringBuilder = new StringBuilder(stringSet);
//            stringBuilder.deleteCharAt(19);
//            stringBuilder.insert(19,c);
//            stringSet = stringBuilder.toString();
//
//            stringBuilder = new StringBuilder(stringGet);
//            stringBuilder.deleteCharAt(11+lengthType+4);
//            stringBuilder.insert(11+lengthType+4,c);
//            stringGet = stringBuilder.toString();
//
//            fileWriter.append(stringSet);
//            fileWriter.append("        this."+strings[0]+" = "+strings[0]+";\n"+"    }\n");
//
//            fileWriter.append(stringGet);
//            fileWriter.append("        return "+strings[0]+";\n"+"    }\n");
//
//            fileWriter.flush();
//
//            fileWriter.append("\n");
//
//            stringBuilder = new StringBuilder(disString);
//            stringBuilder.append("        System.out.println(\""+strings[0]+"\""+"+"+"\":\""+"+this."+strings[0]+");\n");
//            disString = stringBuilder.toString();
//
//        }
//        stringBuilder = new StringBuilder(disString);
//        stringBuilder.append("    }\n");
//        disString = stringBuilder.toString();
//        fileWriter.write(disString);
//        fileWriter.append("}");
//        fileWriter.flush();
//
//
//    }
//
//    public String[] readWri(String string) throws IOException {
//        FileReader fileReader = new FileReader(string);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        String tmp = "";
//        String string1 = "";
//        stringBuilder = new StringBuilder(string1);
//        while ((tmp = bufferedReader.readLine()) != null){
//            stringBuilder.append(tmp +" ");
//        }
//        String[] tmps = stringBuilder.toString().split(" ");
//        for (String s:tmps) System.out.println(s);
//        return tmps;
//    }
//}
//
//class MyClassLoader extends java.lang.ClassLoader{
//    private FileInputStream fileInputStream;
//
//    @Override
//    protected Class<?> findClass(String name) {
//
//        File file = new File("out/Cconfig.class");
//        System.out.println(file.exists());
//        byte[] reader = new byte[(int)file.length()];
//
//        try {
//            fileInputStream = new FileInputStream(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            fileInputStream.read(reader);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Class<?> clazz = defineClass(name,reader,0,reader.length);
//        return clazz;
//
//    }
//}
//










//错误代码

import java.io.*;
import java.lang.reflect.Method;

public class TestClassLoader{


    public static class CompileClassLoader extends ClassLoader {
        private byte[] getBytes(String filename)
                throws IOException {
            File file = new File(filename);
            long len = file.length();
            byte[] raw = new byte[(int) len];
            try (
                    FileInputStream fin = new FileInputStream(file)) {
                int r = fin.read(raw);
                if (r != len)
                    throw new IOException("无法读取全部文件："
                            + r + " != " + len);
                return raw;
            }
        }

        private boolean compile(String javaFile)
                throws IOException {
            System.out.println("CompileClassLoader:正在编译 "
                    + javaFile + "...");
            Process p = Runtime.getRuntime().exec("javac " + javaFile);
            try {
                p.waitFor();
            } catch (InterruptedException ie) {
                System.out.println(ie);
            }

            int ret = p.exitValue();

            return ret == 0;
        }


        @Override
        protected Class<?> findClass(String name)
                throws ClassNotFoundException {
            Class clazz = null;

            String fileStub = name.replace(".", "/");
            String javaFilename = fileStub + ".java";
            String classFilename = fileStub + ".class";
            File javaFile = new File(javaFilename);
            File classFile = new File(classFilename);

            if (javaFile.exists() && (!classFile.exists()
                    || javaFile.lastModified() > classFile.lastModified())) {
                try {

                    if (!compile(javaFilename) || !classFile.exists()) {
                        throw new ClassNotFoundException(
                                "ClassNotFoundExcetpion:" + javaFilename);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            if (classFile.exists()) {
                try {
                    byte[] raw = getBytes(classFilename);
                    clazz = defineClass(name, raw, 0, raw.length);
                } catch (IOException ie) {
                    ie.printStackTrace();
                }
            }

            if (clazz == null) {
                throw new ClassNotFoundException(name);
            }
            return clazz;
        }


        public static void main(String[] args) throws Exception {
//        String progClass = "org.classload.Hello";

            String progClass = "Work.Other.Input";
            String[] progArgs = {"aaa", "bbb"};
            CompileClassLoader ccl = new CompileClassLoader();

            Class<?> clazz = ccl.loadClass(progClass);

            Method main = clazz.getMethod("main", (new String[0]).getClass());
            Object[] argsArray = {progArgs};
            main.invoke(null, argsArray);
        }
    }

}