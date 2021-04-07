public class Station {
    private final String name;
    Line line;

    public Station(String name, Line line) {
        this.name = name;
        this.line = line;
    }

    public String getName() {
        return name;
    }

    public Line getLine() {
        return line;
    }

}
