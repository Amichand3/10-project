

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;



public class Xclientgui {
    static JTextArea  Receive;

    static ServerSocket ss;
    static Socket s;
    static Scanner sc;
    static Scanner sc1;
    static PrintWriter pw;
    static String str="",str1="";
    public static void write(){
        Thread tw=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    str=sc1.nextLine();
                    pw.println(str);
                      Receive.append(str1+"\n"+getCurrentTime() +"\t");
                    if(str.equals("Bye")){
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
                    Receive.append(str1+"\n"+getCurrentTime() +"\n");

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

            s=new Socket("localhost",8080);
            System.out.println("connected to server");
            sc=new Scanner(s.getInputStream());
            sc1=new Scanner(System.in);
            pw=new PrintWriter(s.getOutputStream(),true);
            read();
            write();
        }catch (Exception e){
            System.out.println(e);
        }
        jframe();
    }

    public static <ActionListener> void jframe() {
        JFrame f=new JFrame("chatroom");
        f.setBounds(600,100,400,420);
        f.setLayout(null);
        JPanel p=new JPanel();
        p.setBounds(10,10,390,390);
        p.setBackground(Color.decode("#a19fed"));
        p.setLayout(null);
        JLabel title=new JLabel("Client Messages ");
        title.setBounds(100,5,200,30);
        title.setFont(new Font("ink free",Font.BOLD,20));


        JTextField text=new JTextField();
        text.setBounds(05,340,285,30);

        JButton send=new JButton("Send ");
        
        send.setBounds(285,340,80,30);
        send.setBackground(Color.decode("#88cfc3"));

        /*JLabel Received=new JLabel("Received Massage");
        Received.setBounds(10,190,150,30);*/

        Receive=new JTextArea();
        Receive.setBounds(05,40,360,290);
        Receive.setBackground(Color.decode("#f2f2e9"));

        f.add(p);p.add(text,BorderLayout.SOUTH);p.add(send);
        p.add(Receive);
        
        p.add(title);
        f.setVisible(true);

        java.awt.event.ActionListener ac1=new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Receive.setText(str1);
                str = text.getText();
                pw.println(str);
                
                text.setText("");
            }
        };
        send.addActionListener(ac1);

    }
    private static String getCurrentTime() {
        return new Date().toString().substring(11, 19);
    }
}
