/**
 * @author Mohamed Yousef
 */
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Level 1.
 */
public class Level1 implements LevelInformation {
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
    public Level1() {
        this.ballsNum = 1;
        this.paddleSpeed = 8;
        this.levelName = "Direct Hit";
        this.paddleWidth = 60;
        this.numberOfBlocksToRemove = 1;
        Rectangle rectangle1 = new Rectangle(new Point(390, 130), 25, 25);
        Block block1 = new Block(rectangle1, Color.red);
        this.blocks.add(block1);
        this.backGround = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.blue);
                d.drawCircle(402, 142, 40);
                d.drawCircle(402, 142, 60);
                d.drawCircle(402, 142, 80);
                //
                d.drawLine(400, 535, 400, 525);
                d.drawLine(400, 522, 400, 512);
                d.drawLine(400, 509, 400, 499);
                d.drawLine(390, 509, 400, 499);
                d.drawLine(410, 509, 400, 499);
                //
                d.drawLine(80, 142, 362, 142);
                d.drawLine(720, 142, 442, 142);
                //
                d.drawLine(211, 122, 231, 142);
                d.drawLine(211, 162, 231, 142);
                d.drawLine(591, 122, 571, 142);
                d.drawLine(591, 162, 571, 142);

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
