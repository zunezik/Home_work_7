import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x: ");
        double x = scanner.nextDouble();
        System.out.print("Enter y: ");
        double y = scanner.nextDouble();

        System.out.print("Enter x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = scanner.nextDouble();

        Point point1 = new Point(x,y);
        Point point2 = new Point(x2,y2);
        Vector vector = new Vector(point1, point2);
        vector.calcVectorCoordinates();
        vector.printVectorCoordinates();
    }
}
