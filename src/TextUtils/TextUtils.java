package TextUtils;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class TextUtils {
    public static AtomicInteger counter_length3 = new AtomicInteger();
    public static AtomicInteger counter_length4 = new AtomicInteger();
    public static AtomicInteger counter_length5 = new AtomicInteger();

    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }
    public static boolean isPalindrome(String text) {
        return text.equals(new StringBuilder(text).reverse().toString());
    }

    public static boolean  isSameLetters(String text) {
        for (int i=0;i<text.length()-1;i++) {
            if (text.charAt(i) != text.charAt(i + 1)) {
                return false;
            }
        }
            return true;
        }
        public static boolean isLettersAscending(String text) {
            for (int i = 0; i < text.length() - 1; i++) {
                if (text.charAt(i) > text.charAt(i + 1)) {
                    return false;
                }
            }
            return true;
        }
            public static void incrementCounter(int textLength) {
                if (textLength == 3) {
                    counter_length3.getAndIncrement();
                } else if ((textLength == 4)) {
                    counter_length4.getAndIncrement();
                } else if ((textLength == 5)) {
                    counter_length5.getAndIncrement();
                }
            }
    }



