import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) throws IOException {

        String url = "https://skillbox.ru";
        String pathSiteMap = "data/siteMap.txt";

        new File(pathSiteMap).createNewFile();
        Path path = Paths.get(pathSiteMap);
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        String siteMap = forkJoinPool.invoke(new HtmlParser(url));
        System.out.println(siteMap);
        System.out.print("******************************************\n");
        System.out.printf("Количество паралелльных потоков: %d\n", forkJoinPool.getParallelism());
        System.out.printf("Количество украденных задач: %d\n", forkJoinPool.getStealCount());
        System.out.print("******************************************\n");
        Files.writeString(path, siteMap, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
    }
}
