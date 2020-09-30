//package Work.Other;
//
//import org.dom4j.Document;
//import org.dom4j.DocumentHelper;
//import org.dom4j.Element;
//import org.dom4j.io.OutputFormat;
//import org.dom4j.io.XMLWriter;
//
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.Serializable;
//
//
//public class MyXml implements Serializable {
//
//    public void creatXml()throws Exception{
//
////dom4j方式
//        //创建文档（Document）
//        Document document= DocumentHelper.createDocument();
//
//        //添加元素（Element）
//        Element person=document.addElement("Person");
//        Element student=person.addElement("Student");
//
//        //添加属性（Attribute）
//        student.addAttribute("id", "12");
//
//        Element name=student.addElement("name");
//        Element age=student.addElement("age");
//        Element school=student.addElement("school");
//
//        //给元素赋值
//        name.setText("刘");
//        age.setText("20");
//        school.setText("毕节四高");
//
//        //生成xml格式（format）
//        OutputFormat format=OutputFormat.createPrettyPrint();
//
//        //生成不一样的编码
//        format.setEncoding("UTF-8");
//
//        //生成xml文件
//        File file=new File("Message.xml");
//        XMLWriter writer=new XMLWriter(new FileOutputStream(file),format);
//
//        //设置是否转义，默认设置是true,代表转义
//        writer.setEscapeText(false);
//        writer.write(document);
//        writer.close();
//
//    }
//    public static void main(String[] args) throws Exception {
//        MyXml myXml=new MyXml();
//        myXml.creatXml();
//
//        //反序列化
//
////        File file=new File("Message.xml");
////        XMLResult read=new XMLResult(new FileInputStream(file));
////        read.getXMLWriter();
//        //
//    }
//}
