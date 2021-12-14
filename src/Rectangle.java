/**
 * @author Mohamed Yousef
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Rectangle class.
 */
public class Rectangle {
    private Point upperLeftPoint;
    private double width;
    private double height;
    /**
     * Create a new rectangle with location and width/height.
     * @param height1 the hight of the rectangle
     * @param width1 the width of the rectangle
     * @param  upperLeft the upper left point of the rectangle
      */
    public Rectangle(Point upperLeft, double width1, double height1) {
        this.upperLeftPoint = upperLeft;
        this.width = width1;
        this.height = height1;
    }
    /**
     * @param line to check if it intersect with the rectangle
     * @return Return a (possibly empty) List of intersection points
     * with the specified line.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> intersectionPoints = new ArrayList<Point>();
        Line leftLine, rightLine, upperLine, lowerLine;
        // each point represents one of the rectangle points
        Point lowerLeftPoint = new Point(this.upperLeftPoint.getX(), this.upperLeftPoint.getY() + this.height);
        Point upperRightPoint = new Point(this.upperLeftPoint.getX() + this.width, this.upperLeftPoint.getY());
        Point lowerRightPoint = new Point(this.upperLeftPoint.getX()
                + this.width, this.upperLeftPoint.getY() + this.height);
        leftLine = new Line(this.upperLeftPoint, lowerLeftPoint);
        rightLine = new Line(lowerRightPoint, upperRightPoint);
        upperLine = new Line(upperRightPoint, this.upperLeftPoint);
        lowerLine = new Line(lowerRightPoint, lowerLeftPoint);
        //checking the intersections with the rectangle's ribs
        //with the left rib
        if (line.isIntersecting(leftLine)) {
            Point point = line.intersectionWith(leftLine);
            intersectionPoints.add(point);
        }
        // with the right rib
        if (line.isIntersecting(rightLine)) {
            Point point = line.intersectionWith(rightLine);
            intersectionPoints.add(point);

        }
        // with the lower rib
        if (line.isIntersecting(lowerLine)) {
            Point point = line.intersectionWith(lowerLine);
            intersectionPoints.add(point);

        }
        // with the upper rib
        if (line.isIntersecting(upperLine)) {
            Point point = line.intersectionWith(upperLine);
            intersectionPoints.add(point);

        }
        return intersectionPoints;
    }

    /**
     * @return  the width of the rectangle.
      */
    public double getWidth() {
        return this.width;
    }

    /**
     * @return the height of the rectangle
     */
    public double getHeight() {
        return  this.height;
    }

    /**
     * @return  the upper-left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeftPoint;
    }
}
