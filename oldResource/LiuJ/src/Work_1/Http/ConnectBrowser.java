package Work_1.Http;

import org.omg.CORBA.portable.OutputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectBrowser {

    public void connectBrowser(){
        try {
            ServerSocket serverSocket=new ServerSocket(6666);
            while(true){
                Socket socket=serverSocket.accept();
                InputStreamReader inputStreamReader=new InputStreamReader(socket.getInputStream());
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                String line;
                while ((line=bufferedReader.readLine())!=null){
                    System.out.println(line);
                }
                OutputStream outputStream= (OutputStream) socket.getOutputStream();
                StringBuffer stringBuffer=new StringBuffer();
                stringBuffer.append("HTTP/1.1 200 OK");
                stringBuffer.append("Server: VWebServer/6.0.0\n");
                stringBuffer.append("X-Frame-Options: SAMEORIGIN");
                stringBuffer.append("Accept-Ranges: bytes\n");
                stringBuffer.append("Content-Length: 5\n");
                stringBuffer.append("Content-Type: text/html; charset=utf-8");
                stringBuffer.append("sss");
                outputStream.write(stringBuffer.toString().getBytes());
                outputStream.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConnectBrowser connectBrowser=new ConnectBrowser();
        connectBrowser.connectBrowser();
    }
}
