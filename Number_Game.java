import java.util.Random;
import java.util.Scanner;

public class Number_Game {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random rndm=new Random();

        int max_attempt=3;
        int score=100;
        int guessNum;
        int target= (int)(rndm.nextDouble()*10+1);
        System.out.println("\n\nGuess the number between (1-100)");
        System.out.println("You have maximum "+max_attempt +" attempts\n");
        System.out.println("----------------------So let's begin the game now------------------\n");
        System.out.print("Enter your 1st Guess Number : ");
        guessNum=sc.nextInt();
        int attemptNum=1;
        while(guessNum!=target && attemptNum<=max_attempt){
            if(guessNum<target){
                System.out.println("Your Number too less...");
            }
            else{
                System.out.println("Your Number too high...");
            }
            System.out.print("(attempt left "+(max_attempt-attemptNum)+") Next Guess : ");
            guessNum=sc.nextInt();
            attemptNum++;
        }
        System.out.println("\n--------------------------------------------------------------------");
        if(guessNum==target){
            System.out.println("Congratulations!!!!...Correct...");
        }else{
            System.out.println("Oops...!!!");
        }
        System.out.println("The Number was : "+guessNum);
        System.out.println("Your Score is "+score/attemptNum);
    }
}
