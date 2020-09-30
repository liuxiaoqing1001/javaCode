
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    //����һ���������̵߳�list����
    public static ArrayList<ServerThread> list =new ArrayList<ServerThread>();


    public  void inServer() {
        try {
            //��������������,��ָ���˿ں�
            ServerSocket server = new ServerSocket(9090);
            System.out.println("�������Ѿ�������");

            //���ϻ�ȡ�ͻ��˵�����
            while(true){
                Socket socket =server.accept();
                System.out.println("�����ˣ�");
                ServerThread serverThread=new ServerThread(socket);
                
//                System.out.println(name+"�����ˣ�");
                //���пͻ������ӽ����Ժ󣬿���һ���̣߳���������ÿͻ��˵��߼�,
//                ServerThread st = new ServerThread(socket);
                serverThread.start();
                //��Ӹÿͻ��˵�������
                list.add(serverThread);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        Server ms = new Server();
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
//        Server chatS=new Server();
//        chatS.list.add(this);
//        System.out.println(name+"�����ˣ�");
    }

    public void run() {
        try {
            // ��ȡ���������
            ins = socket.getInputStream();
            ous = socket.getOutputStream();
            // ������Ϣ���ͻ���
            String msg = "***welcome to ChatRoom !***";
            sendMsg(ous, msg);
            // ����Ҫ���¼��Ϣ���ͻ���
            String userinfo = "please input your name:";
            sendMsg(ous, userinfo);
            // ��ȡ�ͻ���������û���
            String userName = readMsg(ins);
            // ����Ҫ��������Ϣ���ͻ���
            String pwd = "please input your password:";
            sendMsg(ous,  pwd);
            // ��ȡ�ͻ������������
            String pass = readMsg(ins);
            // ��¼��֤
            boolean falg = loginCheck(userName, pass);
            // У�鲻ͨ��ʱ��ѭ��У��
            while (!falg) {
                msg="no";
                sendMsg(ous, msg);
                msg = "Fail to connect server......";
                sendMsg(ous, msg);
                msg = "please check your name and password and login again.....";
                sendMsg(ous, msg);
                msg = "please input your name:";
                sendMsg(ous, msg);
                // ��ȡ�ͻ���������û���
                userName = readMsg(ins);
                // ����Ҫ��������Ϣ���ͻ���
                msg = "please input your password:";
                sendMsg(ous, msg);
                // ��ȡ�ͻ������������
                pass = readMsg(ins);
                falg = loginCheck(userName, pass);
            }

            //���͵�¼�ɹ��Ľ�����ͻ���
            msg="ok";
            sendMsg(ous, msg);
            // У��ɹ��󣺿�ʼ����
            msg = "successful connected..... you can chat with your friends now ......";
            sendMsg(ous, msg);
            // ���촦���߼�
            //��ȡ�ͻ��˷�������Ϣ
            msg=readMsg(ins);
            System.out.println("�ͻ����Ѿ��ӵ���Ϣ��"+msg);
            //����bye��������
            while(!"bye".equals(msg)){
                //�������е�ÿ������ת����Ϣ
                for (int i = 0; i <Server.list.size(); i++) {
                    ServerThread st =Server.list.get(i);
                    //�����Լ�ת����Ϣ
                    if(st!=this){
                        System.out.println("ת����Ϣ......");
                        sendMsg(st.ous, userName+"  :"+msg);
                        System.out.println("ת����Ϣ�ɹ�......");
                    }
                }
                //�ȴ���ȡ��һ�ε���Ϣ
                msg=readMsg(ins);
            }

        } catch (Exception e) {
            System.out.println("�ͻ��˲������ر�......");
//			e.printStackTrace();
        }
        //���쳣��ͳһ�����ر�
        try {
            ins.close();
            ous.close();
            socket.close();
            //����ǰ�Ѿ��رյĿͻ��˴��������Ƴ�
            Server.list.remove(this);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // У��ͻ���������˺ź�����ĺ���,����û�����ݿ⣬��ʱд����
    public boolean loginCheck(String name, String pwd) {
        if (name.equals("qing") && pwd.equals("liu") || name.equals("yin") && pwd.equals("zhou")
                || name.equals("xue") && pwd.equals("li")|| name.equals("mi") && pwd.equals("luo")) {

            return true;
        }
        return false;
    }

    // ������Ϣ�ĺ���
    public void sendMsg(OutputStream os, String s) throws IOException {
        // ��ͻ��������Ϣ
        byte[] bytes = s.getBytes();
        os.write(bytes);
        os.write(13);
        os.write(10);
        os.flush();

    }

    // ��ȡ�ͻ����������ݵĺ���
    public String readMsg(InputStream ins) throws Exception {
        // ��ȡ�ͻ��˵���Ϣ
        int value = ins.read();
        // ��ȡ���� ��ȡ���س���13�����У�10��ʱֹͣ��
        String str = "";
        while (value != 10) {
            // ����رտͻ���ʱ�᷵��-1ֵ
            if (value == -1) {
                throw new Exception();
            }
            str = str + ((char) value);
            value = ins.read();
        }
        //ȥ�հ��ַ�
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
////    private static int PORT; // �˿ں�
////    private static List<Socket> list = new ArrayList<Socket>(); // �������Ӷ���
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
////            System.out.println("��������������");
////
////            Socket client = null;
////            while (true) {
////                client = server.accept(); // ���տͻ�����
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
////            msg = "��" + this.socket.getInetAddress() + "�����������ң���ǰ�������С�"
////                    + list.size() + "����";
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
////                        msg = "��" + socket.getInetAddress() + "���뿪�����ң���ǰ�������С�"
////                                + list.size() + "����";
////                        socket.close();
////
////                        sendMessage();
////                        break;
////                    } else {
////                        msg = "��" + socket.getInetAddress() + "��˵��" + msg;
////                        sendMessage();
////                    }
////                }
////            } catch (IOException e) {
////                e.printStackTrace();
////            }
////        }
////
////        /**
////         * Ⱥ����Ϣ�������ҵ�������
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
//            send(name+"������");
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
//            send(name+"�Ѿ�������");
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
////public class Server {
////	private static final int PORT = 8888; // �˿ں�
////	private static List<Socket> list = new ArrayList<Socket>(); // �������Ӷ���
////	private ExecutorService exec;
////	private ServerSocket server;
////
////	public static void main(String[] args) {
////		new Server();
////	}
////
////	public Server() {
////		try {
////			server = new ServerSocket(PORT);
////			exec = Executors.newCachedThreadPool();
////			System.out.println("��������������");
////
////			Socket client = null;
////			while (true) {
////				client = server.accept(); // ���տͻ�����
////				list.add(client);
////				exec.execute(new ChatTask(client));
////			}
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
////	}
////
////	static class ChatTask implements Runnable {
////		private Socket socket;
////		private BufferedReader br;
////		private PrintWriter pw;
////		private String msg;
////
////		public ChatTask(Socket socket) throws IOException {
////			this.socket = socket;
////			br = new BufferedReader(new InputStreamReader(socket
////					.getInputStream()));
////			msg = "��" + this.socket.getInetAddress() + "�����������ң���ǰ�������С�"
////					+ list.size() + "����";
////
////			sendMessage();
////		}
////
////		public void run() {
////			try {
////				while ((msg = br.readLine()) != null) {
////					if (msg.trim().equals("bye")) {
////						list.remove(socket);
////						br.close();
////						pw.close();
////						msg = "��" + socket.getInetAddress() + "���뿪�����ң���ǰ�������С�"
////								+ list.size() + "����";
////						socket.close();
////
////						sendMessage();
////						break;
////					} else {
////						msg = "��" + socket.getInetAddress() + "��˵��" + msg;
////						sendMessage();
////					}
////				}
////			} catch (IOException e) {
////				e.printStackTrace();
////			}
////		}
////
////		/**
////		 * Ⱥ����Ϣ�������ҵ�������
////		 */
////		private void sendMessage() throws IOException {
////			System.out.println(msg);
////			for (Socket client : list) {
////				pw = new PrintWriter(client.getOutputStream(), true);
////				pw.println(msg);
////			}
////		}
////	}
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
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.net.SocketException;
//import java.util.ArrayList;
//import java.util.List;
// 
//public class Server {
//	private List<ServerThread> clients = null;
//	
//	public static void main(String[] args) {
//		new Server().startUp();
//	}
//	
//	private void startUp() {
//		ServerSocket ss = null;
//		Socket s = null;
//		try {
//			ss = new ServerSocket(5858);
//			clients = new ArrayList<ServerThread>();
//			while (true) {
//				s = ss.accept();
//				ServerThread st = new ServerThread(s);
//				new Thread(st).start();
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (ss != null) 
//					ss.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//	
//	private class ServerThread implements Runnable {
//		private Socket s = null;
//		private BufferedReader br;
//		private PrintWriter out;
//		private String name;
//		private boolean flag = true;
//		
//		public ServerThread(Socket socket) throws IOException {
//			this.s = socket;
//			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			out = new PrintWriter(socket.getOutputStream(), true);
//			String str = br.readLine();
//			name = str+"["+socket.getInetAddress().getHostAddress()+":"+socket.getPort()+"]";
//			clients.add(this);
//			send(name+"������");
//		}
//		
//		private void send(String msg) {
//			for (ServerThread st : clients)
//				st.out.println(msg);
//		}
//		
//		private void receive() throws IOException {
//			String str = null;
//			while ((str=br.readLine()) != null) {
//				if (str.equalsIgnoreCase("quit")) {
//					stop();
//					out.println("disconnect");
//					break;
//				}
//				send(name+":"+str);
//			}
//		}
//		
//		private void stop() {
//			clients.remove(this);
//			flag = false;
//			send(name+"�Ѿ�������");
//		}
// 
//		@Override
//		public void run() {
//			try {
//				while (true) {
//					if (!flag) break;
//					receive();
//				}
//			} catch (SocketException e) {
//				stop();
//			} catch (IOException e) {
//				e.printStackTrace();
//			} finally {
//				try {
//					if (s != null) 
//						s.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		
//	}
//}