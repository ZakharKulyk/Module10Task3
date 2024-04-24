import UtilsForTask.Reader.GetText;
import UtilsForTask.Reader.ReadingFile;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class WordCounter {
    public static void main(String[] args) {
        File file = new File("words.txt");
        ArrayList<String> text = new ArrayList<>();
        ReadingFile read = new GetText(file);
        text = read.getText();
        calculateWords(text);

    }

    public static void calculateWords(ArrayList<String> data) {
        HashMap<String, Integer> wordCounterMap = new HashMap<>();
        for (String line : data) {
            String words[] = line.split(" ");
            for (String word : words) {
                if (!word.isEmpty()) {
                    wordCounterMap.put(word, wordCounterMap.getOrDefault(word, 0) + 1);
                }
            }
        }
        wordCounterMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(System.out::println);
    }

}