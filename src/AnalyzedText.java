import java.util.Objects;

public class AnalyzedText implements Comparable{
    private String text;
    private double sentiment;

    public AnalyzedText(String text) {
        this.text = text;
    }
    public String getText() {
        return this.text;
    }
    public Double getSentiment() {
        return this.sentiment;
    }
    @Override
    public int compareTo(Object o) {
        return 0;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnalyzedText)) return false;
        AnalyzedText that = (AnalyzedText) o;
        return Double.compare(that.sentiment, sentiment) == 0 && text.equals(that.text);
    }
    @Override
    public String toString() {
        return "AnalyzedText{" +
                "text='" + text + '\'' +
                ", sentiment=" + sentiment +
                '}';
    }
    @Override
    public int hashCode() {
        return Objects.hash(text, sentiment);
    }
}
