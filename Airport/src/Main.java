import com.skillbox.airport.Airport;
import com.skillbox.airport.Aircraft;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        System.out.println("Список самолетов: " + airport.getAllAircrafts());
        List<Aircraft> totalAircraft = airport.getAllAircrafts();
        System.out.println("Общее количество самолетов: " + totalAircraft.size());

    }
}
