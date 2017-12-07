package IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception{
        //Bind,Connect
        Socket client = new Socket("127.0.0.1", 7777);
        //读写
        PrintWriter pw = new PrintWriter(client.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pw.write(br.readLine());
        //Close
        pw.close();
        br.close();
    }

}
