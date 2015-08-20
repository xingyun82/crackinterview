package common;

/**
 * Created by xingyun on 15/6/21.
 */
public class Point {
    public int x;
    public int y;
    public Point() { x = 0; y = 0; }
    public Point(int a, int b) { x = a; y = b; }

    @Override
    public int hashCode() {
        return x*37+y;
    }

    @Override
    public boolean equals(Object p) {
        if(p == null || !(p instanceof Point))return false;
        Point point = (Point)p;
        return point.x == x && point.y == y;
    }
}
