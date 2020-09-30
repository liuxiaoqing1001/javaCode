
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
    	Client mc = new Client();
        mc.initClient();
    }

    public void initClient() {
        try {
            // �����ͻ��˶���
            Socket client = new Socket("localhost", 9090);
            // ��ȡ�ͻ��˵����������
            final InputStream ins = client.getInputStream();
            final OutputStream ous = client.getOutputStream();
            // �Ƚ��շ��������͵Ļ�ӭ��
            String msg = readMsg(ins);
            System.out.println(msg);
            // ���շ���˷��͹��������û���������
            String requestName = readMsg(ins);
            System.out.println(requestName);
            // ��ȡ�û�����Ϣ���ӿ���̨
            final Scanner scanner = new Scanner(System.in);
            String username = scanner.nextLine();
            // �����û���
            sendMsg(ous, username + "\r\n");
            // ��ȡ��������
            String requestPwd = readMsg(ins);
            System.out.println(requestPwd);
            // �ӿ���̨ɨ������
            String pwd = scanner.nextLine();
            // �����뷢�͸�������
            sendMsg(ous, pwd + "\r\n");
            // ��ȡ��֤���
            String result = readMsg(ins);
            //�����¼ʧ�ܣ�����ܷ������˷���������ʾ��Ϣ
            while(!result.equals("ok")){
                //����"Fail to connect server......"
                String message=readMsg(ins);
                System.out.println(message);
                //����"please check your name and password and login again....."
                message=readMsg(ins);
                System.out.println(message);
                //���� "please input your name:""
                message=readMsg(ins);
                System.out.println(message);
                //���·����û�����������
                username = scanner.nextLine();
                // �����û���
                sendMsg(ous, username + "\r\n");
                //������������"please input your password:"
                message=readMsg(ins);
                System.out.println(message);
                //���������������
                pwd = scanner.nextLine();
                // �����û���
                sendMsg(ous, pwd + "\r\n");
                //���շ�����������Ϣ
                result = readMsg(ins);
            }
            //�����¼�ɹ�������Կ�ʼ������
            if (result.equals("ok")) {
//				System.out.println("��½�ɹ�");
                // ������Ϣ�߳�
                new Thread() {
                    public void run() {
                        try {
                            while (true) {
                                // �ӿ���̨ɨ��һ������
                                String message = scanner.nextLine();
                                sendMsg(ous, message + "\r\n");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    };
                }.start();

                //��ȡ��Ϣ�߳�
                new Thread() {
                    public void run() {
                        try {
                            while (true) {
                                String message = readMsg(ins);
                                System.out.println(message);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    };
                }.start();
            } else {
                System.out.println("��½ʧ��");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readMsg(InputStream ins) throws Exception {
        int value = ins.read();
        String str = "";
        while (value != 10) {
            // ����ͻ����������ر�
            if (value == -1) {
                throw new Exception();
            }
            str = str + (char) value;
            value = ins.read();
        }
        str = str.trim();
        return str;
    }

    // ������Ϣ�ĺ���
    public void sendMsg(OutputStream ous, String str) throws Exception {
        byte[] bytes = str.getBytes();
        ous.write(bytes);
        ous.flush();
    }
}





////import java.io.BufferedReader;
////import java.io.InputStreamReader;
////import java.io.PrintWriter;
////import java.net.Socket;
////import java.util.concurrent.ExecutorService;
////import java.util.concurrent.Executors;
////
////public class ChatClient {
////    private static int PORT = 8888;
////    private static ExecutorService exec = Executors.newCachedThreadPool();
////
////    public static void main(String[] args) throws Exception {
////        new ChatClient();
////    }
////
////    public ChatClient() {
////        try {
////            Socket socket = new Socket("192.168.1.120", PORT);
////            exec.execute(new Sender(socket));
////            System.out
////                    .println("��" + socket.getInetAddress() + "�����ã���ӭ�������������ң�");
////
////            BufferedReader br = new BufferedReader(new InputStreamReader(socket
////                    .getInputStream()));
////            String msg;
////            while ((msg = br.readLine()) != null) {
////                System.out.println(msg);
////            }
////        } catch (Exception e) {
////            e.printStackTrace();
////
////        }
////    }
////
////    /**
////     * �ͻ����̻߳�ȡ����̨������Ϣ
////     */
////    static class Sender implements Runnable {
////        private Socket socket;
////
////        public Sender(Socket socket) {
////            this.socket = socket;
////        }
////
////        public void run() {
////            try {
////                BufferedReader br = new BufferedReader(new InputStreamReader(
////                        System.in));
////                PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
////                String msg;
////
////                while (true) {
////                    msg = br.readLine();
////                    pw.println(msg);
////
////                    if (msg.trim().equals("bye")) {
////                        pw.close();
////                        br.close();
////                        exec.shutdownNow();
////                        break;
////                    }
////                }
////            } catch (Exception e) {
////                e.printStackTrace();
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
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.PrintStream;
//import java.net.Socket;
//import java.util.Scanner;
//
//public class ChatC {
//    public static void main(String[] args)throws Exception{
//        Socket socket=new Socket("127.0.0.1",30000);
//        System.out.println(socket.getLocalPort());
//        PrintStream printStream=new PrintStream(socket.getOutputStream());
//        System.out.println("***You can chat!***");
//        Scanner scanner=new Scanner(System.in);
//
//        printStream.println(scanner.nextLine());
//        printStream.flush();
//
//        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        String line=bufferedReader.readLine();
//
//        System.out.println(line);
//        printStream.close();
//        bufferedReader.close();
//        socket.close();
//
//
//
//    }
//
//}

































////import java.io.BufferedReader;
////import java.io.InputStreamReader;
////import java.io.PrintWriter;
////import java.net.Socket;
////import java.util.concurrent.ExecutorService;
////import java.util.concurrent.Executors;
////
////public class Client {
////	private static final int PORT = 8888;
////	private static ExecutorService exec = Executors.newCachedThreadPool();
////
////	public static void main(String[] args) throws Exception {
////		new Client();
////	}
////
////	public Client() {
////		try {
////			Socket socket = new Socket("192.168.1.120", PORT);
////			exec.execute(new Sender(socket));
////			System.out
////					.println("��" + socket.getInetAddress() + "�����ã���ӭ�������������ң�");
////
////			BufferedReader br = new BufferedReader(new InputStreamReader(socket
////					.getInputStream()));
////			String msg;
////			while ((msg = br.readLine()) != null) {
////				System.out.println(msg);
////			}
////		} catch (Exception e) {
////
////		}
////	}
////
////    /**
////	 * �ͻ����̻߳�ȡ����̨������Ϣ
////	 */
////	static class Sender implements Runnable {
////		private Socket socket;
////
////		public Sender(Socket socket) {
////			this.socket = socket;
////		}
////
////		public void run() {
////			try {
////				BufferedReader br = new BufferedReader(new InputStreamReader(
////						System.in));
////				PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
////				String msg;
////
////				while (true) {
////					msg = br.readLine();
////					pw.println(msg);
////
////					if (msg.trim().equals("bye")) {
////						pw.close();
////						br.close();
////						exec.shutdownNow();
////						break;
////					}
////				}
////			} catch (Exception e) {
////				e.printStackTrace();
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
//
//
//
//
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//import java.net.UnknownHostException;
//
//
//public class Client {
//	private Socket s;
//	private BufferedReader br; 
//	private PrintWriter out;
//	private boolean flag = true;
//	
//	public static void main(String[] args) {
//		new Client().stratUp();
//	}
// 
//	private void stratUp() {
//		BufferedReader sbr = null;
//		try {
//			s = new Socket("127.0.0.1", 5858);
//			out = new PrintWriter(s.getOutputStream(), true);
//			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
//			out.println("����");
////			out.println("����");
//			sbr = new BufferedReader(new InputStreamReader(System.in));
//			
//			new Thread(new ClientThread()).start();
//			String str = null;
//			while (flag && (str=sbr.readLine())!=null) {
//				if (!flag) break;
//				out.println(str);
//			}
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (s != null) s.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			try {
//				if (sbr != null) s.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//	
//	private void receive() {
//		try {
//			String rs = br.readLine();
//			if (rs.equalsIgnoreCase("disconnect")) {
//				flag = false;
//				System.out.println("����س��˳�");
//			}
//			System.out.println(rs);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	private class ClientThread implements Runnable {
// 
//		@Override
//		public void run() {
//			while (true) {
//				if (!flag) break;
//				receive();
//			}
//		}
//		
//	}
// 
//}