import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

public class HtmlParser extends RecursiveTask<String> {
    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (HTML, like Gecko) Chrome/33.0.1750.154 Safari/537.36";
    private static final Set<String> bufferUrl = new CopyOnWriteArraySet<>();
    private final String startUrl;

    public HtmlParser(String startUrl) {
        this.startUrl = startUrl;
    }

    @Override
    protected String compute() {
        StringBuilder sb = new StringBuilder(createTab(startUrl) + startUrl + "\n");
        List<HtmlParser> allTasks = new CopyOnWriteArrayList<>();
        try {
            Thread.sleep(300);
            Elements elements = Jsoup.connect(startUrl).ignoreContentType(true).userAgent(USER_AGENT).get().select("a[href]");
            for (Element element : elements) {
                String url = element.absUrl("href");
                if (!url.isEmpty() && url.startsWith(startUrl) && !bufferUrl.contains(url) && !url
                        .contains("#")) {
                    HtmlParser htmlParser = new HtmlParser(url);
                    htmlParser.fork();
                    allTasks.add(htmlParser);
                    bufferUrl.add(url);
                }
            }
        } catch (InterruptedException | IOException e) {
            Thread.currentThread().interrupt();
        }
        allTasks.sort(Comparator.comparing(o -> o.startUrl));
        for (HtmlParser link : allTasks) sb.append(link.join());
        return sb.toString();
    }

    private String createTab (String startUrl) {
        return StringUtils.repeat("\t",
                startUrl.lastIndexOf("/") == startUrl.length() - 1 ? StringUtils.countMatches(startUrl, "/") - 3
                        : StringUtils.countMatches(startUrl, "/") - 2);
    }
}
