import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.LoggerFactory;

public class Main {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(Main.class);

    public static StringBuilder typedWordChars;
    public static StringBuilder wordChars;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        while (true) {
            Helper helper = new Helper();
            String word = helper.getWord();

            String typedWord;
            int tryCount = 0;

            log.info("Game started");
            System.out.println("Type any word:");

            do {
                typedWord = br.readLine();
                if (typedWord.toString().equals("/?")) {
                    System.out.println(word);
                    continue;
                }

                typedWordChars = new StringBuilder(typedWord);
                wordChars = new StringBuilder(word);
                tryCount++;

                int bullsCount = countBulls();
                int cowsCount = countCows();
                System.out.println("cows: " + cowsCount + ". bulls: " + bullsCount);
            } while (!typedWord.equals(word) && tryCount < 10);

            System.out.println("Word was:");
            System.out.println(word);
            if (tryCount == 10) {
                log.info("game over loser");
                System.out.println("you lose");
            } else {
                log.info("good game dude");
                System.out.println("you wоn");
            }
            System.out.println("press Y for a new game");

            typedWord = br.readLine();
            if (!typedWord.toString().equals("Y")) {
                break;
            }
        }
    }

    public static int countBulls() {
        int bullsCount = 0;

        for (int index = 0; index < typedWordChars.length(); index++) {
            if (index < wordChars.length() && typedWordChars.charAt(index) == wordChars.charAt(index)) {
                bullsCount++;
                typedWordChars.deleteCharAt(index);
                wordChars.deleteCharAt(index);
                index--;
            }
        }

        return bullsCount;
    }

    public static int countCows() {
        int cowsCount = 0;
        for (int index = 0; index < typedWordChars.length(); index++) {
            for (int wordCharIndex = 0; wordCharIndex < wordChars.length(); wordCharIndex++) {
                if (typedWordChars.charAt(index) == wordChars.charAt(wordCharIndex)) {
                    cowsCount++;
                    typedWordChars.deleteCharAt(index);
                    wordChars.deleteCharAt(wordCharIndex);
                    index--;
                    break;
                }
            }
        }

        return cowsCount;
    }
}
