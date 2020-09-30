package Work_1.Chat.ChatTest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatS {
    //定义一个服务器线程的list数组
    public static ArrayList<ServerThread> list =new ArrayList<ServerThread>();


    public  void inServer() {
        try {
            //创建服务器对象,并指定端口号
            ServerSocket server = new ServerSocket(9090);
            System.out.println("聊天室已经建立！");

            //不断获取客户端的连接
            while(true){
                Socket socket =server.accept();
                System.out.println("上线了！");
                ServerThread serverThread=new ServerThread(socket);

                //当有客户端连接进来以后，开启一个线程，用来处理该客户端的逻辑,
//                ServerThread st = new ServerThread(socket);
                serverThread.start();
                //添加该客户端到容器中
                list.add(serverThread);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        ChatS ms = new ChatS();
        ms.inServer();
    }
}


class ServerThread extends Thread {

    public Socket socket;
    public InputStream ins;
    public OutputStream ous;
    private String name;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;
    private boolean flag = true;

    public ServerThread(Socket socket) throws IOException {
        this.socket = socket;
//        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        printWriter = new PrintWriter(socket.getOutputStream(), true);
//        String str = bufferedReader.readLine();
//        name = str+"["+socket.getInetAddress().getHostAddress()+":"+socket.getPort()+"]";
//        ChatS chatS=new ChatS();
//        chatS.list.add(this);
//        System.out.println(name+"上线了！");
    }

    public void run() {
        try {
            // 获取输入输出流
            ins = socket.getInputStream();
            ous = socket.getOutputStream();
            // 发送消息给客户端
            String msg = "***welcome to ChatRoom !***";
            sendMsg(ous, msg);
            // 发送要求登录信息给客户端
            String userinfo = "please input your name:";
            sendMsg(ous, userinfo);
            // 获取客户端输入的用户名
            String userName = readMsg(ins);
            // 发送要求密码信息给客户端
            String pwd = "please input your password:";
            sendMsg(ous,  pwd);
            // 获取客户端输入的密码
            String pass = readMsg(ins);
            // 登录验证
            boolean falg = loginCheck(userName, pass);
            // 校验不通过时，循环校验
            while (!falg) {
                msg="no";
                sendMsg(ous, msg);
                msg = "Fail to connect server......";
                sendMsg(ous, msg);
                msg = "please check your name and password and login again.....";
                sendMsg(ous, msg);
                msg = "please input your name:";
                sendMsg(ous, msg);
                // 获取客户端输入的用户名
                userName = readMsg(ins);
                // 发送要求密码信息给客户端
                msg = "please input your password:";
                sendMsg(ous, msg);
                // 获取客户端输入的密码
                pass = readMsg(ins);
                falg = loginCheck(userName, pass);
            }

            //发送登录成功的结果给客户端
            msg="ok";
            sendMsg(ous, msg);
            // 校验成功后：开始聊天
            msg = "successful connected..... you can chat with your friends now ......";
            sendMsg(ous, msg);
            // 聊天处理逻辑
            //读取客户端发来的消息
            msg=readMsg(ins);
            System.out.println("客户端已经接到消息："+msg);
            //输入bye结束聊天
            while(!"bye".equals(msg)){
                //给容器中的每个对象转发消息
                for (int i = 0; i <ChatS.list.size(); i++) {
                    ServerThread st =ChatS.list.get(i);
                    //不该自己转发消息
                    if(st!=this){
                        System.out.println("转发消息......");
                        sendMsg(st.ous, userName+"  is say:"+msg);
                        System.out.println("转发消息成功......");
                    }
                }
                //等待读取下一次的消息
                msg=readMsg(ins);
            }

        } catch (Exception e) {
            System.out.println("客户端不正常关闭......");
//			e.printStackTrace();
        }
        //有异常后统一将流关闭
        try {
            ins.close();
            ous.close();
            socket.close();
            //将当前已经关闭的客户端从容器中移除
            ChatS.list.remove(this);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // 校验客户端输入的账号和密码的函数,由于没有数据库，暂时写死了
    public boolean loginCheck(String name, String pwd) {
        if (name.equals("qing") && pwd.equals("liu") || name.equals("yin") && pwd.equals("zhou")
                || name.equals("xue") && pwd.equals("li")|| name.equals("mi") && pwd.equals("luo")) {

            return true;
        }
        return false;
    }

    // 发送消息的函数
    public void sendMsg(OutputStream os, String s) throws IOException {
        // 向客户端输出信息
        byte[] bytes = s.getBytes();
        os.write(bytes);
        os.write(13);
        os.write(10);
        os.flush();

    }

    // 读取客户端输入数据的函数
    public String readMsg(InputStream ins) throws Exception {
        // 读取客户端的信息
        int value = ins.read();
        // 读取整行 读取到回车（13）换行（10）时停止读
        String str = "";
        while (value != 10) {
            // 点击关闭客户端时会返回-1值
            if (value == -1) {
                throw new Exception();
            }
            str = str + ((char) value);
            value = ins.read();
        }
        str = str.trim();
        return str;
    }

}
















////import java.io.BufferedReader;
////import java.io.IOException;
////import java.io.InputStreamReader;
////import java.io.PrintWriter;
////import java.net.ServerSocket;
////import java.net.Socket;
////import java.util.ArrayList;
////import java.util.List;
////import java.util.concurrent.ExecutorService;
////import java.util.concurrent.Executors;
////
////public class ChatServer {
////    private static int PORT; // 端口号
////    private static List<Socket> list = new ArrayList<Socket>(); // 保存连接对象
////    private ExecutorService exec;
////    private ServerSocket server;
////
////    public static void main(String[] args) {
////        new ChatServer();
////    }
////
////    public ChatServer() {
////        try {
////            PORT=socket
////            server = new ServerSocket(PORT);
////            exec = Executors.newCachedThreadPool();
////            System.out.println("服务器已启动！");
////
////            Socket client = null;
////            while (true) {
////                client = server.accept(); // 接收客户连接
////                list.add(client);
////                exec.execute(new ChatTask(client));
////            }
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////    }
////
////    static class ChatTask implements Runnable {
////        private Socket socket;
////        private BufferedReader br;
////        private PrintWriter pw;
////        private String msg;
////
////        public ChatTask(Socket socket) throws IOException {
////            this.socket = socket;
////            br = new BufferedReader(new InputStreamReader(socket
////                    .getInputStream()));
////            msg = "【" + this.socket.getInetAddress() + "】进入聊天室！当前聊天室有【"
////                    + list.size() + "】人";
////
////            sendMessage();
////        }
////
////        public void run() {
////            try {
////                while ((msg = br.readLine()) != null) {
////                    if(msg.trim().equals("@"))
////
////
////                    if (msg.trim().equals("bye")) {
////                        list.remove(socket);
////                        br.close();
////                        pw.close();
////                        msg = "【" + socket.getInetAddress() + "】离开聊天室！当前聊天室有【"
////                                + list.size() + "】人";
////                        socket.close();
////
////                        sendMessage();
////                        break;
////                    } else {
////                        msg = "【" + socket.getInetAddress() + "】说：" + msg;
////                        sendMessage();
////                    }
////                }
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////        }
////
////        /**
////         * 群发消息给聊天室的所有人
////         */
////        private void sendMessage() throws IOException {
////            System.out.println(msg);
////            for (Socket client : list) {
////                pw = new PrintWriter(client.getOutputStream(), true);
////                pw.println(msg);
////            }
////        }
////    }
////}
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
//
//
//
//
//
//
//
//
//import java.io.*;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.net.SocketException;
//import java.util.List;
//
//public class ChatS {
//    private List<ServerThread> clients = null;
//
//    private class ServerThread implements Runnable {
//        private Socket s = null;
//        private BufferedReader br;
//        private PrintWriter out;
//        private String name;
//        private boolean flag = true;
//
//        public ServerThread(Socket socket) throws IOException {
//            this.s = socket;
//            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            out = new PrintWriter(socket.getOutputStream(), true);
//            String str = br.readLine();
//            name = str+"["+socket.getInetAddress().getHostAddress()+":"+socket.getPort()+"]";
//            clients.add(this);
//            send(name+"上线了");
//        }
//
//        private void send(String msg) {
//            for (ServerThread st : clients)
//                st.out.println(msg);
//        }
//
//        private void receive() throws IOException {
//            String str = null;
//            while ((str=br.readLine()) != null) {
//                if (str.equalsIgnoreCase("quit")) {
//                    stop();
//                    out.println("disconnect");
//                    break;
//                }
//                send(name+":"+str);
//            }
//        }
//
//        private void stop() {
//            clients.remove(this);
//            flag = false;
//            send(name+"已经下线了");
//        }
//
//        @Override
//        public void run() {
//            try {
//                while (true) {
//                    if (!flag) break;
//                    receive();
//                }
//            } catch (SocketException e) {
//                stop();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    if (s != null)
//                        s.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//    }
//
//    public static void main(String[] args) throws Exception {
//        ServerSocket serverSocket=new ServerSocket(30000);
//        System.out.println("***Welcome to ChatRoom!***");
//
//            Socket socket=serverSocket.accept();
//
//            System.out.println(socket.getLocalPort());
//            PrintStream printStream=new PrintStream(socket.getOutputStream());
//            printStream.flush();
//            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            String line=bufferedReader.readLine();
//            System.out.println(line);
//            bufferedReader.close();
//            printStream.close();
//
//    }
//}
