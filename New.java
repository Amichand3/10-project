import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class New {
static  JFrame f, f1,f2;
static Font mf;
static JButton reg,login, forgot;

    void frame(){
         f = new JFrame("attendance_Sheet");
        f.setSize(400,400);
        f.setLayout(null);
         mf = new Font("serif",Font.HANGING_BASELINE,20);
        JLabel label = new JLabel("login your id and mark attendance");
        label.setBounds(40,5,300,30);
        label.setFont(mf);
        f.add(label);

        JPanel panel = new JPanel();
        panel.setSize(400,350);
        panel.setLayout(null);
        panel.setBackground(Color.decode("#80b7e0"));
        f.add(panel);
        JLabel username = new JLabel("User_name :");
        username.setBounds(10,50,100,20);
        panel.add(username);
        JTextField text = new JTextField();
        text.setBounds(100,50,150,20);
        panel.add(text);
        JLabel password = new JLabel("Password :");
       password.setBounds(10,80,100,20);
        panel.add(password);
        JTextField text1 = new JTextField();
        text1.setBounds(100,80,150,20);
        panel.add(text1);

         login = new JButton("Login");
        login.setBounds(120,150,100,30);
        panel.add(login);
        JLabel label1 = new JLabel("Don't Have a Account or Forgot password");
        label1.setBounds(30,200,350,30);
        label1.setFont(mf);
        panel.add(label1);
         reg = new JButton("Register");
        reg.setBounds(70,250,100,30);
        panel.add(reg);
         forgot = new JButton("Forgot_password");
        forgot.setBounds(190,250,150,30);
        panel.add(forgot);

        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        };
        ActionListener action1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","123456");
                    Statement st = con.createStatement();
                    String id = idt.getText();
                    String sql = "SELECT * FROM users WHERE id = '" + id + "'";
                    ResultSet rs = st.executeQuery(sql);
                    if (rs.next()) {
                        String name = rs.getString("name");
                       
                    }
                    
                }

                catch (Exception i){
                    System.out.println(i);
                }

            }
        };

        reg.addActionListener(action1);
        login.addActionListener(action);

        f.setVisible(true);
    }
    static  void login(){

        f2 = new JFrame("login");
        f2.setSize(400,400);
        f2.setLocation(500,0);
        f2.setLayout(null);
        JLabel label = new JLabel("fill your Attendance");
        label.setBounds(70,5,300,30);
        label.setFont(mf);
        f2.add(label);
        JPanel panel = new JPanel();
        panel.setSize(380,300);
        panel.setBackground(Color.decode("#1568ed"));
        panel.setLayout(null);
        f2.add(panel);
        JLabel name = new JLabel("Name");
        name.setBounds(10,50,80,20);
        panel.add(name);
        JTextField namet = new JTextField();
        namet.setBounds(100,50,150,20);
        panel.add(namet);
        JLabel id = new JLabel("user_Id :");
        id.setBounds(10,70,80,20);
        panel.add(id);
        JTextField idt = new JTextField();
        namet.setBounds(100,70,150,20);
        panel.add(idt);
        JTable tb = new JTable();
        tb.setBounds(20,120,200,200);
        panel.add(tb);





        f2.setVisible(true);
    }

   static void register(){


        f1 = new JFrame("Registration");
        f1.setLayout(null);
        f1.setLocation(500,20);
        f1.setSize(400,450);
        f1.setVisible(true);

        JLabel label = new JLabel("Registration Form");
        label.setBounds(50,10,150,30);
        f1.add(label);
        label.setFont(mf);
        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBackground(Color.decode("#5798c9"));
        panel1.setSize(380,400);
        f1.add(panel1);
        JLabel name = new JLabel("Name :");
        name.setBounds(20,50,80,20);
        panel1.add(name);
        JTextField namet = new JTextField();
        namet.setBounds(110,50,120,20);
        panel1.add(namet);
       JLabel mail = new JLabel("Email :");
       mail.setBounds(20,80,80,20);
       panel1.add(mail);
       JTextField mailt = new JTextField();
       mailt.setBounds(110,80,120,20);
       panel1.add(mailt);
       JLabel rank = new JLabel("Rank :");
       rank.setBounds(20,110,80,20);
       panel1.add(rank);
       JTextField rankt = new JTextField();
       rankt.setBounds(110,110,120,20);
       panel1.add(rankt);
       JLabel mob = new JLabel("mob No :");
       mob.setBounds(20,140,80,20);
       panel1.add(mob);
       JTextField mobt = new JTextField();
       mobt.setBounds(110,140,120,20);
       panel1.add(mobt);
       JLabel pass = new JLabel("Pass :");
       pass.setBounds(20,170,80,20);
       panel1.add(pass);
       JTextField passt = new JTextField();
       passt.setBounds(110,170,120,20);
       panel1.add(passt);
       JLabel repass = new JLabel("Re_pass :");
       repass.setBounds(20,200,80,20);
       panel1.add(repass);
       JTextField repasst = new JTextField();
       repasst.setBounds(110,200,120,20);
       panel1.add(repasst);
       JButton regt = new JButton("REGISTER");
       regt.setBounds(100,250,100,30);
       panel1.add(regt);
       JLabel label2 = new JLabel();
       label2.setBounds(100,360,200,20);
       label2.setFont(new Font("serif",Font.BOLD,14));
       panel1.add(label2);
       JLabel passn = new JLabel();
       passn.setBounds(100,290,200,20);
       panel1.add(passn);
       JLabel passp = new JLabel();
       passp.setBounds(100,315,200,20);
       panel1.add(passp);
      
       ActionListener action3 = new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               label2.setText("SuccessFully registered ");
               String mail = mailt.getText().toString();
               String pass = passt.getText().toString();
               passn.setText("username"+mail);
               passp.setText("password"+pass);
               try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","123456");
                Statement st = con.createStatement();
                st.executeUpdate("CREATE DATABASE IF NOT EXISTS mydatabase");
                st.executeUpdate("USE mydatabase");
                st.executeUpdate("CREATE TABLE IF NOT EXISTS users (id INT NOT NULL AUTO_INCREMENT, name VARCHAR(45), email VARCHAR(45), rank VARCHAR(45), mobile VARCHAR(45), password VARCHAR(45), PRIMARY KEY (id))");
                     
       String name = namet.getText();
       String email = mailt.getText();
       String rank = rankt.getText();
       String mobile = mobt.getText();
       String password = passt.getText();
       String sql = "INSERT INTO users (name, email, rank, mobile, password) VALUES ('" + name + "', '" + email + "', '" + rank + "', '" + mobile + "', '" + password + "')";
       st.executeUpdate(sql);
    } catch (Exception e1) {
        System.out.println(e1);
     }

               
           }
       };
        regt.addActionListener(action3);
   

    }
    public static void main(String[] args) {

        Attendance at = new Attendance();
        at.frame();
      //  at.login();

    }
} 

