import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class Loader {


    public static void main(String[] args) throws Exception {
        String fileName = "res/data-1M.xml";

        long start = System.currentTimeMillis();

        long usageMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SaxHandler handler = new SaxHandler();
        parser.parse(new File(fileName), handler);
        System.out.println("\tСписок недобросовестных избирателей:");
        handler.printDishonestVoters();
        System.out.println("\n\tВремя работы участков:");
        handler.printVotingWorkTime();

        usageMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory() - usageMemory;
        System.out.println("\n\tИспользуемая память: " + usageMemory);

        long end = System.currentTimeMillis() - start;
        System.out.println("Время выполнения программы: " + end + " ms");
    }
}