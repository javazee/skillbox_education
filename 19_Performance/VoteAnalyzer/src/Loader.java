import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class Loader {


    public static void main(String[] args) throws Exception {
        String fileName = "res/data-18M.xml";

        long start = System.currentTimeMillis();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SaxHandler handler = new SaxHandler();
        parser.parse(new File(fileName), handler);
        System.out.println("\tСписок недобросовестных избирателей:");
        DBConnection.printVoterCounts();
//        handler.printDishonestVoters();
//        System.out.println("\n\tВремя работы участков:");
//        handler.printVotingWorkTime();

        long end = System.currentTimeMillis() - start;
        System.out.println("Время выполнения программы: " + end + " ms");
    }
}