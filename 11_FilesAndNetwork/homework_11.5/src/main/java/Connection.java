public class Connection {
    Station st1;
    Station st2;

    public Connection (Station st1, Station st2){
        if (!st1.getLine().equals(st2.getLine())) {
            this.st1 = st1;
            this.st2 = st2;
        }
    }
}
