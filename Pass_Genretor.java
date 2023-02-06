
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import java.util.Random;
import java.util.Scanner;

public class Pass_Genretor {
    static   Random pwd=new Random();
    static int passw=pwd.nextInt(1111,9999);

    static String SName,SRank,SDomain,SMob,SEmail ; int a=1;
    void Enroll(){
        JFrame f=new JFrame("TCG enroll");
        f.setBounds(100,100,400,400);
        f.setLayout(null);

        JPanel panel=new JPanel();
        panel.setBackground(Color.decode("#8b8be8"));
        panel.setBounds(0,0,380,380);
        panel.setLayout(null);
        f.add(panel);
        Font myFont = new Font("ink free",Font.BOLD,16);
        JLabel Title=new JLabel("TCG Enrollment form ");
        Title.setBounds(110,5,200,30);
        Title.setFont(new Font("Arial", Font.PLAIN, 20)); 
        JLabel Name=new JLabel("NAME :"); Name.setFont(myFont);
        Name.setBounds(30,50,70,25);
        JLabel Rank=new JLabel("RANK : "); Rank.setFont(myFont);
        Rank.setBounds(30,90,70,25);
        JLabel Domain=new JLabel("Domain :");
        Domain.setBounds(30,130,70,25); Domain.setFont(myFont);
        JLabel Mob=new JLabel("Mobile No.");
        Mob.setBounds(30,170,70,25);    Mob.setFont(myFont); 
        JLabel email=new JLabel("Email ID");       email.setFont(myFont); 
        email.setBounds(30,210,70,25);
        panel.add(Title);panel.add(Name);panel.add(Rank);  panel.add(Domain);
        panel.add(Mob);panel.add(email);
        JTextField Namet=new JTextField();
        Namet.setBounds(100,50,200,20);
        JTextField Rankt=new JTextField();
        Rankt.setBounds(100,90,200,20);
        JTextField Domaint=new JTextField();
        Domaint.setBounds(100,130,200,20);
        JTextField Mobilet=new JTextField();
        Mobilet.setBounds(100,170,200,20);
        JTextField Emailt=new JTextField();
        Emailt.setBounds(100,210,200,20);
        JButton sub =new JButton("SUBMIT");
        sub.setBackground(Color.decode("#34d613"));
       sub.setBounds(150,260,100,25);

        panel.add(Namet);panel.add(Rankt);panel.add(Domaint);
        panel.add(Mobilet);panel.add(Emailt);panel.add(sub);
        f.setVisible(true);
        ActionListener ac=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String n=Namet.getText();
                String r=Rankt.getText();
               String d= Domaint.getText();
                String m=Mobilet.getText();
               String em= Emailt.getText();


                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/classroom","root","123456");
                    Statement smt=con.createStatement();

                    //  smt.execute("create Database Enroll");
                    //  System.out.println("database created Enroll");
                    //  smt.execute("create table TcgEnrollment1(id int AUTO_INCREMENT PRIMARY KEY,Name varchar(15),Rank1 varchar(20)," +
                    //       "Domain varchar(20),Mobile_NO varchar(10),Email_ID varchar(25),Password varchar(10))");
                    // System.out.println("table created sucessfully");

                    PreparedStatement psmt = con.prepareStatement("insert into TcgEnrollment1 values(?,?,?,?,?,?,?)");


                    psmt.setInt(1, 0);
                    psmt.setString(2, n);
                    psmt.setString(3, r);
                    psmt.setString(4,d);
                    psmt.setString(5,m);
                    psmt.setString(6,em);
                    psmt.setInt(7,passw);

                    psmt.executeUpdate();
                    String rank = null; String pp = null;
                    String qr = "Select * from TcgEnrollment1";
                    ResultSet rs = smt.executeQuery(qr);
                    while (rs.next()) {
                        String pass = rs.getString("Password");
                        String Name = rs.getString("Email_ID");
                         rank=rs.getString("Rank1");
                         pp= rs.getString("Domain");
                         String mobile=rs.getString("Mobile_NO");


                        System.out.println(pass + "\t" + Name);

                        Scanner user=new Scanner(System.in);
                        if(Emailt.getText().equals(Name)&& Mobilet.getText().equals(mobile)){
                            System.out.println(rank+"\t"+pp);
                    }
                    }
                }catch (Exception y){
                    System.out.println(y);
                }
            }
        };
        sub.addActionListener(ac);
    }


    public static void main(String[] args) {
        Pass_Genretor  p = new Pass_Genretor ();
        p.Enroll();
        System.out.println(passw);
    }
}










