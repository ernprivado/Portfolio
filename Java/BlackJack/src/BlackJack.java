
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BlackJack {

    public static String cardA = "   _____\n"+
                   "  |A _  |\n"+ 
                   "  | ( ) |\n"+
                   "  |(_'_)|\n"+
                   "  |  |  |\n"+
                   "  |____V|\n";
    public static String card2 = "   _____\n"+              
                    "  |2    |\n"+ 
                    "  |  o  |\n"+
                    "  |     |\n"+
                    "  |  o  |\n"+
                    "  |____2|\n";
    public static String card3 = "   _____\n"+              
                    "  |3    |\n"+ 
                    "  |  o  |\n"+
                    "  |  o  |\n"+
                    "  |  o  |\n"+
                    "  |____3|\n";
    public static String card4 = "   _____\n"+              
                    "  |4    |\n"+ 
                    "  | o o |\n"+
                    "  |     |\n"+
                    "  | o o |\n"+
                    "  |____4|\n";
    public static String card5 = "   _____ \n" +
                    "  |5    |\n" +
                    "  | o o |\n" +
                    "  |  o  |\n" +
                    "  | o o |\n" +
                    "  |____5|\n";
    public static String card6 = "   _____ \n" +
                    "  |6    |\n" +
                    "  | o o |\n" +
                    "  | o o |\n" +
                    "  | o o |\n" +
                    "  |____6|\n";
    public static String card7 = "   _____ \n" +
                    "  |7    |\n" +
                    "  | o o |\n" +
                    "  |o o o|\n" +
                    "  | o o |\n" +
                    "  |____7|\n";
    public static String card8 = "   _____ \n" +
                    "  |8    |\n" +
                    "  |o o o|\n" +
                    "  | o o |\n" +
                    "  |o o o|\n" +
                    "  |____8|\n";
    public static String card9 = "   _____ \n" +
                    "  |9    |\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |____9|\n";
    public static String card10 = "   _____ \n" +
                    "  |10  o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |___10|\n";
    public static String cardJack = "   _____\n" +
                    "  |J  ww|\n"+ 
                    "  | o {)|\n"+ 
                    "  |o o% |\n"+ 
                    "  | | % |\n"+ 
                    "  |__%%[|\n";
    public static String cardQueen = "   _____\n" +
                    "  |Q  ww|\n"+ 
                    "  | o {(|\n"+ 
                    "  |o o%%|\n"+ 
                    "  | |%%%|\n"+ 
                    "  |_%%%O|\n";
    public static String cardKing ="   _____\n" +
                    "  |K  WW|\n"+ 
                    "  | o {)|\n"+ 
                    "  |o o%%|\n"+ 
                    "  | |%%%|\n"+ 
                    "  |_%%%>|\n";
    public static String cardFacedown ="   _____\n" +
                    "  |     |\n"+ 
                    "  | o o |      \n"+ 
                    "  |  >  |    <----- \n"+ 
                    "  |  __ |      \n"+ 
                    "  |.    |\n";
    public static Scanner scan = new Scanner(System.in);
    

    public static void main(String[] args) throws InterruptedException {
        clearScreen();
        System.out.println("++++++++++++++. Welcome to BlackJackyChan +++++++++++++\n Ready? Press Enter to begin");
        
        scan.nextLine();
        clearScreen();
        int playerTotal = 0;
        int dealerTotal= 0;
        int card1=0, card2=0, card3=0;


        TimeUnit.MILLISECONDS.sleep(1000);
        card1 = drawRandomCard();
        TimeUnit.MILLISECONDS.sleep(1000);
        card2 = drawRandomCard();

        System.out.println("You card are...");
        printCard(card1);
        printCard(card2);
        playerTotal = checkTotalCard(Math.min(card1,10), Math.min(card2,10));
        
        System.out.println("Your Total is "+ playerTotal);


        System.out.println("Dealer's Cards are...");
        int dealerCard1 = drawRandomCard(); 
        int dealerCard2 = drawRandomCard();
        TimeUnit.MILLISECONDS.sleep(1000);
        printCard(dealerCard1);
        faceDown();
        System.out.println("... a card is facedown");
        System.out.println("Dealer Total is hidden ("+Math.min(dealerCard1, 10) +" + XX )");
        

        while (true)
        {
            
            String option = hitOrStay();

            if(option.equals("stay"))
            {
                break;
            }
            card3 = drawRandomCard();
            printCard(card3);
            playerTotal = checkTotalCard(playerTotal, Math.min(card3,10));
            System.out.println("Your New Total is "+ playerTotal);

        }

        System.out.println("Dealer's Cards are...");
        printCard(dealerCard1);
        TimeUnit.MILLISECONDS.sleep(4000);
        printCard(dealerCard2);

        
        dealerTotal = Math.min(dealerCard1,10)+Math.min(dealerCard2,10);

        if(dealerTotal > playerTotal)
        {
            System.out.println("Dealer total is " + dealerTotal);
            System.out.println("Dealer Wins! ");
        }
        else{
            System.out.println("You Wins! ");
        
        }
        //scan.close();

        
    }

    public static String hitOrStay()
    {
        System.out.println("Do you want to 'hit' or 'stay'?");
        String option = scan.nextLine();
        while(!(option.equalsIgnoreCase("hit") || option.equalsIgnoreCase("stay")))
        {
            System.out.println("please write hit or stay");
            option = scan.nextLine();
        }
        return option;
    }
    static void faceDown()
    {
        System.out.println(cardFacedown);

    }

    public static void clearScreen() {  
    System.out.print("\033[H\033[2J");
    System.out.flush();
    }  


    static int checkTotalCard(int card1, int card2)
    {
        if(card1+ card2 >21)
        {
            
            System.out.println("BUST BOY! You Loose!\n Dealer Wins!");
            System.exit(0);
            return 0; 
        }
        else{
            return card1+card2;
        }
    }
    static void printCard(int cardNumber)
    {
        switch (cardNumber) {
            case 1:
                System.out.println(cardA);
                break;
            case 2:
                System.out.println(card2);
                break;
            case 3:
                System.out.println(card3);
                break;
            case 4:
                System.out.println(card4);
                break;
            case 5:
                System.out.println(card5);
                break;
            case 6:
                System.out.println(card6);
                break;
            case 7:
                System.out.println(card7);
                break;
            case 8:
                System.out.println(card8);
                break;
            case 9:
                System.out.println(card9);
                break;
            case 10:
                System.out.println(card10);
                break;
            case 11:
                System.out.println(cardJack);
                break;
            case 12:
                System.out.println(cardQueen);
                break;
            case 13:
                System.out.println(cardKing);
                break;
            default:
                break;
        }
    }

    static int drawRandomCard()
    {
        int card = (int) (Math.random()*13)+1; 
        return card;
    }

}
