package Work_1.Chat.ChatRoom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class ChatClient {
    private Socket socket;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;
    private boolean flag = true;

    public static void main(String[] args) {
        new ChatClient().stratUp();
    }

    private void stratUp() {
        BufferedReader sbr = null;
        try {
            socket = new Socket("127.0.0.1", 3306);
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter.println("青");
            sbr = new BufferedReader(new InputStreamReader(System.in));

            new Thread(new ClientThread()).start();
            String str = null;
            while (flag && (str=sbr.readLine())!=null) {
                if (!flag) break;
                printWriter.println(str);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (sbr != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void receive() {
        try {
            String rs = bufferedReader.readLine();
            if (rs.equalsIgnoreCase("bye")) {
                flag = false;
                System.out.println("点击回车退出");
            }
            System.out.println(rs);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ClientThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                if (!flag) break;
                receive();
            }
        }

    }

}