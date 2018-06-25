package client;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws Exception {
        System.out.println("Please input 'o','n', eny number or 'stop' for exit");
        Socket s = new Socket("localhost", 1994);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String write = "";
        String read = "";
        while (!write.equals("stop")) {
            write = br.readLine();
            dout.writeUTF(write);
            dout.flush();
            read = din.readUTF();
            System.out.println("Server says: " + read);
        }

        dout.close();
        s.close();
    }
}



