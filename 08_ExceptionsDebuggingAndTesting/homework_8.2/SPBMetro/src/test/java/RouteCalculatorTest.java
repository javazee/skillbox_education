import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    List<Station> route;
    RouteCalculator calculator;
    Station station11;
    Station station12;
    Station station13;
    Station station14;
    Station station21;
    Station station22;
    Station station23;
    Station station24;
    Station station31;
    Station station32;
    Station station33;

    @Override
    protected void setUp() throws Exception {
        route = new ArrayList<>();
        Line line1 = new Line(1, "Первая");
        Line line2 = new Line(2, "Вторая");
        station11 = new Station("Ботаническая", line1);
        route.add(station11);
        station12 = new Station("Чкаловская", line1);
        route.add(station12);
        station13 = new Station("Площадь 1905 года", line1);
        route.add(station13);
        station14 = new Station("Динамо", line1);
        route.add(station14);
        station21 = new Station("Западная", line2);
        route.add(station21);
        station22 = new Station("Верх-исетская", line2);
        route.add(station22);
        station23 = new Station("Площадь 1905 года", line2);
        route.add(station23);
        station24 = new Station("Металлургическая", line2);
        route.add(station24);
        station31 = new Station("Театральная", line2);
        route.add(station31);
        station32 = new Station("Верх-исетская", line2);
        route.add(station32);
        station33 = new Station("Политехническая", line2);
        route.add(station33);
    }
    public void testCalculateDuration(){
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 11;
        assertEquals(actual, expected);
    }
    public void testGetShortestRoute(){
        calculator = new RouteCalculator(new StationIndex());
        List<Station> actual =  calculator.getShortestRoute(station11, station14);
        List<Station> expected = route;
        assertEquals(actual, expected);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
