import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String url = "D:\\Winfolders\\Documents\\skillbox\\java_basics\\11_FilesAndNetwork\\homework_11.5\\src\\main\\resources\\moscowmetro.html";
        try {
            LinkedHashMap<Integer, String> st = getStation(url);
            System.out.println("sfd");
            JSONObject jsonObject = new JSONObject();
            for (Map.Entry<Line, List<Station>> entry : getLinesWithStations(url).entrySet()) {
                System.out.println(entry.getKey().getName());
                JSONArray stations = new JSONArray();
                for (Station s: entry.getValue()){
                    System.out.println("\t" + s.getName());
                    stations.add(s.getName());
                }
                jsonObject.put(entry.getKey().getName(), stations);
            }
            FileWriter file = new FileWriter("D:\\Winfolders\\Documents\\skillbox\\java_basics\\11_FilesAndNetwork\\homework_11.5\\test.json");
            file.write(jsonObject.toJSONString());
            file.flush();
            file.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
    static LinkedHashMap<Line, List<Station>> getLinesWithStations(String url) throws IOException {
        LinkedHashMap<Line, List<Station>> linesAndStations = new LinkedHashMap<>();
        File file = new File(url);
        Document document = Jsoup.parse(file, "UTF-8", "https://www.moscowmap.ru/metro.html#lines");
        Elements lines = document.select(".js-metro-line");
        for (Element e: lines){
            Line line = new Line(e.text(), e.attr("data-line"));
            Document doc = Jsoup.parse(file, "UTF-8", "https://www.moscowmap.ru/metro.html#lines");
            String cssQuery = "#metrodata > div > div > div[data-line=" + e.attr("data-line") + "] > p > a > span.name";
            Elements stations = doc.select(cssQuery);
            List<Station> stationList = new ArrayList<>();
            for (Element s: stations){
                Station station = new Station(s.text(), line);
                stationList.add(station);
            }
            linesAndStations.put(line, stationList);
        }
        return linesAndStations;
    }

    static LinkedHashMap<Integer, String> getStation (String url) throws IOException {
        LinkedHashMap<Integer, String> stations = new LinkedHashMap<>();
        File file = new File(url);
        Document document = Jsoup.parse(file, "UTF-8", "https://www.moscowmap.ru/metro.html#lines");
        Elements id = document.select("a[data-metrost]");
        List<String> allId = new ArrayList<>();
        for (Element e: id){
            allId.add(e.attr("data-id"));
        }
        Elements name = document.select(".name");
        List<String> allNames= new ArrayList<>();
        for (Element e: name){
            allNames.add(e.text());
        }
        for (int i = 0; i < allId.size(); i++){
            stations.put(Integer.parseInt(allId.get(i)), allNames.get(i));
        }
        return stations;
    }
}
