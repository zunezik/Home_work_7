public class Vector {
    Point point1;
    Point point2;

    public Vector(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public void printVectorCoordinates(){
        double vx = point2.x - point1.x;
        double vy = point2.y - point1.y;
        System.out.println("Vector coordinates: " + vx + ";" + vy);
    }
}
