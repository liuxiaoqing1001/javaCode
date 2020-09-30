//package Work.Http;
//
//import com.sun.tools.doclets.internal.toolkit.util.SourceToHTMLConverter;
//
//import java.io.*;
//import java.net.InetAddress;
//import java.net.Socket;
//
//public class Sockt {
//
//    public void creatSocket(){
//        Socket socket= null;
//        try {
//            socket = new Socket(InetAddress.getByName("www.tute.edu.cn"),80);
//            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(socket.getOutputStream());
//            BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
//            bufferedWriter.write("GET / HTTP/1.1\t\n");
//            bufferedWriter.write("HOST:www.tute.edu.cn\t\n\t\n");
//            bufferedWriter.flush();
//            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            String line;
//            File file=new File("/home/liu/桌面/tute.html");
//            if(!file.exists()){
//                file.createNewFile();
//            }
//
//            FileOutputStream fileOutputStream=new FileOutputStream("/home/liu/桌面/tute.html");
//            while((line=bufferedReader.readLine())!=null){
//                System.out.println(line);
//                fileOutputStream.write(line.getBytes());
//            }
//            bufferedWriter.close();
//            bufferedReader.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public static void main(String[] args) throws Exception {
//        Sockt sockt=new Sockt();
//        sockt.creatSocket();
//    }
//}
