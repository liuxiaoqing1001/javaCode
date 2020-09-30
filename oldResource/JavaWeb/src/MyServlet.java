import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "MyServlet")
public class MyServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request,response);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        System.out.println("ok");
//
////        String name=request.getParameter("name");
////        String pass=request.getParameter("pass");
////        System.out.println(name+"\t"+pass);
//
//        request.setCharacterEncoding("utf-8");
//
//        //头   下载：application/x
//        response.setHeader("Content-Type","text/html;charset=utf-8");
//
////        response.setCharacterEncoding("utf-8");
////        String[] name=request.getParameterValues("name");
//        String name=request.getParameter("name");
//        name=URLDecoder.decode(name);
//        System.out.println(name);
////        String pass=request.getParameter("pass");
////        StringBuffer stringBuffer=new StringBuffer();
////        stringBuffer.append(pass+"<br>");
////        for(String str:name){
////            stringBuffer.append(str+"<br>");
////        }
//        PrintWriter printWriter=response.getWriter();
////        printWriter.write("<div style=\"color:#0000ff;\">"+stringBuffer.toString()+"</div>");
//        printWriter.write("<b>"+name+"</b>");
//        printWriter.flush();
//    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setHeader("Content-Type","text/html;charset=utf-8");
//        String name=request.getParameter("name");
//        name=URLDecoder.decode(name);
//        System.out.println(name);
//        PrintWriter printWriter=response.getWriter();
//        printWriter.write("<b>"+name+"</b>");
//        printWriter.flush();


        request.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type","text/html;charset=utf-8");
        Date d=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String name=request.getParameter("name")+"&nbsp;&nbsp;"+simpleDateFormat.format(d);
        PrintWriter out=response.getWriter();
        out.write(name);
        out.close();


//        request.getRequestDispatcher("文件路径").forward(request,response);
    }
}
