import java.util.*;

public class hangman {

    public static void main(String[] args) {


        //=============== GAME SETTINGS =================

        boolean giveword = true; //give word at program start
        int livesleft = 10; //lives (-1 per guess)

        //===============================================

        FileIO reader = new FileIO();
        Scanner scan = new Scanner(System.in);

        String[] inputs = reader.load("C:\\Users\\lambe\\OneDrive\\Documents\\College\\Year2S2\\CS211\\Workspace\\Lab6Game\\dictionary.txt");    //Reading the File as a String array

        int num = getRandomNumberInRange(0, inputs.length); //random num
        String iword = inputs[num]; //generate word
        String word = iword.substring(0, iword.length()-1); //get rid of extra whitespace at end

        ArrayList<Character> xlist = new ArrayList<Character>(); //generate arraylist "xxxxxx.." of same length of word. Used later.
        for(int i=0; i<word.length(); i++){
            xlist.add('-');
        }

        if (giveword == true) {
            System.out.println(word);
        }
        boolean wordGuessed = false; //boolean for if word guessed
        System.out.println("Welcome to hangman. Your word has " + (word.length() - 1) + " letters.");

        while (wordGuessed == false && livesleft > 0) {

            System.out.println(xlist);
            System.out.println("You have " + livesleft + " lives. Enter a character or a word as a guess: ");
            String guess = scan.next();

            if (guess.length() == 1) {
                char ltr = guess.charAt(0);
                boolean ltrfound = false;

                for (int i = 0; i < word.length(); i++) { //run char through word to see if matches
                    if (ltr == word.charAt(i)) {
                        if(i==0) {
                            System.out.println("Congratulations, you guessed the " + (i+1) + "st Character");
                        }
                        else System.out.println("Congratulations, you guessed the " + (i+1) + "th Character");
                        ltrfound = true;
                        xlist.set(i, ltr);
                    }
//                    else{
//                        System.out.println("Letter does not match the "+i+"th Character");
//                    }
                }
                if (ltrfound == false) {
                    livesleft--;
                }
                System.out.println("=======================================");
            } else if (guess.length() > 1) {

                if (word.equals(guess)) {
                    System.out.println("Congratulations, You guessed the word!");
                    System.exit(0);
                } else {
                    System.out.println("You guessed the word incorrectly, Try again.");
                    livesleft--;
                }
            }
        }
        if (livesleft == 0) {
            System.out.println("Out of lives, Game over!");
            System.out.println("Your word was: "+word);
            System.exit(0);
        }
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
