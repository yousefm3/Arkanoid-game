/**
 * @author Mohamed Yousef
 */
public class Line {
    private Point start, end;
    /**
     * @param x1 -coordinate x of start point
     * @param y1 -coordinate y of start point
     * @param x2 -coordinate x of end point
     * @param y2 -coordinate y of end point
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }
    /**
     * @param a the start point of thee line
     * @param b the end point of the line
     */
    public Line(Point a, Point b) {
        this.start = a;
        this.end = b;
    }
    /**
     * @return - the length of the line
     */
    public double length() {
        return start.distance(end);
    }
    /**
     * @return the middle point in the line
     */
    public Point middle() {
        double x, y;
          y = (this.start.getY() + this.end.getY()) / 2;
          x = (this.start.getX() + this.end.getX()) / 2;
         Point midPoint = new Point(x, y);
        return midPoint;
    }
    /**
     * @return the start point of the line
     */
    public Point start() {
        return start;
    }

    /**
     * @return the end point of the line
     */
    public Point end() {
        return end;
    }


    /**
     * @param other - the other line to check with
     * @return  Returns true if the lines intersect, false otherwise
     */
    public boolean isIntersecting(Line other) {
        if (intersectionWith(other) == null) {
            return false;
        }
        return true;
    }

    /**
     * @param other - the other line to check with
     * @return the intersection point if the lines intersect,null otherwise
     */
    public Point intersectionWith(Line other) {
            //we make for each line a function y=ax+b
            //a is the slope of the line,b is the y-intercept
            //a1 b1 for our line
            //a2 b2 for the other line
            double a1, a2, b1, b2, x, y, c = 0;
            //slope is delta y/delta x
        if ((this.start.getX() - this.end.getX() == 0)) {
            a1 = 0;
            c = 1;
        } else {
            a1 = (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
        }
        if ((other.start.getX() - other.end.getX() == 0)) {
            a2 = 0;
            c = 2;
        } else {
            a2 = (other.start.getY() - other.end.getY()) / (other.start.getX() - other.end.getX());
        }

            //b is y-ax
            b1 = this.start.getY() - (a1 * this.start.getX());
            b2 = other.start.getY() - (a2 * other.start.getX());
            //in case they have the same slope
            if (a1 == a2) {
               return null;
            }
            if (c == 1) {
                x = this.start.getX();
                y = (x * a2) + b2;
            } else if (c == 2) {
                x = other.start.getX();
                y = (x * a1) + b1;
            } else {
                x = (b2 - b1) / (a1 - a2);
                y = (x * a2) + b2;
            }
            //checking if the intersecting point is in both of lines
            if (x <= Math.max(this.end.getX(), this.start.getX())
                    && x >= Math.min(this.end.getX(), this.start.getX())
                   && y <= Math.max(this.end.getY(), this.start.getY())
                   && y >= Math.min(this.end.getY(), this.start.getY())
                   && x <= Math.max(other.end.getX(), other.start.getX())
                   && x >= Math.min(other.end.getX(), other.start.getX())
                   && y <= Math.max(other.end.getY(), other.start.getY())
                   && y >= Math.min(other.end.getY(), other.start.getY())) {
                Point intersectPoint = new Point(x, y);
                return intersectPoint;
            }
            return null;
    }
    /**
     * @param rect the rectangle that we are checking with
     * @return If this line does not intersect with the rectangle, return null.
     *        Otherwise, return the closest intersection point to the
     *        start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        Line l1 = new Line(this.start, this.end);
        // in case there is no intersection point
        if (rect.intersectionPoints(l1).isEmpty()) {
            return null;
        }
        // in case there is only 1
        if (rect.intersectionPoints(l1).size() == 1)  {
              return rect.intersectionPoints(l1).get(0);
        }
        // in case there is 2 we check the closer one
        if (this.start.distance(rect.intersectionPoints(l1).get(0))
                < this.start.distance(rect.intersectionPoints(l1).get(1))) {
            return rect.intersectionPoints(l1).get(0);
        }
        return rect.intersectionPoints(l1).get(1);
    }
}
