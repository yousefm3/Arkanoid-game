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
public class Level4 implements LevelInformation {
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
    public Level4() {
        this.ballsNum = 3;
        this.paddleSpeed = 2;
        this.levelName = "Final Hour";
        this.paddleWidth = 80;
        this.numberOfBlocksToRemove = 84;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 14; j++) {
                double x = 15 + j * 55;
                double y = 150 + i * 20;
                Point point = new Point(x, y);
                Rectangle rectangle = new Rectangle(point, 55, 20);
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
                if (i == 6) {
                    block = new Block(rectangle, Color.MAGENTA);
                }
                blocks.add(block);
            }
        }
        this.backGround = new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.cyan);
                d.fillRectangle(15, 15, 770, 150);
                for (int i = 0; i < 3; i++) {
                    d.setColor(Color.white);
                    d.drawLine(85 + (i * 250), 90, 95 + (i * 250), 150);
                    d.drawLine(95 + (i * 250), 90, 105 + (i * 250), 155);
                    d.drawLine(105 + (i * 250), 90, 115 + (i * 250), 160);
                    d.drawLine(115 + (i * 250), 90, 125 + (i * 250), 165);
                    d.drawLine(125 + (i * 250), 90, 135 + (i * 250), 170);
                    d.setColor(Color.lightGray);
                    d.fillCircle(65 + (i * 250), 70, 20);
                    d.fillCircle(90 + (i * 250), 65, 25);
                    d.fillCircle(130 + (i * 250), 70, 30);
                    d.fillCircle(80 + (i * 250), 90, 15);
                    d.fillCircle(110 + (i * 250), 90, 20);
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
