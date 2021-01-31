public class Main {

  public static void main(String[] args) {
    System.out.println(splitTextIntoWords("On the first Wednesday in January, America saw an insurrection.\n" +
            " The second, an impeachment. The third, an inauguration. And on the fourth Wednesday in January, everyone got real fired up about\n" +
            " a video game retailer’s stock price.\n" +
            "\n" +
            "When the market closed on Wednesday, GameStop — a beleaguered chain of video game stores with more than 5,000 locations worldwide\n" +
            "  — was trading on the New York Stock Exchange at $347.51 a share, up 135 percent for the day. n" +
            "That made GameStop stock more valuable per share than Apple, ExxonMobil, or Facebook.\n" +
            " The ride on Thursday was even wilder, as the stock whipsawed between massive gains and major losses.\n" +
            "\n" +
            "It’s a wild financial story, but at some point it became more than that,\n" +
            "jumping news genres like a cross-over country hit and becoming a national fixation.\n" +
            " In an age of pandemics, impeachments, insurrections and new presidents,\n" +
            " the hottest topic in news was… investing in a video game store most commonly found flanked by the Gap and Sunglass Hut."));
  }
  public static String splitTextIntoWords(String text) {
    //TODO реализуйте метод
    String outputText = text.replaceAll("[^a-z’A-Z]", " ").replaceAll("\\s+", "\n").trim();
    return outputText;
  }
}