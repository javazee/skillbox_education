public class Station {
    private final String name;
    Line line;
    private int id;

    public Station(String name, Line line) {
        this.name = name;
        this.line = line;
    }

    public Station(Integer id, String name) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

}
