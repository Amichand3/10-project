import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.*;

public class DuplexChatroom {
    static ServerSocket ss;
    static Socket s;
    static Scanner sc;
    static Scanner input;
    static PrintWriter pw;
    static String str="",str1="";
    public static void write() {
        Thread tw = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    str = input.nextLine();
                    pw.println(str);
                    if (str.equals("Bye")) {
                        break;
                    }

                }
            }
        });
        tw.start();
    }
    public static void read(){
        Thread tr=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    str1=sc.nextLine();
                    System.out.println(str1);
                    if(str1.equals("Bye")){
                        break;
                    }
                }
            }
        });

        tr.start();
    }
    public static void main(String[] args) {
        try {
            ss = new ServerSocket(8080);
            s=ss.accept();
            System.out.println("connected ");
            sc=new Scanner(s.getInputStream());
           input =new Scanner(System.in);
            pw=new PrintWriter(s.getOutputStream(),true);
            read();
            write();
        }catch (Exception e){
            System.out.println(e);
        }

    }

    
    
}
 