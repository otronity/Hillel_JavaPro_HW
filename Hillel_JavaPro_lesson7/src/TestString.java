import java.util.Random;
import java.util.Scanner;

public class TestString {
    public static void main(String[] args) {
        findSymbolOccurance("hello", 'l');
        findWordPosition("AApollo", "pollo");
        stringReverse("hello");
        isPalindrome("ere");
        isPalindrome("Are");

        guessWord();

    }

    public static void findSymbolOccurance(String s, char c) {
        char chs[] = s.toCharArray();
        int cnt = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == c) cnt++;
        }
        System.out.println("Символ '" + c + "' в рвдку '" + s + "' зустрічається " + cnt + " раз");
    }

    public static void findWordPosition(String source, String target) {
        System.out.print("Позиція підрядка '" + target + "' в рядку '" + source + "' : ");
        if (source.contains(target)) {
            System.out.println(source.indexOf(target));
        } else System.out.println(-1);

    }

    public static void stringReverse(String str) {
        System.out.println("Reverse string " + str + " : " + new StringBuilder(str).reverse().toString());
    }

    public static void isPalindrome(String str) {
        String reversStr = new StringBuilder(str).reverse().toString();
        System.out.println(str + " -> " + str.equals(reversStr));
    }

    public static void guessWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple",
                "pumpkin", "potato"};

        Scanner in = new Scanner(System.in);
        int i = (int) (Math.random() * (words.length + 1));
        String wordRandom = words[i];
        System.out.println(words[i]);
        boolean result = false;
        String str, strCatch;
        int n = 15;
        System.out.println("Спробуйте відгадати слово ");
        while (!result) {
            strCatch = "";
            System.out.println("Введіть слово (exit для виходу): ");
            str = in.next();
            if (str.equals("exit")) {
                System.out.println("Шкода, повертайтеся!");
                break;
            }
            if (!str.equals(wordRandom)) {
                if (str.length() >= wordRandom.length()) {
                    n = wordRandom.length();
                } else {
                    n = str.length();
                }
                for (int ii = 0; ii < n; ii++) {
                    if (str.charAt(ii) == wordRandom.charAt(ii)) {
                        strCatch = strCatch.concat(String.valueOf(str.charAt(ii)));
                    } else strCatch = strCatch.concat("*");
                }
                if (strCatch.length() < 15)
                    strCatch = strCatch.concat("***************".substring(0, 15 - strCatch.length()));
                System.out.println("співпадіння букв у словах " + strCatch);
            }
            if (str.equals(wordRandom)) {
                System.out.println("Вітаю ви відгадали!!!");
                result = true;
            }
        }
    }
}
