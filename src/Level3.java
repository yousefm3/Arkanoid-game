/**
 * @author Mohamed Yousef
 */
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Level 3.
 */
public class Level3 implements LevelInformation {
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
    public Level3() {
        this.ballsNum = 2;
        this.paddleSpeed = 2;
        this.levelName = "Green 3";
        this.paddleWidth = 80;
        this.numberOfBlocksToRemove = 45;
        for (int i = 0; i < 6; i++) {
            for (int j = i; j < 10; j++) {
                double x = 285 + j * 50;
                double y = 100 + i * 20;
                Point point = new Point(x, y);
                Rectangle rectangle = new Rectangle(point, 50, 20);
                Block block = new Block(rectangle, Color.green);
                // 1st line
                if (i == 0) {
                    block = new Block(rectangle, Color.gray);
                }
                // 2nd line
                if (i == 1) {
                    block = new Block(rectangle, Color.RED);
                }
                // 3rd line
                if (i == 2) {
                    block = new Block(rectangle, Color.yellow);
                }
                // 4th line
                if (i == 3) {
                    block = new Block(rectangle, Color.blue);
                }
                // 5th line
                if (i == 4) {
                    block = new Block(rectangle, Color.pink);
                }
                // 6th line
                if (i == 5) {
                    block = new Block(rectangle, Color.green);
                }
                blocks.add(block);
            }
        }
        this.backGround = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.black);
                d.fillRectangle(50, 450, 90, 135);
                d.setColor(Color.white);
                d.fillRectangle(60, 460, 80, 125);
                d.setColor(Color.black);
                for (int i = 0; i < 4; i++) {
                    d.fillRectangle(70 + (i * 20), 450, 10, 135);
                    d.fillRectangle(60, 450 + (i * 40), 70, 10);
                }
                d.setColor(Color.GRAY);
                d.fillRectangle(80, 390, 30, 60);
                d.fillRectangle(90, 200, 10, 190);
                d.setColor(Color.orange);
                d.fillCircle(95, 190, 12);
                d.setColor(Color.red);
                d.fillCircle(95, 190, 8);
                d.setColor(Color.white);
                d.fillCircle(95, 190, 3);

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
