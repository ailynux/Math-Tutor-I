/*
Ailyn Diaz
CSC 1060 Java
9/28/2022
Math Tutor Part I ----> Write a program that will help an
elementary school student learn multiplication. Create two
random positive one-digit integers.
 */

import java.io.*;
import java.util.*;
import java.security.SecureRandom;

public class Main {
    //static scanner and secure random objects
    static SecureRandom rand = new SecureRandom();
    static Scanner sc= new Scanner(System.in);
    static int countQuestions = 0;
    static int countCorrect = 0;
    static final int NUM_QUESTIONS = 10;

    //function to generate Questions
    public static int generateQuestion() {
        //generates two random integers in between 1-9
        int r1 = rand.nextInt(9)+1;
        int r2 = rand.nextInt(9)+1;

        System.out.println("How much is "+r1+" times "+r2+"?");
        System.out.print("Enter your answer (-1 to exit): ");

        //returns their true product
        return r1*r2;
    }
    //function to display message
    public static void displayMessage(boolean isCorrect){
        //All responses
        String correctResponses[]={"Very good! ","Excellent! ","Nice work! ","Keep up the good work! "};
        String wrongResponses[]={"No. Please try again. ","Wrong. Try once more. ","Don't give up. ","No. Keep trying. "};

        //random number to choose random responses
        int ch=rand.nextInt(4);

        //prints correct response depending on the given answer is correct or not
        if(isCorrect){
            System.out.println(correctResponses[ch]);
        }
        else
            System.out.print(wrongResponses[ch]+"\nEnter your answer: ");
    }
    public static void main (String[] args) {

        int answer1=0;//Actual answer
        int answer2=1;//user answer


        while(true){
            countQuestions++;
            //prints question
            answer1=generateQuestion();
            //take user input
            answer2=sc.nextInt();

            //COUNTING THE Questions
            if(answer2==answer1){
                countCorrect++;
            }
            if(NUM_QUESTIONS==countQuestions){
                System.out.println("\n");
                System.out.printf("You scored %.2f%%%n", (double)countCorrect/countQuestions*100);
                System.out.println("");
                countQuestions=0;
                countCorrect=0;
            }//displays what the user got

            //loop until user enters -1
            if(answer2==-1)
            {
            //if user input is -1 then exit with bye message
                System.out.println("Bye.");
                break;
            }

            boolean isCorrect=false;
            if(answer2==answer1)
            {
                isCorrect=true;
                displayMessage(isCorrect);
            }
            else
            {
            //if user enters wrong answer iterate till it enters correct answer
                while(answer2!=answer1)
                {
                    displayMessage(isCorrect);
                    answer2=sc.nextInt();
                }
                isCorrect=true;
                displayMessage(isCorrect);

            }
        }
    }
}//end
