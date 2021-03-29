import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "https://lenta.ru/";
        String outputPath = "D:\\Winfolders\\Desktop\\img";
        try {
            loadImage(url, outputPath);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    static void loadImage(String url, String outPath) throws IOException {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.select("img");
            List<String> urlList = new ArrayList<>();
            elements.forEach(img -> urlList.add(img.attr("abs:src")));
            for (int i = 0; i < urlList.size(); i++) {
                BufferedImage img = ImageIO.read(new URL(urlList.get(i)));
                File file = new File(outPath, "image" + i + ".png");
                ImageIO.write(img, "png", file);
                System.out.println(urlList.get(i));
            }

    }
}

