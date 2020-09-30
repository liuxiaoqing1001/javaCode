package Work_1.Chat.ChatRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private List<ServerThread> clients =null;
        private static List<Socket> list = new ArrayList<Socket>();
    private static int PORT;

    public static void main(String[] args) {
        new ChatServer().startUp();
    }

    private void startUp() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
//            PORT=socket.getPort();
            serverSocket = new ServerSocket(PORT);
            clients = new ArrayList<ServerThread>();
            while (true) {
                socket = serverSocket.accept();
                PORT=socket.getPort();
                serverSocket = new ServerSocket(PORT);
                ServerThread st = new ServerThread(socket);
                new Thread(st).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (serverSocket != null)
                    serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class ServerThread implements Runnable {
        private Socket socket = null;
        private BufferedReader bufferedReader;
        private PrintWriter printWriter;
        private String name;
        private boolean flag = true;

        public ServerThread(Socket socket) throws IOException {
            this.socket = socket;
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            String str = bufferedReader.readLine();
            name = str+"["+socket.getInetAddress().getHostAddress()+":"+socket.getPort()+"]";
            clients.add(this);
//            send(name+"上线了");
        }

        private void send(String msg) {
            for (ServerThread serverThread : clients)
                serverThread.printWriter.println(msg);
        }

        private void receive() throws IOException {
            String str = null;
            while ((str= bufferedReader.readLine()) != null) {

                if(str.trim().equals("@"+name)){
                    send(name+"对你说:"+str);
                }

                if (str.equalsIgnoreCase("quit")) {
                    stop();
                    printWriter.println("disconnect");
                    break;
                }
                send(name+":"+str);
            }
        }

        private void stop() {
            clients.remove(this);
            flag = false;
            send(name+"已经下线了");
        }

        @Override
        public void run() {
            try {
                while (true) {
                    if (!flag) break;
                    receive();
                }
            } catch (SocketException e) {
                stop();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (socket != null)
                        socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
