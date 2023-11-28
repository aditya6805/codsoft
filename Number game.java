import java.util.Random;
import java.util.Scanner;

public class RandomNumberGenerator {
    public static void main(String[] args)
    {
        System.out.println("Welcome to Guessing Game");
        System.out.println("************************************");
        int count_palyer_game = 0;
        int flag = 0;
        boolean run_again = true;
        
        while(run_again)
        {
            System.out.println("Round: " + (count_palyer_game+1));
            System.out.println("************************************");
            flag = guess_number(flag);
            count_palyer_game += 1;
            String user_input = ask_player();
            if (user_input.equalsIgnoreCase("N"))
            {   
                run_again = false;
            }
        }
        result(count_palyer_game, flag);
    }

    public static int guess_number(int flag)
    {
        int min = 1;  // Minimum value of the range
        int max = 100;  // Maximum value of the range

        Random random = new Random();
        int randomnumber = random.nextInt((max - min) + 1) + min;
        
        // taking the guess number
        int guessnumber=0;
        Scanner sc=new Scanner(System.in);
        int terminate=0;
        while(terminate<10)
        {
            if(guessnumber != randomnumber)
            {
                System.out.println("\nGuess the number between 1 to 100 : ");
                guessnumber=sc.nextInt();
                if(guessnumber>randomnumber)
                {
                    if(guessnumber-randomnumber>=30)
                    {
                        System.out.println("too high");  
                    }
                    else if(guessnumber-randomnumber<=5)
                    {
                        System.out.println("about to reach");  
                    }
                    else if(guessnumber-randomnumber<=30)
                    {
                        System.out.println("keep trying");  
                    }
                }
                if(randomnumber>guessnumber)
                {
                    if(randomnumber-guessnumber>=30)
                    {
                        System.out.println("too low");  
                    }
                    else if(randomnumber-guessnumber<=5)
                    {
                        System.out.println("about to reach");  
                    }
                    else if(randomnumber-guessnumber<=30)
                    {
                        System.out.println("keep trying");  
                    }
                }
                if(randomnumber==guessnumber)
                {
                    System.out.println("Wow! you made it ");
                    flag+=1;
                }
            }
            terminate=terminate+1;
        }
        return flag;
    }

    public static String ask_player()
    {
        System.out.println("************************************");
        System.out.println("Do you want  to Play Again (Y/N) ??");
        Scanner sc=new Scanner(System.in);
        String inp = sc.nextLine();
        return inp;
    }

    public static void result(int num_of_games, int number_of_wins)
    {
        System.out.println("************************************");
        System.out.println("No of Games played by the user: " + num_of_games);
        System.out.println("No of Wins: " + number_of_wins);
    }
}
