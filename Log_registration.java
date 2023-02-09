import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.awt.components.*;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;

import org.w3c.dom.css.ElementCSSInlineStyle;




public class Log_registration {

void log(){
    JFrame f = new JFrame("Registration");
    f.setSize(500,450);
    f.setLayout(null);
    Font myFont = new Font("serif",Font.BOLD,18);
    JLabel lab = new JLabel("Login your Account (its login page)");
    lab.setFont(myFont);
    lab.setBounds(50,5,300,25);
    //lab.setFont("serif",Font.BOLD,20);
    f.add(lab);
    
    JPanel panel = new JPanel();
    panel.setSize(480,400);
    panel.setBackground(Color.decode("#b6d1cf"));
    panel.setLayout(null);
    f.add(panel);
    JLabel user = new JLabel("User_Name : ");
    user.setBounds(10, 50, 100, 20);
    panel.add(user);
    JTextField usert = new JTextField();
    usert.setBounds(120, 50, 150, 20);
    panel.add(usert);
    JLabel pass = new JLabel("Password : ");
    pass.setBounds(10, 80, 100, 20);
    panel.add(pass);
    JPasswordField passt = new JPasswordField();
    passt.setBounds(120, 80, 150, 20);
    panel.add(passt);
    JButton login = new JButton("Login");
    login.setBounds(100,140,100,30);
    login.setBackground(Color.decode("#bfc7c6"));
    panel.add(login);
    JLabel lab2 = new JLabel("Not have a account please Registration first");
    lab2.setFont(myFont);
    lab2.setBounds(20,190,350,20);
    panel.add(lab2);
    JButton regButton = new JButton("REGESTRATION");
    regButton.setBounds(100 ,230,130,30);
    regButton.setBackground(Color.decode("#9c7ec4"));
    panel.add(regButton);
    f.setVisible(true);

    
   
    ActionListener action=new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String st =usert.getText();
            String pwd = passt.getText();
            try{
                FileWriter writer = new FileWriter("datasave.txt",true);
                writer.write(st+"\t");
                writer.append(pwd);
                writer.close();

            //     FileReader rd = new FileReader("datasave.txt");
            // Scanner sc= new Scanner(rd);
            // String data =sc.nextLine();

            // while (sc.hasNextLine()) {
            //     data = sc.nextLine();
            //     System.out.println(data);

            //     System.out.println(usert);
            //     if (data.contains(usert)) {
            //         System.out.println(data);
            //         System.out.println(usert);
            //         System.out.println("sucessfully Login");
            //     } else { System.out.println("Not registred");}

            // }
            }      catch (Exception n){
                    System.out.println(n);
                }
           
        }
    };
    login.addActionListener(action);
    ActionListener action1=new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           register();
        }};
        regButton.addActionListener(action1);

    }

        static void register(){

            JFrame f1=new JFrame("Register");
            f1.setSize(410,400);
            f1.setLocation(600,0);
            f1.setLayout(null);

            JLabel lab = new JLabel("Registration form ");
            lab.setBounds(100,10,200,30);
          Font myFont1 = new Font("ink free",Font.BOLD,17);
            lab.setFont(myFont1);
            f1.add(lab);
            JPanel panel = new JPanel();
            panel.setBackground(Color.decode("#b6d1cf"));
            panel.setSize(400,400);
            panel.setLayout(null);
            f1.add(panel);

            JLabel name = new JLabel("Name : ");
            name.setBounds(20,50,80,20);
            panel.add(name);
            JTextField namet = new JTextField();
            namet.setBounds(120,50,120,20);
            panel.add(namet);
            JLabel mail = new JLabel("Email : ");
            mail.setBounds(20,80,80,20);
            panel.add(mail);
            JTextField mailt = new JTextField();
            mailt.setBounds(120,80,120,20);
            panel.add(mailt);
            JLabel sex = new JLabel("sex : ");
            sex.setBounds(20,110,80,20);
            panel.add(sex)  ;
            JRadioButton m = new JRadioButton("male");
            JRadioButton f = new JRadioButton("Female");
            JRadioButton o = new JRadioButton("other");
            m.setBounds(90, 110,60,20);
            f.setBounds(160, 110,70,20);
            o.setBounds(240, 110,70,20);
            panel.add(o);panel.add(f);panel.add(m);

            JLabel pass = new JLabel("Enter password : ");
             pass.setBounds(20,140,120,20);
            panel.add(pass);
            JTextField passt = new JTextField();
            passt.setBounds(140,140,120,20);
            panel.add(passt);
            
            JLabel pass1 = new JLabel("Renter password : ");
            pass1.setBounds(20,170,120,20);
            panel.add(pass1);
            JTextField passt1 = new JTextField();
            passt1.setBounds(140,170,120,20);
            panel.add(passt1);
            JLabel mob =new JLabel("Enter Mobile no. :");
            mob.setBounds(20,200,100,20);
            panel.add(mob);
            JTextField mot = new JTextField();
            mot.setBounds(140,200,120,20);
            panel.add(mot);
            JButton regester = new  JButton("REGESTER");
            regester.setBounds(100,250,100,20);
            panel.add(regester);
            JLabel show = new JLabel();
            show.setBounds(100,280,200,50);
            panel.add(show);

            ActionListener action2=new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String smail = mailt.getText();
                    String sname = namet.getText();

                   // String spass = pass.getText();
                   // String spass1 = pass.getText();
                   // int spass2 = Integer .parseInt(spass);
                  //  int spass3 = Integer .parseInt(spass1);
                    if(smail.contains("@")&& smail.contains(".com")){
                        show.setText("you are successfully regester here");
                    }
                  //  else if(spass2==spass3){show.setText("password not same");}
                  else if(sname.length()>5){show.setText("Name less than 5 letter ");}
                    else{
                        show.setText("Email is mandatory ");
                        
                        
                    }
                   
                }};
                regester.addActionListener(action2);
        

            f1.setVisible(true);
        
}

    public static void main(String[] args) {

        Log_registration l = new Log_registration();
        l.log();
        
    }
}
