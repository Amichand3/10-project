import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Client {

    static ServerSocket ss;
    static Socket s;
    static Scanner sc;
    static Scanner sc1;
    static PrintWriter pw;
    static String str="",str1="";
    static JTextField s1;
    public static void write(){
        Thread tw=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    str=sc1.nextLine();
                    pw.println(str);
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
                    s1.setText(str1);
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
        JFrame f = new JFrame();
        f.setLocation(400, 200);
        f.setSize(500,400);
        f.setLayout(null);
        
        Font myf = new Font("ink free",Font.BOLD,18);

        JPanel panel = new JPanel();
        panel.setSize(400,300);
        panel.setBounds(40,50,400,300);
        panel.setLayout(null);
        f.add(panel);

        JLabel label = new JLabel("chat Display from client ");
        label.setBounds(10,10,200,20);
        panel.add(label);
        JTextField s = new JTextField();
        s.setBounds(10,50,200,50);
        panel.add(s);
        JButton send = new JButton("SEND");
        send.setBounds(50,120,100,20);
        panel.add(send);
        panel.setBackground(Color.decode("#7878e3"));
        f.setBackground(Color.decode("#79c980"));
        JLabel label1 = new JLabel("receive msg Display ");
        label1.setFont(myf);
        label1.setBounds(10,150,200,20);
        panel.add(label1);
        label.setFont(myf);
         s1 = new JTextField();
        s1.setBounds(10,190,200,50);
        panel.add(s1);
        JButton receive = new JButton("receive");
        receive.setBounds(50,250,100,20);
        receive.setFont(myf);
        panel.add(receive);
        
        ActionListener ac = new ActionListener(){
            public void actionPerformed (ActionEvent e){
            String data = s.getText();
            pw.println(data);
            s.setText("");
           //s1.setText(data);
            }
        };
        send.addActionListener(ac);
        f.setVisible(true);
    }
}

