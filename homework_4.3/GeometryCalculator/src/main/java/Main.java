public class Main {
    public static void main(String[] args) {
        double radius = -1; //радиус окружности или сферы
        double a = 9; //сторона треугольника
        double b = 5; //сторона треугольника
        double c = 5; //сторона треугольника
        System.out.println("Площадь окружности: " + GeometryCalculator.getCircleSquare(radius));
        System.out.println("Объем сферы: " + GeometryCalculator.getSphereVolume(radius));
        if (GeometryCalculator.isTrianglePossible(a, b, c)) {
            System.out.println("Площадь треугольника: " + GeometryCalculator.getTriangleSquare(a, b, c));
        }
    }
}
