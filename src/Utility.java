import java.io.*;
import java.util.*;

public class Utility {
    public static double analyseText(String text) {
        Set<String> stopWords = new HashSet<>();
        Map<String, Double> sentimentMap = new HashMap<>();

        File stoplistFile = new File("C:\\Users\\Justin\\OneDrive - tgm - Die Schule der Technik\\Desktop\\Schule\\SEW\\feed-analyser\\Resource", "SmartStoplist.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(stoplistFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                stopWords.add(line.trim().toLowerCase());
            }
        } catch (IOException e) {
            System.err.println("Error reading SmartStoplist.txt: " + e.getMessage());
        }

        File vaderLexiconFile = new File("C:\\Users\\Justin\\OneDrive - tgm - Die Schule der Technik\\Desktop\\Schule\\SEW\\feed-analyser\\Resource", "vader_lexicon.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(vaderLexiconFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length >= 2) {
                    String word = parts[0].trim().toLowerCase();
                    double score = Double.parseDouble(parts[1].trim());
                    sentimentMap.put(word, score);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading vader_lexicon.txt: " + e.getMessage());
        }

        double totalSentimentScore = 0.0;
        String[] words = text.toLowerCase().split("\\s+");
        for (String word : words) {
            if (!stopWords.contains(word) && sentimentMap.containsKey(word)) {
                totalSentimentScore += sentimentMap.get(word);
            }
        }

        return totalSentimentScore;
    }
}
