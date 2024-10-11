
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.Random;

public class FoundException {
    public static void main(String[] args) {

        // exercise 1.1
        Date date = null;
        Date today = new Date();

        ArrayList<Date> listOfDates = new ArrayList<>();
        listOfDates.add(date);
        listOfDates.add(today);

        listOfDates.forEach((el) -> {
            try {
                // getClass() comes from mother Class Object
                System.out.println(el.getClass().getName());
            } catch (NullPointerException e){
                System.out.println("The element is null !");
            }
        });

        // exercise 1.2

        /*Scanner sc = new Scanner(System.in);
        int min = 1;
        int max = 100;
        boolean startingGame = true;
        boolean playGame = false;

        try {
            playGame = askToPlay(startingGame, sc);

        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }


        while (playGame) {
            int randomNumber = getRandomNumber(min, max);
            playGame = gameLogic(randomNumber, sc);
        }
    }

    public static int getRandomNumber(int min, int max) {
        Random rd = new Random();
        return rd.nextInt((max - min) + 1) + min;
    }

    public static boolean askToPlay(boolean startingGame, Scanner sc) throws Exception {

        if (startingGame) {
            startingGame = false;
            System.out.println("Bonjour souhaitez vous jouer à mon jeu O/N ?");
            char userInput = sc.next().charAt(0);

            if (userInput != 'O' && userInput != 'o' && userInput != 'N' && userInput != 'n') {
                throw new Exception("Enter a valid value !");
            }

            if (userInput == 'O' || userInput == 'o') {
                return true;
            } else {
                System.out.println("Vous ne savez pas ce que vous ratez !!!");
                return false;
            }

        } else {
            System.out.println("Voulez vous rejouer ? O/N");
            char userChoice = sc.next().charAt(0);
            if (userChoice == 'O' || userChoice == 'o') {
                return true;
            } else {
                System.out.println("Vous ne savez pas ce que vous ratez !!!");
                return false;
            }
        }
    }

    public static boolean gameLogic(int randomNumber, Scanner sc) {
        int counter = 1;
        System.out.println("Saisissez une valeur comprise entre 1 et 100 ");
        int userNumberInput = 0;
        while (userNumberInput != randomNumber) {
            userNumberInput = sc.nextInt();
            if (userNumberInput > randomNumber) {
                System.out.println("Saisissez une valeur plus petite");
            } else if (userNumberInput < randomNumber) {
                System.out.println("Saisissez une valeur plus grande");
            }
            counter++;
        }
        System.out.println("Vous avez trouvé en " + counter + " coups");

        try {
            return askToPlay(false, sc);

        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return true;
        }
    }*/
    }
}
