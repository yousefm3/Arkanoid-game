/**
 * @author Mohamed Yousef
 */
public class Point {
    private double x, y;
    /**
     * @param x coordinate x of our point
     * @param y coordinate y of our point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }


    /**
     * @param other - the other point to calcuate distance
     * @return - the distance between our point and other point
     */
    public double distance(Point other) {
        double distance = Math.sqrt(((other.x - this.x) * (other.x - this.x))
                + ((other.y - this.y) * (other.y - this.y)));
        return distance;
    }
    /**
     * @param other - the other point
     * @return - true if we have the same point,false otherwise
     */
    public boolean equals(Point other) {
        if (this.x == other.x && this.y == other.y) {
            return true;
        }
        return false;
    }
    /**
     * @return - our x coordinate
     */
    public double getX() {
        return this.x;
    }
    /**
     * @return - our y coordinate
     */
    public double getY() {
        return this.y;
    }
}
