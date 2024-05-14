package TextUtils;

import java.util.Random;

import static TextUtils.TextUtils.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }
        Thread sameLettersThread = new Thread(() -> {
            for (String text : texts) {
                if (isSameLetters(text)) {
                    incrementCounter(text.length());
                }
            }
        });
        sameLettersThread.start();

        Thread lettersAscendingThread = new Thread(() -> {
            for (String text : texts) {
                if (isLettersAscending(text) && !isSameLetters(text)) {
                    incrementCounter(text.length());
                }
            }
        });
        lettersAscendingThread.start();

        Thread palindromeThread = new Thread(() -> {
            for (String text : texts) {
                if (isPalindrome(text) && !isSameLetters(text)) {
                    incrementCounter(text.length());
                }
            }
        });
        palindromeThread.start();

        sameLettersThread.join();
        lettersAscendingThread.join();
        palindromeThread.join();

        System.out.println();
        System.out.println("Красивых слов с длиной 3: " + counter_length3 + " шт");
        System.out.println("Красивых слов с длиной 4: " + counter_length4 + " шт");
        System.out.println("Красивых слов с длиной 5: " + counter_length5 + " шт");
    }
}
