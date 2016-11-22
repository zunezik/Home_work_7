public class Vector {
    Point point1;
    Point point2;
    double vx;
    double vy;

    public Vector(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public void calcVectorCoordinates() {
        vx = point2.x - point1.x;
        vy = point2.y - point1.y;
    }

    public void printVectorCoordinates(){
        System.out.println("Vector coordinates: " + vx + ";" + vy);
    }
}
