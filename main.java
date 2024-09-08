import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class main {

    public static int wordBreak(String s, Set<String> dictionary) {
        if (s.isEmpty()) {
            return 1;
        }
        
        for (String word : dictionary) {
            if (s.startsWith(word)) {
                String remainingString = s.substring(word.length());
                if (wordBreak(remainingString, dictionary) == 1) {
                    return 1;
                }
            }
        }
        
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of words in the dictionary:");
        int n = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        Set<String> dictionary = new HashSet<>();
        System.out.println("Enter the words in the dictionary:");
        for (int i = 0; i < n; i++) {
            dictionary.add(scanner.nextLine());
        }

        System.out.println("Enter the string to be segmented:");
        String s = scanner.nextLine();

        System.out.println(wordBreak(s, dictionary));  // Output: 1 if segmentable, else 0
    }
}
