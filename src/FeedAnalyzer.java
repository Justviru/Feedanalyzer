import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FeedAnalyzer {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Justin\\OneDrive - tgm - Die Schule der Technik\\Desktop\\Schule\\SEW\\feed-analyser\\Resource\\potus_tweets_2017_webarchive_publicaccess.csv";
        Map<String, String> analyzedMessages = new HashMap<>();
        double totalSentimentScore = 0.0;
        int messageCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                double sentimentScore = Utility.analyseText(line);
                totalSentimentScore += sentimentScore;
                messageCount++;
                analyzedMessages.put(line, "Potus");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        double averageSentimentScore = messageCount > 0 ? totalSentimentScore / messageCount : 0.0;

        System.out.println("Total Sentiment Score: " + totalSentimentScore);
        System.out.println("Average Sentiment Score: " + averageSentimentScore);
    }
}