/**
 * @author Mohamed Yousef
 */
public class Velocity {
    private double dx, dy, speed;
    /**
     * @param dx - the change of x coordinate
     * @param dy - the change of y coordinate
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    /**
     * @param speed1 speed of the ball
     */
    public void setSpeed(double speed1) {
        this.speed = speed1;
    }
    /**
     * @return the speed of the ball
     */
    public double getSpeed() {
        return this.speed;
    }
    /**
     * @return the dx
     */
    public double getDx() {
        return this.dx;
    }
    /**
     * @return the dy
     */
    public double getDy() {
        return this.dy;
    }
    /**
     * @param angle the angle where the ball heading
     * @param speed the speed of the ball
     * @return velocity according to dx and dy
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = speed * Math.sin(Math.toRadians(angle));
        double dy = -speed * Math.cos(Math.toRadians(angle));
        return new Velocity(dx, dy);
    }
    /**
     * @param d the dx
     */
    public void setDx(double d) {
        this.dx = d;
    }
    /**
     * @param d the dy
     */
    public void setDy(double d) {
        this.dy = d;
    }
    /**
     * @param p current ball's center
     * @return the next center of the ball
     */
    public Point applyToPoint(Point p) {
        double x2, y2;
        x2 = p.getX() + dx;
        y2 = p.getY() + dy;
        Point p2 = new Point(x2, y2);
        return p2;
    }
}
