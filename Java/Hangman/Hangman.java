import java.util.Random;
import java.util.Scanner;

public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String guessWord = randomWord();
        System.out.println(guessWord);
        char [] placeHolder = new char[guessWord.length()];
        String missedChar = new String("Missed: ");
        for(int i=0;i < guessWord.length();i++) // "initial Placeholder"
        {
            placeHolder[i] = '_';
        }
        int hangCounter = 0;
        
        
        while(true)
        {
            clearScreen();
            
            displayHangMan(hangCounter);

            printPlaceHolder(placeHolder);
            System.out.print("\n");
            printMissedGuesses(missedChar);
            System.out.print("\n");
            System.out.print("Guess: ");
            char guess = Character.toLowerCase(scan.next().charAt(0));
            if(checkGuess(guessWord, guess) == true)
            {
                placeHolder = updatePlaceholder(guessWord, placeHolder,guess);
                
                String checkPlaceHolder = new String(placeHolder);
                if(guessWord.equals(checkPlaceHolder))
                {
                    System.out.println("\nYOU SAVE THE HANGMAN!!! ");
                    printPlaceHolder(placeHolder);
                    break;
                }
            }
            else
            {
                hangCounter++;
                if(hangCounter == 6)
                {
                    clearScreen();
                    displayHangMan(hangCounter);
                    System.out.print("Hangman died by the animal word '");
                    System.out.println(guessWord + " '. ");
                    break;
                }
                missedChar += guess + " ";
                
            }

        }
        

    }

    public static void displayHangMan(int hangCounter) {
        System.out.println(gallows[hangCounter]);
    }

    public static String randomWord()
    {
        Random random = new Random();
        int randomValue =  random.nextInt(64);
        return words[randomValue].toLowerCase();
    }

    public static boolean checkGuess(String guessWord, char guess)
    {
        for(int i = 0; i < guessWord.length();i++)
        {
            if(guess == guessWord.charAt(i))
            {
                return true;
            }
        }
        return false;
    }

    public static void clearScreen() 
    {  
        System.out.print("\033[H\033[2J");
        System.out.flush();
    } 

    public static char[] updatePlaceholder(String guessWord, char[] placeHolder, char guess)
    {

      for(int i = 0; i < guessWord.length();i++)
        {
            if(guess == guessWord.charAt(i))
            {
                placeHolder[i] = guessWord.charAt(i);
            }
        }
        return placeHolder;    
    }

    public static void printPlaceHolder(char[] placeHolder)
    {
       System.out.print("Word: ");
       for(char x: placeHolder)
        {
            System.out.print(x + " ");
        }
        System.out.println("\n");
    }

    public static void printMissedGuesses(String missedChar)
    {
        
        System.out.println(missedChar);

    }

}





