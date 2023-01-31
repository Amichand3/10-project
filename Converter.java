import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Converter {

    void cv (){
        JFrame f = new JFrame("converter");
        f.setAlwaysOnTop(true);
        f.setSize(600,450);
        f.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(10,10,400,500);
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
      //  panel.setSize(500,400);
            f.add(panel);

            Font myf = new Font("ink free", Font.BOLD,20);
        
        JLabel label = new JLabel("convert currency");
        label.setBounds(10,30,200,20);
        label.setFont(myf);
        panel.add(label);

        JTextField inr = new JTextField();
        inr .setBounds(10, 60, 100, 30);
        panel.add(inr);

        JLabel label1 = new JLabel("converted currency value");
        label1.setBounds(120,60,150,30);
        label.setFont(myf);
        panel.add(label1);

        
        JTextField inr1 = new JTextField();
        inr1.setBounds(300, 60, 100, 30);
        panel.add(inr1);

        ButtonGroup bg = new ButtonGroup();
        JRadioButton one = new JRadioButton("rupees to Dollar");
        one.setBounds(20,100,200,30);
        bg.add(one);
        panel.add(one);
        JRadioButton two = new JRadioButton("rupees to Euro");
        two.setBounds(20,140,200,30);
        panel.add(two);
        bg.add(two);
        JRadioButton three = new JRadioButton("rupees to japani currency");
        three.setBounds(20,180,200,30);
        panel.add(three);
        bg.add(three);
        

        ActionListener action = new ActionListener(){

           public void actionPerformed (ActionEvent e){
           Double  d = Double.parseDouble( inr.getText());
           double d1 = (d/80);
           String str= String.valueOf(d1);
           inr1.setText(str);

           }
        };
        ActionListener action1 = new ActionListener(){

            public void actionPerformed (ActionEvent e){
             double d = Double.parseDouble(inr.getText());
            double d2 = (d/101);
            String str1 = String.valueOf(d2);
            inr1.setText(str1);

 
            }
         };
         ActionListener action2 = new ActionListener(){

            public void actionPerformed (ActionEvent e){
             
                int a = Integer.parseInt(inr.getText());
                float b = (a/1.59f);
                String str2 = String.valueOf(b);
                inr1.setText(str2);
 
            }
         };




        one.addActionListener(action);
        two.addActionListener(action1);
        three.addActionListener(action2);
        f.setVisible(true);
    }
    public static void main(String[] args) {
        
        Converter c = new Converter();
        c.cv();

    }
    
}