/**
 * @author Mohamed Yousef
 */
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * Level 2.
 */
public class Level2 implements LevelInformation {
    private  int ballsNum;
    private List<Velocity> ballsVel;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private Sprite backGround;
    private List<Block> blocks = new ArrayList<>();
    private int numberOfBlocksToRemove;

    /**
     * Constructor.
     */
    public Level2() {
        this.ballsNum = 10;
        this.paddleSpeed = 2;
        this.levelName = "Wide Easy";
        this.paddleWidth = 680;
        this.numberOfBlocksToRemove = 14;
        for (int i = 0; i < 14; i++) {
            Rectangle rectangle1 = new Rectangle(new Point(15 + (i * 55), 250), 55, 20);
            Block block1 = new Block(rectangle1, Color.red);
            if (i < 2) {
                block1 = new Block(rectangle1, Color.red);
            }
            if (i >= 2 && i < 4) {
                block1 = new Block(rectangle1, Color.orange);
            }
            if (i >= 4 && i < 6) {
                block1 = new Block(rectangle1, Color.green);
            }
            if (i >= 6 && i < 8) {
                block1 = new Block(rectangle1, Color.blue);
            }
            if (i >= 8 && i < 10) {
                block1 = new Block(rectangle1, Color.yellow);
            }
            if (i >= 10 && i < 12) {
                block1 = new Block(rectangle1, Color.pink);
            }
            if (i >= 12 && i < 14) {
                block1 = new Block(rectangle1, Color.lightGray);
            }
            this.blocks.add(block1);
        }
        this.backGround = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.yellow);
               d.fillCircle(20, 20, 20);
               d.setColor(Color.lightGray);
                d.fillCircle(100, 100, 60);
                    for (int i = 0; i < 40; i++) {
                        d.drawLine(60 + (2 * i), 130 - i, 15 + (15 * i), 250);
                    }
            }

            @Override
            public void timePassed() {

            }
        };
    }
    /**
     * @return number of balls
     */
    public int numberOfBalls() {
        return this.ballsNum;
    }

    /**
     * @return initial balls velocit
     */
    public List<Velocity> initialBallVelocities() {
        return this.ballsVel;
    }

    /**
     * @return paddle speed
     */
    public int paddleSpeed() {
        return this.paddleSpeed;
    }

    /**
     * @return paddle width
     */
    public int paddleWidth() {
        return this.paddleWidth;
    }

    /**
     * @return Level Name
     */
    public String levelName() {
        return this.levelName;
    }

    /**
     * @return the background.
     */
    public Sprite getBackground() {
        return this.backGround;
    }

    /**
     * @return blocks list
     */
    public List<Block> blocks() {
        return this.blocks;
    }

    /**
     * @return number of blocks to remove
     */
    public int numberOfBlocksToRemove() {
        return this.numberOfBlocksToRemove;
    }

}
