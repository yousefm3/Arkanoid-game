/**
 * @author Mohamed Yousef
 */
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.awt.Color;
/**
 * The Paddle is the player in the game. It is a rectangle that is controlled by the arrow keys,
 *and moves according to the player key presses
 */
public class Paddle implements Sprite, Collidable {
    private Rectangle rectangle;
    private java.awt.Color color;
    private GUI gui;
    private int speed;

    /**
     * @param rec the paddle shaped as rectangle
     * @param c   the color of it
     * @param s the paddle speed
     */
    public Paddle(Rectangle rec, java.awt.Color c, int s) {
        this.rectangle = rec;
        this.color = c;
        this.speed = s;
    }

    /**
     * @param g the GUI that we are using
     */
    public void setGUI(GUI g) {
        this.gui = g;
    }

    /**
     * moving the paddle 5 x cordinate to the left as far as we can, when pressing left key.
     */
    public void moveLeft() {
        double xLeft = this.rectangle.getUpperLeft().getX();
        // checking if may hit the left block
        if (xLeft - speed > 15) {
            Point upperL = new Point(this.rectangle.getUpperLeft().getX() - speed,
                    this.rectangle.getUpperLeft().getY());
            this.rectangle = new Rectangle(upperL, this.rectangle.getWidth(), this.rectangle.getHeight());
        } else {
            Point upperL = new Point(15, this.rectangle.getUpperLeft().getY());
            this.rectangle = new Rectangle(upperL, this.rectangle.getWidth(), this.rectangle.getHeight());
        }
    }

    /**
     * moving the paddle 5 x cordinate to the right as far as we can, when pressing left key.
     */
    public void moveRight() {
        double xRight = this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth();
        // checking if it may hit the right block
        if (xRight + speed < 785) {
            Point upperL = new Point(this.rectangle.getUpperLeft().getX() + speed,
                    this.rectangle.getUpperLeft().getY());
            this.rectangle = new Rectangle(upperL, this.rectangle.getWidth(), this.rectangle.getHeight());
        } else {
            Point upperL = new Point(785 - this.rectangle.getWidth(), this.rectangle.getUpperLeft().getY());
            this.rectangle = new Rectangle(upperL, this.rectangle.getWidth(), this.rectangle.getHeight());
        }
    }

    /**
     * timePassed method should check if the "left" or "right" keys are pressed, and if so move it accordingly.
     */
    public void timePassed() {
        biuoop.KeyboardSensor keyboard = gui.getKeyboardSensor();
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * drawing the paddle.
     *
     * @param d the surface we are drawing in
     */
    public void drawOn(DrawSurface d) {
        Point upperLeft = this.rectangle.getUpperLeft();
        double width = this.rectangle.getWidth();
        double height = this.rectangle.getHeight();
        d.setColor(this.color);
        d.fillRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) width, (int) height);
        d.setColor(Color.black);
        d.drawRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) width, (int) height);
    }

    /**
     * @return the paddle
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * @param collisionPoint  where the collision happens
     * @param currentVelocity current velocity
     * @param ball the ball hitting the paddle
     * @return the new velocity after the hit
     */
    public Velocity hit(Ball ball, Point collisionPoint, Velocity currentVelocity) {
        double xLeft = this.rectangle.getUpperLeft().getX();
        double width = this.rectangle.getWidth();
        double fifthWidth = this.rectangle.getWidth() / 5;
        //each Point represent a region x is the start of it and y is the end of it
        Point region1 = new Point(xLeft, xLeft + fifthWidth);
        Point region2 = new Point(xLeft + fifthWidth, xLeft + (fifthWidth * 2));
        Point region3 = new Point(xLeft + (fifthWidth * 2), xLeft + (fifthWidth * 3));
        Point region4 = new Point(xLeft + (fifthWidth * 3), xLeft + (fifthWidth * 4));
        Point region5 = new Point(xLeft + (fifthWidth * 4), xLeft + width);
        Double collisionX = collisionPoint.getX();
        Velocity newVelocity = currentVelocity;
        //checking if it hit the upper or lower ribs
        if (collisionX > region1.getX() && collisionX < region5.getY()) {
            // each if represents a position
            if (collisionX <= region1.getY()) {
                newVelocity = currentVelocity.fromAngleAndSpeed(300, 7);
            } else if (collisionX <= region2.getY()) {
                newVelocity = currentVelocity.fromAngleAndSpeed(330, 7);
            } else if (collisionX <= region3.getY()) {
                newVelocity.setDy(currentVelocity.getDy() * -1);
            } else if (collisionX <= region4.getY()) {
                newVelocity = currentVelocity.fromAngleAndSpeed(30, 7);
            } else if (collisionX < region5.getY()) {
                newVelocity = currentVelocity.fromAngleAndSpeed(60, 7);
            }
        } else {

            newVelocity.setDy(currentVelocity.getDx() * -1);
        }
        return newVelocity;
    }
        /**
         *Add this paddle to the game.
         * @param g the game
         */
        public void addToGame(GameLevel g) {
            g.addSprite(this);
            g.addCollidable(this);
        }
    }