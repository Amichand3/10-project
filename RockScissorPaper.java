import java.util.Random;
import java.util.Scanner;

public class RockScissorPaper {
    static int s=0,u=0;

    public static void main(String[] args) {
        
       
for(int i=1;i<=3;i++){
       
        String arr[]= {"rock","scissor","paper"};
       System.out.println("choose and enter the game rock paper scissor .. ");
        Scanner sc = new Scanner(System.in);
        String user = sc.nextLine();
       
        Random rm = new Random();
        int r = rm.nextInt(arr.length-1);
        System.out.println(arr[r]);
        String sys = arr[r];
        System.out.println(sys);

        if (user.equalsIgnoreCase(sys)){System.out.println("tied try again ");}
       else if(user.contains("rock")&& sys.contains("paper")){System.out.println("system won"); s++;}
       else if(user.contains("paper")&& sys.contains("scissor")){System.out.println("System won");s++;}
       else if(user.contains("scossor")&& sys.contains("rock")){System.out.println("System won");s++;}
        else{System.out.println("user won");u++;}

        
    }
    System.out.println(s);
    System.out.println(u);
    if(s==u){System.out.println("match tied");}
    else if(s>u){System.out.println("System won !!");}
    else if(s<u){System.out.println("user won !! ");}
}
}