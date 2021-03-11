import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        findPlanesLeavingInTheNextTwoHours(Airport.getInstance()).forEach(System.out::println);
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        Date currentDate = new Date();
        return airport.getTerminals().stream().
                map(Terminal::getFlights).
                flatMap(Collection::stream).
                filter(x -> x.getDate().getTime() - currentDate.getTime() <= 7200000 && x.getDate().getTime() > currentDate.getTime()).
                filter(t -> t.getType().equals(Flight.Type.DEPARTURE)).
                collect(Collectors.toList());
    }
}