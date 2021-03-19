import core.Line;
import core.Station;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    List<Station> route;
    RouteCalculator calculator;
    StationIndex stationIndex;
    Line line1;
    Line line2;
    Line line3;
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
    List<Station> connections12;
    List<Station> connections23;

    @Override
    protected void setUp() throws Exception {
        route = new ArrayList<>();
        line1 = new Line(1, "Первая");
        line2 = new Line(2, "Вторая");
        line3 = new Line(3, "Третья");
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
        station31 = new Station("Театральная", line3);
        route.add(station31);
        station32 = new Station("Верх-исетская", line3);
        route.add(station32);
        station33 = new Station("Политехническая", line3);
        route.add(station33);
        stationIndex = new StationIndex();
        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);
        line1.addStation(station11);
        line1.addStation(station12);
        line1.addStation(station13);
        line1.addStation(station14);
        line2.addStation(station21);
        line2.addStation(station22);
        line2.addStation(station23);
        line2.addStation(station24);
        line3.addStation(station31);
        line3.addStation(station32);
        line3.addStation(station33);
        stationIndex.addStation(station11);
        stationIndex.addStation(station12);
        stationIndex.addStation(station13);
        stationIndex.addStation(station14);
        stationIndex.addStation(station21);
        stationIndex.addStation(station22);
        stationIndex.addStation(station23);
        stationIndex.addStation(station24);
        stationIndex.addStation(station31);
        stationIndex.addStation(station32);
        stationIndex.addStation(station33);
        connections12 = new ArrayList<>();
        connections23 = new ArrayList<>();
        connections12.add(station13);
        connections12.add(station23);
        connections23.add(station22);
        connections23.add(station32);
        stationIndex.addConnection(connections12);
        stationIndex.addConnection(connections23);
        calculator = new RouteCalculator(stationIndex);
    }

    @Test
    @DisplayName("Передана карта состоящая из 11 станций, 2 из них станции для пересадки")
    public void testCalculateDuration(){
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 27;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Передан маршрут без пересадок")
    public void testGetShortestRouteOnTheLine(){
        List<Station> actual =  calculator.getShortestRoute(station11, station14);
        List<Station> expected = new ArrayList<>();
        expected.add(station11);
        expected.add(station12);
        expected.add(station13);
        expected.add(station14);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Передан маршрут с одной пересадкой")
    public void testGetShortestRouteWithOneConnection(){
        List<Station> actual =  calculator.getShortestRoute(station11, station21);
        List<Station> expected = new ArrayList<>();
        expected.add(station11);
        expected.add(station12);
        expected.add(station13);
        expected.add(station23);
        expected.add(station22);
        expected.add(station21);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Передан маршрут с двумя пересадками")
    public void testGetShortestRouteWithTwoConnection(){
        List<Station> actual =  calculator.getShortestRoute(station11, station33);
        List<Station> expected = new ArrayList<>();
        expected.add(station11);
        expected.add(station12);
        expected.add(station13);
        expected.add(station23);
        expected.add(station22);
        expected.add(station32);
        expected.add(station33);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Передан маршрут из одной станции")
    public void testGetShortestRouteWithOnlyOneStation(){
        List<Station> actual =  calculator.getShortestRoute(station24, station24);
        List<Station> expected = new ArrayList<>();
        expected.add(station24);
        assertEquals(expected, actual);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
