import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;

import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;


public class Notes {
 


    public void note(){

        JFrame f = new JFrame("notes");
        f.setSize(500,450);
        f.setLayout(null);
        Font mf = new Font("serif",Font.BOLD,20);
        JLabel label = new JLabel("Handnotes Heading");
        label.setFont(mf);
        label.setBounds(100, 5, 200, 40);
        f.add(label);
        JTextField text = new JTextField();
        text.setBounds(70,50,250,40);
        text.setFont(mf);
        f.add(text);

        JLabel label1 = new JLabel("write your notes here");
        label1.setBounds(100,100,200,30);
        label1.setFont(mf);
        f.add(label1);

        JTextArea notes = new JTextArea();
        notes.setBounds(40 , 140, 300, 100);
        f.add(notes);

        JButton submit = new JButton("SUBMIT");
        submit.setBounds(120,260,80,30);
        submit.setBackground(Color.decode("#c2a9d9"));
        f.add(submit);

        JLabel label2 = new JLabel();
        label2.setBounds(80,300,300,30);
        label2.setFont(mf);
        label2.setBackground(Color.decode("#91edbc"));
        f.add(label2);

        ActionListener action = new ActionListener(){

            @Override
            public void actionPerformed (ActionEvent e){
                String st = text.getText();
                String st1 = notes.getText();
                try {
                    // File obj = new File("handnotes.txt");
                    // if(obj.createNewFile()){System.out.println("File Successfully created");}
                    // else{
                    //     System.out.println("file Already Exist");
                    // }
                   
                    FileWriter writer = new FileWriter("handnotes.txt",true);
                     writer.write("This is heading >> \t"+st+"\n");
                    writer.write("Notes :- "+st1);
                    writer.close();
                } catch (Exception i) {
                    System.out.println(i);
                }
                    if(st.isBlank() &&st1.isEmpty()){
                        label2.setText("Data is nothing for save");
                      
                        else{label2.setText("Data will be saved");}

               

             //   label2.setText("Your Hand Written Notes saved");
            }
        };

        submit.addActionListener(action);
        f.setVisible(true);


    }

    public static void main(String[] args) {
        Notes N =new Notes();
        N.note();
    }
    
}
