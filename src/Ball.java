/**
 * @author Mohamed Yousef
 */
import biuoop.GUI;
import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;

/**
 *Ball class.
 */
public class Ball implements Sprite {
    private  Point center;
    private int radius;
    private  int frameX1, frameX2, frameY1, frameY2;
    private java.awt.Color color;
    private Velocity velocity;
  private GameEnvironment gameEnvironment;
    // constructor
    /**
     * @param center - center of the ball coordinates
     * @param  r - the radius of the ball
     * @param color - the color of the ball
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.radius = r;
        this.color = color;
    }
    /**
     * @param x ball's center x coordinate
     * @param y ball's center y coordinate
     * @param r ball's radius of the ball
     * @param color ball's color
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        Point p = new Point(x, y);
        this.center = p;
        this.radius = r;
        this.color = color;
    }

    /**
     * @return the x coordinate of the ball's center
     */
    public int getX() {
        return (int) this.center.getX();
    }
    /**
     * @return the y coordinate of the ball's center
     */
    public int getY() {
        return (int) this.center.getY();
    }
    /**
     * @return the radius of the ball
     */
    public int getSize() {
        return this.radius;
    }
    /**
     * @return the color of the ball
     */
    public java.awt.Color getColor() {
        return this.color;
    }
    /**
     * @param surface where we draw
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.getColor());
        surface.fillCircle(this.getX(), this.getY(), this.radius);
        surface.setColor(Color.white);
        surface.drawCircle(this.getX(), this.getY(), this.radius);
    }
    /**
     * @param v - v is the velocity
     */
    public void setVelocity(Velocity v) {
     this.velocity = v;
    }

    /**
     * @param x1 the start of x axe
     * @param x2 the end of x axe
     * @param y1 the start of y axe
     * @param y2 the end of y axe
     */
    public void setFrames(int x1, int x2, int y1, int y2) {
        this.frameX1 = x1;
        this.frameX2 = x2;
        this.frameY1 = y1;
        this.frameY2 = y2;
    }

    /**
     * @param g is what this environmet gonna be
     */
   public void  setGameEnvironment(GameEnvironment g) {
        this.gameEnvironment = g;
   }
    /**
     * @return this game environment
     */
   public GameEnvironment getGameEnvironment() {
        return this.gameEnvironment;
   }
    /**
     * @param dx2 the new dx to the velocity
     * @param dy2 the new dy to the velocity
     */
    public void setVelocity(double dx2, double dy2) {
      this.velocity = new Velocity(dx2, dy2);
    }
    /**
     * @return the velocity
     */
    public Velocity getVelocity() {
        return this.velocity;
    }
    /**
     * @return Line.
     */
    public Line trajectory() {
        return new Line(this.center, new Point(this.center.getX() + this.velocity.getDx(),
                        this.center.getY() + this.velocity.getDy()));
    }
    /**
     *moving the ball one step.
     */
    public void moveOneStep() {
        CollisionInfo checkIfHit = this.gameEnvironment.getClosestCollision(this.trajectory());
        if (checkIfHit != null) { // in case there is a collision
            this.velocity = checkIfHit.collisionObject().hit(this, checkIfHit.collisionPoint(), this.velocity);
        } else {
            //in case the ball got to any border rib
            if (this.getX() + this.radius + this.velocity.getDx() > this.frameX2
                    || this.getX() - this.radius + this.velocity.getDx() < this.frameX1) {
                setVelocity(-1 * (this.velocity.getDx()), this.velocity.getDy());
            }
            if (this.getY() - this.radius + this.velocity.getDy() < this.frameY1
                    || this.getY() + this.radius + this.velocity.getDy() > this.frameY2) {
                setVelocity(this.velocity.getDx(), -1 * (this.velocity.getDy()));
            }
            this.center = this.getVelocity().applyToPoint(this.center);
        }
    }

    /**
     *
     */
    public void timePassed() {
        moveOneStep();
    }

    /**
     * @param g adding the ball to the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * @param g removing the ball from game g
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }

    /**
     * @param start the begining of the ball center
     * @param dx movement on x axe
     * @param dy movement on y axe
     */
    static void drawAnimation(Point start, double dx, double dy) {
        GUI gui = new GUI("Painting a ball", 200, 200);
        Sleeper sleeper = new Sleeper();
        Ball ball = new Ball(start.getX(), start.getY(), 30, java.awt.Color.BLACK);
        ball.setFrames(0, 200, 0, 200);
        ball.setVelocity(dx, dy);
        while (true) {
            ball.moveOneStep();
            DrawSurface d = gui.getDrawSurface();
            ball.drawOn(d);
            gui.show(d);
            sleeper.sleepFor(50);  // wait for 50 milliseconds.
        }
    }
}
