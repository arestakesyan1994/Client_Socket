package server;

import manager.NumberManager;
import model.Number;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {


    public static void main(String[] args) throws Exception {
        NumberManager numberManager = new NumberManager();
        ServerSocket serverSocket = new ServerSocket(1994);
        Socket socket = serverSocket.accept();
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        String str = "";
        Number n = new Number();
        int number;
        while (!str.equals("stop")) {
            str = dataInputStream.readUTF();
            dataOutputStream.flush();
            System.out.println(str);
            try {
                number = Integer.parseInt(str);
                if (number % 2 == 0) {
                    n.setEvenNumber(number);
                    n.setOddNumber(0);
                    numberManager.add(n);
                } else{
                    n.setOddNumber(number);
                numberManager.add(n);}
                dataOutputStream.writeUTF("ok");
            } catch (Exception ex) {
                if (str.equals("n")) {
                    List<Number> all = numberManager.getNumberr();
                    String s = "";
                    for (Number number1 : all) {
                        if (number1.getOddNumber() == 0) {
                            s += number1.getEvenNumber() + " ";
                        }
                    }
                    dataOutputStream.writeUTF(s);
                } else if (str.equals("o")) {
                    List<Number> all = numberManager.getNumberr();
                    String s = "";
                    for (Number number1 : all) {
                        if (number1.getEvenNumber() == 0 && number1.getOddNumber()!=0) {
                            s += number1.getOddNumber() + " ";
                        }
                    }
                    dataOutputStream.writeUTF(s);
                } else {
                    dataOutputStream.writeUTF("Please input 'o','n', eny number or 'stop' for exit");
                }
            }
        }
        dataOutputStream.writeUTF("Good By");
        socket.close();
    }
}
