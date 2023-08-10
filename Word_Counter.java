import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Word_Counter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Word Counting App!");


        System.out.print("Enter '1' to input text or '2' to provide a file: ");
        String choice = scanner.nextLine();

        String inputText = "";

        if (choice.equals("1")) {

            System.out.print("Enter your text: ");
            inputText = scanner.nextLine();
        } else if (choice.equals("2")) {

            System.out.print("Enter the file name: ");
            String fileName = scanner.nextLine();
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    inputText += line + " ";
                }
            } catch (IOException e) {
                System.out.println("File not found or error reading the file.");
                System.exit(1);
            }
        } else {
            System.out.println("Invalid choice.");
            System.exit(1);
        }


        String[] words = inputText.split("[\\s,\\.]+");

        // Step 4: Initialize counter
        int wordCount = 0;


        Map<String, Integer> wordFrequency = new HashMap<>();
        Set<String> uniqueWords = new HashSet<>();

        for (String word : words) {
            word = word.toLowerCase();
            if (!word.isEmpty()) {
                wordCount++;
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                uniqueWords.add(word);
            }
        }


        System.out.println("Total number of words: " + wordCount);


        System.out.println("Number of unique words: " + uniqueWords.size());


        System.out.println("Word frequency:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
