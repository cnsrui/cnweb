import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        //Client发送的数据
        String msg = "Client Data";
        try {
            //创建一个Socket，跟本机的8080端口连接
            Socket socket = new Socket("127.0.0.1", 8080);
            //使用Socket创建PrintWriter发送数据
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println(msg);
            pw.flush();
            //使用Socket创建BufferedReader进行接收数据
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = is.readLine();
            System.out.println("received from server: " + line);
            //关闭资源
            pw.close();
            is.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
