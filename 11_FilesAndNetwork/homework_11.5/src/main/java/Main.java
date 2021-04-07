import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String url = "https://www.moscowmap.ru/metro.html#lines";
        try {
            FileWriter file = new FileWriter("src/main/resources/MoscowMetroMap.json");
            JSONObject jsonObject = new JSONObject();
            Document moscowMetro = getDocument(url);
            jsonObject.put("stations", getStationsFromHTML(moscowMetro));
            jsonObject.put("connections", getConnectionsFromHTML(moscowMetro));
            file.write(jsonObject.toJSONString());
            file.flush();
            file.close();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    static Document getDocument (String url) throws IOException {
        return Jsoup.connect(url).get();
    }

    static LinkedHashMap<Line, List<Station>> getLinesWithStations(Document document){
        LinkedHashMap<Line, List<Station>> linesAndStations = new LinkedHashMap<>();
        Elements lines = document.select(".js-metro-line");
        for (Element e: lines){
            Line line = new Line(e.text(), e.attr("data-line"));
            String cssQuery = "#metrodata > div > div > div[data-line=" + e.attr("data-line") + "] > p > a > span.name";
            Elements stations = document.select(cssQuery);
            List<Station> stationList = new ArrayList<>();
            for (Element s: stations){
                Station station = new Station(s.text(), line);
                stationList.add(station);
            }
            linesAndStations.put(line, stationList);
        }
        return linesAndStations;
    }

    static List<List<List<Connection>>> getConnections (Document document) throws IOException {
        List<List<List<Connection>>> allConnections = new ArrayList<>();
        List<List<Connection>> connections = new ArrayList();
        for (Line line: getLines(document)){
            Elements elements = document.select("div[data-line=" + line.getNumber() + "] > p:has(.t-icon-metroln)");
            for (Element el: elements){
                List <Connection> connectedStation = new ArrayList<>();
                Elements connection =el.select(".t-icon-metroln");
                if (!connection.isEmpty()) {
                    connectedStation.add(new Connection(line.getNumber(), el.getElementsByClass("name").text()));
                }
                for (Element e: connection){
                    Pattern patternNumber = Pattern.compile("(?<=ln-).+(?=\")?");
                    Pattern patternName = Pattern.compile("((?<=.«).+(?=»))");
                    Matcher number = patternNumber.matcher(e.attr("class"));
                    Matcher name = patternName.matcher(e.attr("title"));
                    if (number.find() && name.find()) {
                        connectedStation.add(new Connection(number.group(), name.group()));
                    }
                }
                connectedStation.sort(Comparator.comparing(Connection::getLine));
                connections.add(connectedStation);
            }
        }
        allConnections.add(connections);
        return allConnections;
    }

    static List<Line> getLines (Document document) throws IOException {
        List<Line> lines = new ArrayList<>();
        Elements elements = document.select(".js-metro-line");
        for (Element e: elements){
            Line line = new Line(e.text(), e.attr("data-line"));
            lines.add(line);
        }
        return lines;
    }

    static JSONArray getStationsFromHTML (Document document) throws IOException {
        JSONArray stations = new JSONArray();
        JSONObject station = new JSONObject();
        for (Map.Entry<Line, List<Station>> entry : getLinesWithStations(document).entrySet()) {
            JSONArray stationsList = new JSONArray();
            for (Station s: entry.getValue()){
                stationsList.add(s.getName());
            }
            station.put(entry.getKey().getName(), stationsList);
        }
        stations.add(station);
        return stations;
    }

    static JSONArray getConnectionsFromHTML (Document document) throws IOException{
        JSONArray connections = new JSONArray();
        for (List<List<Connection>> listOfConnectedStations : getConnections(document)){
            for (List<Connection> connectedStations: listOfConnectedStations){
                JSONArray connectedStation = new JSONArray();
                for(Connection c: connectedStations) {
                    JSONObject station = new JSONObject();
                    station.put("line", c.getLine());
                    station.put("station", c.getStation());
                    connectedStation.add(station);
                }
                if (!connections.contains(connectedStation)) {
                    connections.add(connectedStation);
                }
            }
        }
        return connections;
    }
}
