import java.io.*;
import java.util.*;

public class Main {
    private static int minimumPrice = Integer.MAX_VALUE;
    private static int bookCount;
    private static Book[] books;
    private static int[] targetAlphabets;
    private static int[] selectedAlphabets;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String targetWord = reader.readLine();
        bookCount = Integer.parseInt(reader.readLine());
        
        books = new Book[bookCount];
        targetAlphabets = new int[26];
        selectedAlphabets = new int[26];

        for (char alphabet : targetWord.toCharArray()) {
            targetAlphabets[alphabet - 'A']++;
        }

        for (int i = 0; i < bookCount; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int price = Integer.parseInt(tokenizer.nextToken());
            String bookTitle = tokenizer.nextToken();
            books[i] = new Book(price, bookTitle);
        }

        findMinimumPriceBooks(0, 0);
        System.out.println(minimumPrice == Integer.MAX_VALUE ? -1 : minimumPrice);
    }

    private static void findMinimumPriceBooks(int currentBookIndex, int currentTotalPrice) {
        if (currentBookIndex == bookCount) {
            if (canFormTargetWord()) {
                minimumPrice = Math.min(minimumPrice, currentTotalPrice);
            }
            return;
        }

        Book currentBook = books[currentBookIndex];

        for (char alphabet : currentBook.title.toCharArray()) {
            selectedAlphabets[alphabet - 'A']++;
        }
        findMinimumPriceBooks(currentBookIndex + 1, currentTotalPrice + currentBook.price);

        for (char alphabet : currentBook.title.toCharArray()) {
            selectedAlphabets[alphabet - 'A']--;
        }
        findMinimumPriceBooks(currentBookIndex + 1, currentTotalPrice);
    }

    private static boolean canFormTargetWord() {
        for (int i = 0; i < 26; i++) {
            if (targetAlphabets[i] > selectedAlphabets[i]) {
                return false;
            }
        }
        return true;
    }

    private static class Book {
        int price;
        String title;

        Book(int price, String title) {
            this.price = price;
            this.title = title;
        }
    }
}