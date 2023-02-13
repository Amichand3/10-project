import java.awt.*;
import java.awt.event.*;
import java.awt.ActionEvent.*;
import java.util.TimeZone;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;


public class Demo implements ActionListener {

    JFrame frame;
    JTextField text;
    JButton [] numberbuttons = new JButton[10];
    JButton [] functiButtons = new JButton[9];
    JButton addButton, mulButton,subButton,divButton;
    JButton decButton,eqButton,delButton,clrButton,negButton;
    JPanel panel;

    Font myFont = new Font("ink free",Font.BOLD,18);
    double num1 =0,num2=0,result =0;
    char opertor;
    Demo(){
        
        frame = new JFrame("Calculator");
        //frame.setDefaultColseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        text = new JTextField();
        text.setBounds(50,25,300,35);
        text.setFont(myFont);
        text.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        decButton = new JButton("(.)");
        delButton = new JButton("DEl");
        clrButton = new JButton("clrscr");
        negButton = new JButton("-1");

        functiButtons [0]= addButton;
        functiButtons [1]= subButton;
        functiButtons [2]= mulButton;
        functiButtons [3]= divButton;
        functiButtons [4]= eqButton;
        functiButtons [5]= decButton;
        functiButtons [6]= delButton;
        functiButtons [7]= clrButton;
        functiButtons [8]= negButton;
        for(int i =0;i<9;i++){
            functiButtons[i].addActionListener(this);
            functiButtons[i].setFont(myFont);
            functiButtons[i].setFocusable(false);

        }
        for(int i=0;i<10;i++){
            numberbuttons[i]=new JButton(String.valueOf(i));
            numberbuttons[i].addActionListener(this);
            numberbuttons[i].setFont(myFont);
            numberbuttons[i].setFocusable(false);
        }

        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numberbuttons[1]);
        panel.add(numberbuttons[2]);
        panel.add(numberbuttons[3]);
        panel.add(addButton);
        panel.add(numberbuttons[4]);
        panel.add(numberbuttons[5]);
        panel.add(numberbuttons[6]);
        panel.add(subButton);
        panel.add(numberbuttons[7]);
        panel.add(numberbuttons[8]);
        panel.add(numberbuttons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberbuttons[0]);
        panel.add(eqButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(text);
        frame.setVisible(true);




    }
   
    public static void main(String[] args) {
        Demo d = new Demo();
        
    }
    @Override
    public void actionPerformed(ActionEvent e){
        for(int i=0;i<10;i++){
            if(e.getSource()==numberbuttons[i]){
                text.setText(text.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton){
            text.setText(text.getText().concat("."));
        }
        if(e.getSource()==addButton){
            num1= Double.parseDouble(text.getText());
            opertor='+';
            text.setText("");
        }
        if(e.getSource()==subButton){
            num1= Double.parseDouble(text.getText());
            opertor='-';
            text.setText("");}
            if(e.getSource()==mulButton){
                num1= Double.parseDouble(text.getText());
                opertor='*';
                text.setText("");}
         if(e.getSource()==divButton){
                    num1= Double.parseDouble(text.getText());
                    opertor='/';
                    text.setText("");}
        if(e.getSource()==eqButton){
                        num2= Double.parseDouble(text.getText());
                        
                        switch(opertor){
                            case '+':result=num1+num2; break;
                            case '-':result=num1-num2; break;
                            case '*':result=num1*num2; break;
                            case '/':result=num1/num2; break;

                        }
                        text.setText(String.valueOf(result));
                        num1=result;
                    }
        if(e.getSource()==clrButton){
            text.setText("");
        }
        if(e.getSource()==delButton){
            String string = text.getText();
            text.setText("");
        for(int i=0;i<string.length()-1;i++){
            text.setText(text.getText()+string.charAt(i));
        }
        }
        if(e.getSource()==negButton){
            double temp = Double.parseDouble(text.getText());
            temp*=-1;
            text.setText(String.valueOf(temp));}

        }


        }


        
    
