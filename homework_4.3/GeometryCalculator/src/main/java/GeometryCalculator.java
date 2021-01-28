public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        return Math.PI * Math.pow(Math.abs(radius), 2);
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        return (4 * Math.PI * Math.pow(Math.abs(radius), 3)) / 3;
    }

    public static boolean isTrianglePossible(double a, double b, double c) {
        double maxSide = Math.max(Math.max(a, b), c);
        double minSide = Math.min(Math.min(a, b), c);
        double middleSide = a + b + c - maxSide - minSide;
        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("Треугольник невозможен");
            return false;
        } else if (maxSide > middleSide + minSide){
            System.out.println("Треугольник невозможен");
            return false;
        } else {
            return true;
        }
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        if (isTrianglePossible(a, b, c)) {
            double p = (a + b + c) / 2;
            double triangleSquare = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            return triangleSquare;
        } else {
            return -1;
        }
    }
}
