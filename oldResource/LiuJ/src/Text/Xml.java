//package Text;
//
//
//
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import org.dom4j.Attribute;
//import org.dom4j.Document;
//import org.dom4j.DocumentHelper;
//import org.dom4j.Element;
//import org.dom4j.io.OutputFormat;
//import org.dom4j.io.SAXReader;
//import org.dom4j.io.XMLWriter;
//
//
//
//
//class Book {
//    private String id;
//    private String name;
//    private String author;
//    private String year;
//    private String price;
//    private String language;
//    public String getId() {
//        return id;
//    }
//    public void setId(String id) {
//        this.id = id;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public String getAuthor() {
//        return author;
//    }
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//    public String getYear() {
//        return year;
//    }
//    public void setYear(String year) {
//        this.year = year;
//    }
//    public String getPrice() {
//        return price;
//    }
//    public void setPrice(String price) {
//        this.price = price;
//    }
//    public String getLanguage() {
//        return language;
//    }
//    public void setLanguage(String language) {
//        this.language = language;
//    }
//
//
//}
//
//public class Xml {
//    private static ArrayList<Book> bookList=new ArrayList<Book>();
//
//    private void parseXML() throws Exception {
//        // 解析books.xml文件
//        // 创建SAXReader的对象reader
//        SAXReader reader = new SAXReader();
//        // 通过reader对象的read方法加载books.xml文件，获取document对象
//        Document document = reader.read(new File("src/res/books.xml"));
//        // 通过Element对象获取根节点bookstore
//        Element bookStore = document.getRootElement();
//        // 通过Element对象的elementIterator()方法获取迭代器
//        Iterator it = bookStore.elementIterator();
//        // 遍历迭代器，获取根节点中的信息（书籍）
//        while (it.hasNext()) {
//            System.out.println("===========开始遍历某一本书===========");
//            Element book = (Element) it.next();
//            // 获取book的属性名以及属性值
//            List<Attribute> bookAttrs = book.attributes();
//            for (Attribute attr : bookAttrs) {
//                System.out.println("属性名：" + attr.getName() + "----属性值："+ attr.getValue());
//            }
//            Iterator itt = book.elementIterator();
//            while (itt.hasNext()) {
//                Element bookChild = (Element) itt.next();
//                System.out.println("节点名：" + bookChild.getName() + "节点值："+ bookChild.getStringValue());
//            }
//            System.out.println("===========结束遍历某一本书===========");
//        }
//
//    }
//
//    private void createXML() throws Exception{
//        //1.创建document对象，代表整个xml文档
//        Document document=DocumentHelper.createDocument();
//        //2.创建根节点
//        Element rss=document.addElement("rss");
//        //3.向rss节点中添加version，自动生成默认编码模式（UTF-8）
//        rss.addAttribute("version", "2.0");
//        //4.生成子节点及节点内容
//        Element channel=rss.addElement("channel");
//        Element title=channel.addElement("title");
//        //title.setText("中国最新新闻");
//        title.setText("<!CDATA上海移动互联网产业促进中心正式揭牌]]>");
//        //5.设置生成xml的格式
//        OutputFormat format=OutputFormat.createPrettyPrint();
//        //生成不一样的编码
//        format.setEncoding("GBK");
//        //6.生成xml文件
//        File file=new File("rssnews.xml");
//        XMLWriter writer=new XMLWriter(new FileOutputStream(file),format);
//        //设置是否转义，默认设置是true,代表转义
//        writer.setEscapeText(false);
//        writer.write(document);
//        writer.close();
//    }
//    /**
//     * @param args
//     */
//    public static void main(String[] args) throws Exception{
//        new Xml().createXML();
//    }
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
////import java.io.File;
////import java.io.FileOutputStream;
////import javax.xml.parsers.DocumentBuilder;
////import javax.xml.parsers.DocumentBuilderFactory;
////import javax.xml.transform.OutputKeys;
////import javax.xml.transform.Result;
////import javax.xml.transform.Transformer;
////import javax.xml.transform.TransformerFactory;
////import javax.xml.transform.dom.DOMSource;
////import javax.xml.transform.sax.SAXTransformerFactory;
////import javax.xml.transform.sax.TransformerHandler;
////import javax.xml.transform.stream.StreamResult;
////import org.w3c.dom.Document;
////import org.w3c.dom.Element;
////import org.xml.sax.helpers.AttributesImpl;
////
////public class Xml {
////    /**
////     * DOM方式生成xml文档
////     */
////    public void DOMCreateXML() throws Exception{
////        // 创建一个DocumentBuilderFactory
////        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
////        // 创建一个DocumentBuilder对象
////        DocumentBuilder db = dbf.newDocumentBuilder();
//////        DocumentBuilder db=getDocumentBuilder();
////        Document document=db.newDocument();
////        document.setXmlStandalone(true);
////        Element bookstore=document.createElement("bookStore");
////        //向bookstore根节点中添加字节点book
////        Element book=document.createElement("book");
////        Element name=document.createElement("name");
////        book.appendChild(name);
////        name.setTextContent("小王子");
////        book.setAttribute("id", "1");
////        //将book节点添加到bookstore根节点中
////        bookstore.appendChild(book);
////        //将bookstore节点（已经包含了book）,添加到dom树中
////        document.appendChild(bookstore);
////        //创建TransformerFactory对象
////        TransformerFactory tff=TransformerFactory.newInstance();
////        //创建Transformer对象
////        Transformer tf=tff.newTransformer();
////        //换行文件内容
////        tf.setOutputProperty(OutputKeys.INDENT, "yes");
////        tf.transform(new DOMSource(document), new StreamResult(new File("books1.xml")));
////    }
////
////    /**
////     * SAX方式生成xml文档
////     */
////
////    public void SAXCreateXML() throws Exception{
////        //生成XML
////        //1.创建一个TransformerFactory类的对象
////        SAXTransformerFactory tff=(SAXTransformerFactory) SAXTransformerFactory.newInstance();
////        //2.通过SAXTransformerFactory对象创建一个TransformerHandler对象
////        TransformerHandler handler=    tff.newTransformerHandler();
////        //3.通过handler对象创建一个Transformer
////        Transformer tr=handler.getTransformer();
////        //4.通过Transformer对象对生成的xml文件进行设置
////        //设置xml的编码
////        tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
////        //设置xml的“是否换行”
////        tr.setOutputProperty(OutputKeys.INDENT, "yes");
////        //5.创建一个Result对象
////        File file=new File("books2.xml");
////        if (!file.exists()) {
////            file.createNewFile();
////        }
////        //6.创建Result对象，并且使其与handler关联
////        Result result=new StreamResult(new FileOutputStream(file));
////        handler.setResult(result);
////        //7.利用handler对象进行xml文件内容的编写
////        //打开document
////        handler.startDocument();
////        AttributesImpl attr=new AttributesImpl();
////        handler.startElement("", "", "bookstore", attr);
////        attr.clear();
////        attr.addAttribute("", "", "id", "", "1");
////        handler.startElement("", "", "book", attr);
////        attr.clear();
////        handler.startElement("", "", "name", attr);
////        handler.characters("小王子".toCharArray(), 0, "小王子".length());
////        handler.endElement("", "", "name");
////        handler.endElement("", "", "book");
////        handler.endElement("", "", "bookstore");
////        // 关闭document
////        handler.endDocument();
////    }
////
////    /**
////     * DOM4J方式生成xml文档
////     */
////    private void DOM4JCreateXML() throws Exception{
////        org.dom4j.Document document=DocumentHelper.createDocument();
////        org.dom4j.Element bookstore=document.addElement("bookstore");
////        org.dom4j.Element book=bookstore.addElement("book");
////        book.addAttribute("id", "1");
////        org.dom4j.Element name=book.addElement("name");
////        name.setText("小王子");
////        OutputFormat format=OutputFormat.createPrettyPrint();
////        //生成不一样的编码
////        format.setEncoding("UTF-8");
////        //6.生成xml文件
////        File file=new File("books4.xml");
////        XMLWriter writer=new XMLWriter(new FileOutputStream(file),format);
////        //设置是否转义，默认设置是true,代表转义
////        writer.setEscapeText(false);
////        writer.write(document);
////        writer.close();
////    }
////
////    public void testPerformance() throws Exception{
////        System.out.println("性能测试：");
////        //测试DOM的性能
////        long start=System.currentTimeMillis();
////        DOMCreateXML();
////        System.out.println("DOM:"+(System.currentTimeMillis()-start));
////
////        //测试SAX的性能
////        start=System.currentTimeMillis();
////        SAXCreateXML();
////        System.out.println("SAX:"+(System.currentTimeMillis()-start));
////
////    }
////
////
////    public static void main(String[] args) throws Exception {
////        Xml x=new Xml();
////        x.testPerformance();
////    }
////}
//
//
//
//
//
//
////SAX生成xml文件
//
//
//
////import java.io.File;
////import java.io.FileOutputStream;
////import java.util.ArrayList;
////import javax.xml.parsers.SAXParser;
////import javax.xml.parsers.SAXParserFactory;
////import javax.xml.transform.OutputKeys;
////import javax.xml.transform.Result;
////import javax.xml.transform.Transformer;
////import javax.xml.transform.sax.SAXTransformerFactory;
////import javax.xml.transform.sax.TransformerHandler;
////import javax.xml.transform.stream.StreamResult;
////import org.xml.sax.SAXException;
////import org.xml.sax.helpers.AttributesImpl;
////import org.xml.sax.Attributes;
////import org.xml.sax.helpers.DefaultHandler;
////
////
////
////
////class Book {
////
////    private String id;
////    private String name;
////    private String author;
////    private String year;
////    private String price;
////    private String language;
////    public String getId() {
////        return id;
////    }
////    public void setId(String id) {
////        this.id = id;
////    }
////    public String getName() {
////        return name;
////    }
////    public void setName(String name) {
////        this.name = name;
////    }
////    public String getAuthor() {
////        return author;
////    }
////    public void setAuthor(String author) {
////        this.author = author;
////    }
////    public String getYear() {
////        return year;
////    }
////    public void setYear(String year) {
////        this.year = year;
////    }
////    public String getPrice() {
////        return price;
////    }
////    public void setPrice(String price) {
////        this.price = price;
////    }
////    public String getLanguage() {
////        return language;
////    }
////    public void setLanguage(String language) {
////        this.language = language;
////    }
////
////}
////
////
////
////
////
////
////class SAXParserHandler extends DefaultHandler{
////    Book book=null;
////    String value=null;
////    private ArrayList<Book> bookList=new ArrayList<Book>();
////    public ArrayList<Book> getBookList(){
////        return bookList;
////
////    }
////    /*用来标识解析开始*/
////    @Override
////    public void startDocument() throws SAXException {
////        // TODO Auto-generated method stub
////        super.startDocument();
////        System.out.println("SAX解析开始");
////    }
////
////    /*用来标识解析结束*/
////    @Override
////    public void endDocument() throws SAXException {
////        // TODO Auto-generated method stub
////        super.endDocument();
////        System.out.println("SAX解析结束");
////    }
////
////    /*开始解析XML元素*/
////    @Override
////    public void startElement(String uri, String localName, String qName,
////                             Attributes attributes) throws SAXException {
////        //调用DefaultHandler类的startElement方法
////        super.startElement(uri, localName, qName, attributes);
////        if (qName.equals("book")) {
////            //创建一个book对象
////            book=new Book();
////            //开始解析book元素的属性
////            System.out.println("============开始遍历某一本书的内容==============");
////            //已知book元素下属性的名称，根据属性名称获取属性值
////            value=attributes.getValue("id");
////            System.out.println("book的属性值是："+value);
////            //不知道book元素下属的名称以及个数，如何获取属性名以及属性值
////            int num=attributes.getLength();
////            for (int i = 0; i < num; i++) {
////                System.out.println("book元素的第"+(i+1)+"个属性名是"+attributes.getQName(i));
////                System.out.println("---属性值是："+attributes.getValue(i));
////                if (attributes.getQName(i).equals("id")) {
////                    book.setId(attributes.getValue(i));
////
////                }
////
////            }
////
////        }else if (!qName.equals("name") && !qName.equals("bookstore")) {
////            System.out.println("节点名是："+qName+"----");
////
////        }
////    }
////
////    /*结束解析XML元素*/
////    @Override
////    public void endElement(String uri, String localName, String qName)
////            throws SAXException {
////        //调用DefaultHandler类的endElement方法
////        super.endElement(uri, localName, qName);
////        //判断是否针对一本书已经遍历结束
////        if (qName.equals("book")) {
////            bookList.add(book);
////            book=null;
////            System.out.println("==========结束遍历某一本书的内容============");
////        }else if (qName.equals("name")) {
////            book.setName(value);
////        }else if (qName.equals("author")) {
////            book.setAuthor(value);
////        }else if (qName.equals("year")) {
////            book.setYear(value);
////        }else if (qName.equals("price")) {
////            book.setPrice(value);
////        }else if (qName.equals("language")) {
////            book.setLanguage(value);
////        }
////    }
////    @Override
////    public void characters(char[] ch, int start, int length)
////            throws SAXException {
////        // TODO Auto-generated method stub
////        super.characters(ch, start, length);
////        value=new String(ch, start, length);
////        if (!value.trim().equals("")) {
////            System.out.println("节点值是："+value);
////        }
////    }
////
////}
////
////public class Xml {
////    public ArrayList<Book> parseXML() throws Exception{
////        // 获取一个SAXTransformerFactory的实例
////        SAXParserFactory factory = SAXParserFactory.newInstance();
////        // 通过factory获取SAXParser实例
////        SAXParser parser = factory.newSAXParser();
////        // 创建SAXParserHandler对象
////        SAXParserHandler handler = new SAXParserHandler();
////        parser.parse("books.xml", handler);
////        /*System.out.println("!~!~共有" + handler.getBookList().size() + "本书");
////        for (Book book : handler.getBookList()) {
////            System.out.println(book.getId());
////            System.out.println(book.getName());
////            System.out.println(book.getAuthor());
////            System.out.println(book.getYear());
////            System.out.println(book.getPrice());
////            System.out.println(book.getLanguage());
////            System.out.println("--------------finish--------------");
////        }*/
////        return handler.getBookList();
////    }
////    public void createXML() throws Exception{
////        ArrayList<Book> booklist=parseXML();
////        //生成XML
////        //1.创建一个TransformerFactory类的对象
////        SAXTransformerFactory tff=(SAXTransformerFactory) SAXTransformerFactory.newInstance();
////        //2.通过SAXTransformerFactory对象创建一个TransformerHandler对象
////        TransformerHandler handler=    tff.newTransformerHandler();
////        //3.通过handler对象创建一个Transformer
////        Transformer tr=handler.getTransformer();
////        //4.通过Transformer对象对生成的xml文件进行设置
////        //设置xml的编码
////        tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
////        //设置xml的“是否换行”
////        tr.setOutputProperty(OutputKeys.INDENT, "yes");
////        //5.创建一个Result对象
////        File file=new File("src/res/newbooks.xml");
////        if (!file.exists()) {
////            file.createNewFile();
////        }
////        //6.创建Result对象，并且使其与handler关联
////        Result result=new StreamResult(new FileOutputStream(file));
////        handler.setResult(result);
////        //7.利用handler对象进行xml文件内容的编写
////        //打开document
////        handler.startDocument();
////        AttributesImpl attr=new AttributesImpl();
////        handler.startElement("", "", "bookstore", attr);
////        for (Book book : booklist) {
////            attr.clear();
////            attr.addAttribute("", "", "id", "", book.getId());
////            handler.startElement("", "", "book", attr);
////
////            //创建name节点
////            if (book.getName()!=null && !book.getName().trim().equals("")) {
////                attr.clear();
////                handler.startElement("", "", "name", attr);
////                handler.characters(book.getName().toCharArray(), 0, book.getName().length());
////                handler.endElement("", "", "name");
////            }
////
////            //创建year节点
////            if (book.getYear()!=null && !book.getYear().trim().equals("")) {
////                attr.clear();
////                handler.startElement("", "", "year", attr);
////                handler.characters(book.getYear().toCharArray(), 0, book.getYear().length());
////                handler.endElement("", "", "year");
////            }
////
////            //创建author节点
////            if (book.getAuthor()!=null && !book.getAuthor().trim().equals("")) {
////                attr.clear();
////                handler.startElement("", "", "author", attr);
////                handler.characters(book.getAuthor().toCharArray(), 0, book.getAuthor().length());
////                handler.endElement("", "", "author");
////            }
////
////            //创建price节点
////            if (book.getPrice()!=null && !book.getPrice().trim().equals("")) {
////                attr.clear();
////                handler.startElement("", "", "price", attr);
////                handler.characters(book.getPrice().toCharArray(), 0, book.getPrice().length());
////                handler.endElement("", "", "price");
////            }
////
////            //创建language节点
////            if (book.getLanguage()!=null && !book.getLanguage().trim().equals("")) {
////                attr.clear();
////                handler.startElement("", "", "language", attr);
////                handler.characters(book.getLanguage().toCharArray(), 0, book.getLanguage().length());
////                handler.endElement("", "", "language");
////            }
////
////
////            handler.endElement("", "", "book");
////        }
////        handler.endElement("", "", "bookstore");
////        //关闭document
////        handler.endDocument();
////    }
////
////    public static void main(String[] args) throws Exception {
////        Xml test=new Xml();
////        test.createXML();
////    }
////}
//
//
//
//
//
////DOM4J生成xml文件
//
////import java.io.File;
////import org.w3c.dom.Document;
////import org.w3c.dom.Element;
////import javax.xml.parsers.DocumentBuilder;
////import javax.xml.parsers.DocumentBuilderFactory;
////import javax.xml.transform.OutputKeys;
////import javax.xml.transform.Transformer;
////import javax.xml.transform.TransformerFactory;
////import javax.xml.transform.dom.DOMSource;
////import javax.xml.transform.stream.StreamResult;
////
////public class Xml {
////    public DocumentBuilder getDocumentBuilder() throws Exception{
////        // 创建一个DocumentBuilderFactory
////        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
////        // 创建一个DocumentBuilder对象
////        DocumentBuilder db = dbf.newDocumentBuilder();
////        return db;
////
////    }
////    /* 解析XML文件 */
//////    public void xmlParser() throws Exception {
//////        // 通过DocumentBuilder对象parse方法加载books.xml文件到当前的项目下
//////        Document document = getDocumentBuilder() .parse("books.xml");
//////        // 获取所有book节点的集合
//////        NodeList booklist = document.getElementsByTagName("book");
//////        // 通过NodeList的getLength()方法可以获取booklist的长度
//////        // System.out.println("一共有："+booklist.getLength()+"本书");
//////        // 遍历每一个book节点
//////        for (int i = 0; i < booklist.getLength(); i++) {
//////            System.out.println("=================下面开始遍历第" + (i + 1)
//////                    + "本书的内容=================");
//////            // 通过item(i)方法获取一个book节点，NodeList的索引值从0开始
//////            Node book = booklist.item(i);
//////            // 获取book节点的所有属性集合
//////            NamedNodeMap attrs = book.getAttributes();
//////            System.out.println("第" + (i + 1) + "本书共有：" + attrs.getLength()
//////                    + "个属性");
//////            // 遍历book的属性
//////            for (int j = 0; j < attrs.getLength(); j++) {
//////                // 通过item(index)方法获取book节点的某一个属性
//////                Node attr = attrs.item(j);
//////                // 获取属性名
//////                System.out.print("属性名：" + attr.getNodeName());
//////                // 获取属性值
//////                System.out.println("----属性值：" + attr.getNodeValue());
//////            }
//////            /*
//////             * //前提：已经知道book节点有且只能有1个id属性 //将book1节点进行强制类型转换成Element类型 Element
//////             * book1=(Element) booklist.item(i); //通过getAttribute("id")方法获取属性值
//////             * String attrValue=book1.getAttribute("id");
//////             * System.out.println("id属性的属性值为："+attrValue);
//////             */NodeList childNodes = book.getChildNodes();
//////            // 遍历childNodes获取每个节点的节点名和节点值
//////            System.out.println("第" + (i + 1) + "本书共有：" + childNodes.getLength()
//////                    + "个子节点");
//////            for (int k = 0; k < childNodes.getLength(); k++) {
//////                // 区分出text类型的node以及element类型的node
//////                if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
//////                    // 获取了element类型节点的节点名
//////
//////                    System.out.print("第" + (k + 1) + "个节点的节点名："
//////                            + childNodes.item(k).getNodeName());
//////                    // System.out.println("-----节点值是："+childNodes.item(k).getNodeValue());
//////                    System.out.println("-----节点值是："
//////                            + childNodes.item(k).getTextContent());
//////
//////                }
//////                // 获取了element类型节点的节点值
//////                System.out.println(childNodes.item(k).getFirstChild()
//////                        .getNodeValue());
//////            }
//////
//////            System.out.println("=================结束遍历第" + (i + 1)
//////                    + "本书的内容=================");
//////        }
//////
//////    }
////
////    /*生成xml*/
////    public void createXML() throws Exception{
////        DocumentBuilder db=getDocumentBuilder();
////        Document document=db.newDocument();
////        Element bookstore=document.createElement("bookStore");
////        //向bookstore根节点中添加字节点book
////        Element book=document.createElement("book");
////        Element name=document.createElement("name");
////        book.appendChild(name);
////        name.setTextContent("小王子");
////        book.setAttribute("id", "1");
////        //将book节点添加到bookstore根节点中
////        bookstore.appendChild(book);
////        //将bookstore节点（已经包含了book）,添加到dom树中
////        document.appendChild(bookstore);
////        //创建TransformerFactory对象
////        TransformerFactory tff=TransformerFactory.newInstance();
////        //创建Transformer对象
////        Transformer tf=tff.newTransformer();
////        //换行文件内容
////        tf.setOutputProperty(OutputKeys.INDENT, "yes");
////        tf.transform(new DOMSource(document), new StreamResult(new File("boos1.xml")));
////    }
////    public static void main(String []args) throws Exception{
////        Xml test=new Xml();
////        //test.xmlParser();
////        test .createXML();
////    }
////
////}
//
//
//
//
////import java.io.*;
////import javax.xml.parsers.*;
////import javax.xml.transform.Transformer;
////import javax.xml.transform.TransformerFactory;
////import javax.xml.transform.dom.DOMSource;
////import javax.xml.transform.stream.StreamResult;
////
////import org.w3c.dom.*;
////import org.w3c.dom.Text;
////
////public class Xml {
////    public static void main(String[] args) throws Exception {
////        DocumentBuilderFactory  fct=DocumentBuilderFactory.newInstance();
////        DocumentBuilder bui=fct.newDocumentBuilder();
////        Document doc=bui.newDocument();
////        Element ps=doc.createElement("persons");
////        Element p1=doc.createElement("person");
////        Element p2=doc.createElement("person");
////        Attr id1=doc.createAttribute("id");
////        Attr id2=doc.createAttribute("id");
////        id1.setNodeValue("1");
////        id2.setNodeValue("2");
////        Element name1=doc.createElement("name");
////        org.w3c.dom.Text na1=doc.createTextNode("龙大哥");
////        Element name2=doc.createElement("name");
////        org.w3c.dom.Text na2=doc.createTextNode("龙大爷");
////        Element sex1=doc.createElement("sex");
////        org.w3c.dom.Text se1=doc.createTextNode("帅哥");
////        Element sex2=doc.createElement("sex");
////        Text se2=doc.createTextNode("妹子");
////        doc.appendChild(ps);
////        ps.appendChild(p1);
////        p1.appendChild(name1);
////        p1.setAttributeNode(id1);
////        name1.appendChild(na1);
////        p1.appendChild(sex1);
////        sex1.appendChild(se1);
////        ps.appendChild(p2);
////        p2.appendChild(name2);
////        p2.setAttributeNode(id2);
////        name2.appendChild(na2);
////        p2.appendChild(sex2);
////        sex2.appendChild(se2);
////        doc2XmlFile(doc,"pet.xml");
////    }
////
////    public static boolean doc2XmlFile(Document document, String filename) {//实现doc2XmlFile方法
////        boolean flag = true;
////        try {
////            TransformerFactory tFactory = TransformerFactory.newInstance();//生成TransformerFactory实例
////            Transformer transformer = tFactory.newTransformer();
/////** 编码 */
////// transformer.setOutputProperty(OutputKeys.ENCODING, "GB2312");
////            DOMSource source = new DOMSource(document);
////            StreamResult result = new StreamResult(new File(filename));
////            transformer.transform(source, result);//写入xml文件
////        } catch (Exception ex) {
////            flag = false;
////            ex.printStackTrace();
////        }
////        return flag;
////    }
////}
//
//
//
//
//
//
////import org.dom4j.Attribute;
////import org.dom4j.Document;
////import org.dom4j.DocumentHelper;
////import org.dom4j.Element;
////import org.dom4j.io.OutputFormat;
////import org.dom4j.io.SAXReader;
////import org.dom4j.io.XMLWriter;
////
////import java.io.File;
////import java.io.FileOutputStream;
////import java.util.ArrayList;
////import java.util.Iterator;
////import java.util.List;
////
////class Book {
////    private String id;
////    private String name;
////    private String author;
////    private String year;
////    private String price;
////    private String language;
////    public String getId() {
////        return id;
////    }
////    public void setId(String id) {
////        this.id = id;
////    }
////    public String getName() {
////        return name;
////    }
////    public void setName(String name) {
////        this.name = name;
////    }
////    public String getAuthor() {
////        return author;
////    }
////    public void setAuthor(String author) {
////        this.author = author;
////    }
////    public String getYear() {
////        return year;
////    }
////    public void setYear(String year) {
////        this.year = year;
////    }
////    public String getPrice() {
////        return price;
////    }
////    public void setPrice(String price) {
////        this.price = price;
////    }
////    public String getLanguage() {
////        return language;
////    }
////    public void setLanguage(String language) {
////        this.language = language;
////    }
////
////
////}
////
////public class Xml {
////    private static ArrayList<Book> bookList=new ArrayList<Book>();
////
////    private void parseXML() throws Exception {
////        // 解析books.xml文件
////        // 创建SAXReader的对象reader
////        SAXReader reader = new SAXReader();
////        // 通过reader对象的read方法加载books.xml文件，获取document对象
////        Document document = reader.read(new File("src/res/books.xml"));
////        // 通过Element对象获取根节点bookstore
////        Element bookStore = document.getRootElement();
////        // 通过Element对象的elementIterator()方法获取迭代器
////        Iterator it = bookStore.elementIterator();
////        // 遍历迭代器，获取根节点中的信息（书籍）
////        while (it.hasNext()) {
////            System.out.println("===========开始遍历某一本书===========");
////            Element book = (Element) it.next();
////            // 获取book的属性名以及属性值
////            List<Attribute> bookAttrs = book.attributes();
////            for (Attribute attr : bookAttrs) {
////                System.out.println("属性名：" + attr.getName() + "----属性值："+ attr.getValue());
////            }
////            Iterator itt = book.elementIterator();
////            while (itt.hasNext()) {
////                Element bookChild = (Element) itt.next();
////                System.out.println("节点名：" + bookChild.getName() + "节点值："+ bookChild.getStringValue());
////            }
////            System.out.println("===========结束遍历某一本书===========");
////        }
////
////    }
////
////    private void createXML() throws Exception{
////        //1.创建document对象，代表整个xml文档
////        Document document= DocumentHelper.createDocument();
////        //2.创建根节点
////        Element rss=document.addElement("rss");
////        //3.向rss节点中添加version，自动生成默认编码模式（UTF-8）
////        rss.addAttribute("version", "2.0");
////        //4.生成子节点及节点内容
////        Element channel=rss.addElement("channel");
////        Element title=channel.addElement("title");
////        //title.setText("中国最新新闻");
////        title.setText("<!CDATA上海移动互联网产业促进中心正式揭牌]]>");
////        //5.设置生成xml的格式
////        OutputFormat format= OutputFormat.createPrettyPrint();
////        //生成不一样的编码
////        format.setEncoding("GBK");
////        //6.生成xml文件
////        File file=new File("rssnews.xml");
////        XMLWriter writer=new XMLWriter(new FileOutputStream(file),format);
////        //设置是否转义，默认设置是true,代表转义
////        writer.setEscapeText(false);
////        writer.write(document);
////        writer.close();
////    }
////    /**
////     * @param args
////     */
////    public static void main(String[] args) throws Exception{
////        new Xml().createXML();
////    }
////
////}