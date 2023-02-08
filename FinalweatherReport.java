import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class FinalweatherReport {
    static  Scanner sc;
    static String city, state,temp,humidity,visibility, base, pressure ;
    static JTextField text,text2;
    static JTextArea t;

   static void code(){
        try {
            sc = new Scanner(System.in);
           // System.out.println("enter city");
           // city = sc.nextLine();
            city= text.getText();
            //System.out.println("enter state");
           // state = sc.nextLine();
           state = text2.getText();
            URL url1 = new URL("http://api.openweathermap.org/geo/1.0/direct?q="+city+","+state+",+91&limit=1&appid=3ced127861920b8bd12a7da046f7df43");
            HttpURLConnection u1 = (HttpURLConnection)url1.openConnection();
            u1.setRequestMethod("GET");
            InputStreamReader in= new InputStreamReader(u1.getInputStream());
            BufferedReader in1 = new BufferedReader(in);
           
            String st ="";

           while( st!=null){
             st = in1.readLine();
            // System.out.println(st);

       
           in1.close();
        JSONParser pr = new JSONParser();
        JSONArray arr = (JSONArray) pr.parse(st);
        JSONObject obj = (JSONObject) arr.get(0);
        System.out.println(obj.get("lat"));
        System.out.println(obj.get("lon"));
        Object lat =  (obj.get("lat")) ;
        Object lon = (obj.get("lon"));
        Double lat1= (Double) lat;
        Double lon1= (Double) lon;

        URL url2 = new URL("https://api.openweathermap.org/data/2.5/weather?lat="+lat1+"&lon="+lon1+"&appid=3ced127861920b8bd12a7da046f7df43");
        HttpURLConnection u2 =(HttpURLConnection)url2.openConnection();
        u2.setRequestMethod("GET");
        InputStreamReader rd = new InputStreamReader(u2.getInputStream());
        BufferedReader rd2 = new BufferedReader(rd);
        String st2 = "";
        String st3="";
        while(st2!=null){
            st2 = rd2.readLine();
           // System.out.println(st2);
            st3 = st3+st2;
            rd.close();

            JSONParser pr2 = new JSONParser();
        JSONObject obj1 = (JSONObject) pr2.parse(st3);
         
       // System.out.println(obj1.get("main"));
        System.out.println("visivility is :"+obj1.get("visibility"));
        System.out.println("Stations is :"+obj1.get("base"));

        JSONObject obj2 = (JSONObject) (obj1.get("main"));
         System.out.println("pressure is :"+obj2.get("pressure"));
        System.out.println("temp is : "+obj2.get("temp"));
        System.out.println("humidity is : "+obj2.get("humidity"));

         temp = obj2.get("temp") .toString();
         visibility = obj1.get("visibility") .toString();
         pressure = obj2.get("pressure") .toString();
        humidity = obj2.get("humidity") .toString();
        base = obj1.get("base") .toString();

            


       
        }
            }
        }  
        
        catch (Exception e) {
            System.out.println(e);}
    }
    public static void main(String[] args) {
       

            JFrame f = new JFrame("report");
            f.setSize(600,450);
            f.setLayout(null);
            Font mm = new Font("ink free",Font.BOLD,16);
            JLabel label = new JLabel("welcome!! search your city weather information ");
           //label.setFont("ink free",Font.CENTER_BASELINE,20);
            label.setBounds(50, 5, 300, 20);
            f.add(label);
            JLabel city = new JLabel("enter your city");
            city.setBounds(10,30,120,20);
            city.setFont(mm);
            f.add(city);
             text = new JTextField();
            text.setBounds(140,30,100,20);
            f.add(text);
            JLabel state = new JLabel("enter tour state code: ");
            state.setBounds(10,60,170,20);
            state.setFont(mm);
            f.add(state);
             text2 = new JTextField();
            text2.setBounds(180, 60, 100, 20);
            f.add(text2);
            JButton search = new JButton("Search");
            search.setBounds(100, 100, 80, 30);
            search.setBackground(Color.decode("#5c55e0"));
            f.add(search);
           
           JTextArea t = new JTextArea();
           t.setFont(mm);
            t.setBounds(50,150,200,150);
            t.setEditable(false);
            f.add(t);

            ActionListener ac=new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    code();
               
                t.setText("Temperature is: "+temp+"\n");
                 t.append("base is : "+base+"\n");
                 t.append("pressure is :"+pressure+"\n");
                  t.append("visiblity is : "+visibility+"\n");
                t.append("humidity is : "+humidity+"\n"+"\n");
                t.append("search next city weather ") ;
                 
             
                  
                }
    
            };

            search.addActionListener(ac);
           
            f.setVisible(true);
        
        
       
}

    } 


    
