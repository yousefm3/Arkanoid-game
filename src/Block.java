/**
 * @author Mohamed Yousef
 */
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Block class.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangledBlock;
    private java.awt.Color color;
    private List<HitListener> hitListeners = new ArrayList<HitListener>();
    /**
     * @param rect represents the block
     * @param color1 the color of the block
     */
    public Block(Rectangle rect, java.awt.Color color1) {
        this.rectangledBlock = rect;
        this.color = color1;
    }

    /**
     * @param rect represents the block
     */
    public Block(Rectangle rect) {
        this.rectangledBlock = rect;
        this.color = Color.black;
    }
    /**
     * @param collisionPoint where the collision happend
     * @param currentVelocity current velocity of the ball
     * @param hitter the ball that can hit
     * @return the new velocity after the hit
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        if (collisionPoint != null) {
            Velocity newVelocity = currentVelocity;
            //
            double leftX = rectangledBlock.getUpperLeft().getX();
            double lowerY = rectangledBlock.getUpperLeft().getY();
            double upperY = rectangledBlock.getUpperLeft().getY() + rectangledBlock.getHeight();
            double rightX = rectangledBlock.getUpperLeft().getX() + rectangledBlock.getWidth();

            double collisionPointX = collisionPoint.getX();
            double collisionPointY = collisionPoint.getY();
             // hitting an edge
            if ((collisionPointX == leftX || collisionPointX == rightX)
                    && (collisionPointY == upperY || collisionPointY == lowerY)) {
                newVelocity.setDx(currentVelocity.getDx() * -1);
                newVelocity.setDy(currentVelocity.getDy() * -1);
                this.notifyHit(hitter);
                return  newVelocity;
            } else if ((collisionPointX > Math.min(leftX, rightX) && (collisionPointX < Math.max(leftX, rightX)))) {
                newVelocity.setDy((currentVelocity.getDy()) * -1); // hitting upper or lower part of the block
                this.notifyHit(hitter);
                return newVelocity;
            } else {
                newVelocity.setDx(currentVelocity.getDx() * -1); // hitting one of the sides
                this.notifyHit(hitter);
                return newVelocity;
            }
        }
        this.notifyHit(hitter);
        return  currentVelocity;
    }

    /**
     * @return the block
     */
        public Rectangle getCollisionRectangle() {
            return this.rectangledBlock;
    }
    /**
     * @param g adding the block to the game
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * @param surface the surface where the block should be
     */
    public void drawOn(DrawSurface surface) {
        Point upperLeft = this.rectangledBlock.getUpperLeft();
        double width = this.rectangledBlock.getWidth();
        double height = this.rectangledBlock.getHeight();
        surface.setColor(this.color);
        surface.fillRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) width, (int) height);
        surface.setColor(Color.black);
        surface.drawRectangle((int) upperLeft.getX(), (int) upperLeft.getY(), (int) width, (int) height);
    }
    /**
     * @param hl Add hl as a listener to hit events.
     */
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }
    /**
     * @param hl  Remove hl from the list of listeners to hit events.
     */
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * @param hitter the ball hitting the block
     */
    public void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:

        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
    /**
     * doing nothing atm.
     */
    public void timePassed() {  }
    /**
     * @return the block color
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * @param game where the block we want to remove is
     */
    public void removeFromGame(GameLevel game) {
    game.removeCollidable(this);
    game.removeSprite(this);
    }
}
