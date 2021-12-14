/**
 * @author Mohamed Yousef
 */
import biuoop.DrawSurface;
import biuoop.GUI;
import java.awt.Color;
/**
 * Game class that will hold the sprites and the collidables, and will be in charge of the animation.
 */
public class GameLevel implements Animation {
    private AnimationRunner runner;
    private boolean running;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private BlockRemover blockRemover;
    private BallRemover ballRemover;
    private ScoreIndicator scoreIndicator;
    private ScoreTrackingListener scoreTrackingListener;
    private  GUI gui;
    private biuoop.KeyboardSensor keyboard;
    private LevelInformation level;
    /**
     * giving initial value to our params.
     * @param gui the one we are using
     * @param score the score
     * @param levelNum the level number
     */
    public GameLevel(LevelInformation levelNum, GUI gui, ScoreTrackingListener score) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.scoreTrackingListener = score;
        this.level = levelNum;
        this.ballRemover = new BallRemover(this, new Counter(this.level.numberOfBalls()));
        this.blockRemover = new BlockRemover(this, new Counter(this.level.numberOfBlocksToRemove()));
        this.gui = gui;
    }
    /**
     * @param c the collidable that we will add to the environment
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * @param s the sprite we will add to the sprites list
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * @return this environmet
     */
    public GameEnvironment getEnvironment() {
        return this.environment;
    }

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle) and add them to the game.
     */
    public void initialize() {
        this.sprites.addSprite(this.level.getBackground());
        // making a 800x600 window
        this.scoreIndicator = new ScoreIndicator(this.scoreTrackingListener.getCurrentScore());
        this.sprites.addSprite(scoreIndicator);
        // making wide grey corners so the ball does not go out side the screen
        Rectangle rectangle1 = new Rectangle(new Point(0, 0), 800, 15);
        Block block1 = new Block(rectangle1, Color.gray);
        block1.addToGame(this);
        Rectangle rectangle2 = new Rectangle(new Point(0, 0), 15, 600);
        Block block2 = new Block(rectangle2, Color.gray);
        block2.addToGame(this);
        Rectangle rectangle3 = new Rectangle(new Point(0, 585), 800, 15);
        Block block3 = new Block(rectangle3, Color.gray);
        block3.addToGame(this);
        block3.addHitListener(this.ballRemover);
        Rectangle rectangle4 = new Rectangle(new Point(785, 0), 15, 600);
        Block block4 = new Block(rectangle4, Color.gray);
        block4.addToGame(this);
        // adding three balls with specific characters
        Ball ball1, ball2, ball3, ball4, ball5, ball6, ball7, ball8, ball9, ball10;

        double x1 = 358;
        double y1 = 579;
        Point point1 = new Point(x1, y1);
        // adding a new paddle with specific characters
        Rectangle rect = new Rectangle(point1, 84, 6);
        Paddle paddle = new Paddle(rect, Color.ORANGE, 12);
        if (this.level.numberOfBalls() == 10) {
            Rectangle rect1 = new Rectangle(new Point(76, 579), 646, 6);
            paddle = new Paddle(rect1, Color.orange, 1);
        }
        paddle.setGUI(this.gui);
        paddle.addToGame(this);
        //i present number of lines, j  num of blocks in that line
       for (Block block : this.level.blocks()) {
           block.addHitListener(this.blockRemover);
           block.addHitListener(this.scoreTrackingListener);
           block.addToGame(this);
       }
        if (this.level.numberOfBalls() == 1) {

            ball1 = new Ball(400, 550, 4, Color.BLACK);
            double speed = 7;
            double angle = 1;
            Velocity ball1Vel = Velocity.fromAngleAndSpeed(angle, speed);
            ball1.setVelocity(ball1Vel);
            ball1.setFrames(0, 800, 0, 600);
            ball1.setGameEnvironment(this.getEnvironment());
            ball1.addToGame(this);
        } else if (this.level.numberOfBalls() == 2) {
            ball1 = new Ball(400, 550, 4, Color.black);
            ball2 = new Ball(400, 550, 4, Color.black);
            double speed = 7;
            double angle = 40;
            Velocity ball1Vel = Velocity.fromAngleAndSpeed(angle - 80, speed);
            Velocity ball2Vel = Velocity.fromAngleAndSpeed(angle, speed);
            ball1.setVelocity(ball1Vel);
            ball2.setVelocity(ball2Vel);
            ball1.setFrames(0, 800, 0, 600);
            ball2.setFrames(0, 800, 0, 600);
            ball1.setGameEnvironment(this.getEnvironment());
            ball2.setGameEnvironment(this.getEnvironment());
            ball1.addToGame(this);
            ball2.addToGame(this);
        } else if (this.level.numberOfBalls() == 3) {
            
            ball1 = new Ball(400, 550, 4, Color.BLACK);
            ball2 = new Ball(400, 550, 4, Color.BLACK);
            ball3 = new Ball(400, 550, 4, Color.BLACK);
            Velocity ball1Vel = Velocity.fromAngleAndSpeed(-40, 7);
            Velocity ball2Vel = Velocity.fromAngleAndSpeed(40, 7);
            Velocity ball3Vel = Velocity.fromAngleAndSpeed(1, 7);
            ball1.setVelocity(ball1Vel);
            ball2.setVelocity(ball2Vel);
            ball3.setVelocity(ball3Vel);
            ball1.setFrames(0, 800, 0, 600);
            ball2.setFrames(0, 800, 0, 600);
            ball3.setFrames(0, 800, 0, 600);
            ball1.setGameEnvironment(this.getEnvironment());
            ball2.setGameEnvironment(this.getEnvironment());
            ball3.setGameEnvironment(this.getEnvironment());
            ball1.addToGame(this);
            ball2.addToGame(this);
            ball3.addToGame(this);
        } else if (this.level.numberOfBalls() == 10) {
            for (int i = 0; i < 10; i++) {
              Ball ball = new Ball(400, 550, 4, Color.BLACK);
              if (i < 5) {
                  Velocity ball1Vel = Velocity.fromAngleAndSpeed(300 + (12 * i), 7);
                  ball.setVelocity(ball1Vel);
              } else {
                  Velocity ball1Vel = Velocity.fromAngleAndSpeed(309 + (12 * i), 7);
                  ball.setVelocity(ball1Vel);
              }
                ball.setFrames(0, 800, 0, 600);
                ball.setGameEnvironment(this.getEnvironment());
                ball.addToGame(this);
            }
        }
    }
    /**
     * @param c the Collidable we will remove
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }
    /**
     * @param s the Sprite we will remove
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }
    /**
     * @return should stop or not
     */
    public boolean shouldStop() {
        return !this.running;
    }
    /**
     * @param d where we show the objects
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(500, 30, "Level Name: " + this.level.levelName(), 15);
        if (this.level.numberOfBalls() == 3) {
            if (this.blockRemover.getCounter() > 60) {
                d.drawText(20, 500, "I'll bet 4 points that u'll lose first two tries", 20);
            }
            if (this.blockRemover.getCounter() < 20 && this.blockRemover.getCounter() > 3) {
                d.drawText(50, 300, "trust me u cant", 20);
            }
            if (this.blockRemover.getCounter() <= 3) {
                d.drawText(50, 300, "RIP ME 2000-2020", 20);
            }
        } else if (this.level.numberOfBalls() == 1) {
            d.drawText(20, 480, "Okey its workin", 20);
        } else if (this.level.numberOfBalls() == 10) {
            d.drawText(20, 480, "Not even warmup w8", 20);
        } else if (this.level.numberOfBalls() == 2) {
            if (this.blockRemover.getCounter() > 30) {
                d.drawText(600, 480, "U got this", 20);
            } else if (this.blockRemover.getCounter() > 22) {
                d.drawText(500, 480, "bro u gotta focus and warm up", 20);
                d.drawText(500, 500, "things about to get interesting", 20);
            } else if (this.blockRemover.getCounter() < 5) {
                d.drawText(50, 100, "Ready?", 20);
            }
        }
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
        this.keyboard = this.runner.getGui().getKeyboardSensor();
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, " ", new PauseScreen(this.keyboard)));
        }
        if (this.ballRemover.getCounter() == 0) {
            this.running = false;
        }
        if (this.blockRemover.getCounter() == 0) {
            this.scoreIndicator.getCurrentScore().increase(100);
            this.running = false;
        }
    }

    /**
     *Run the game -- start the animation loop.
     */
    public void run() {
        this.runner = new AnimationRunner(this.gui);
        this.runner.run(new CountdownAnimation(1.5, 3, this.sprites, this.level));
        this.running = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);
    }

    /**
     * @return the balls count
     */
    public int getBallCount() {
        return this.ballRemover.getCounter();
    }

    /**
     * @return the blocks count
     */
    public int getBlocksCount() {
        return this.blockRemover.getCounter();
    }

    /**
     * @param args null
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Arkanoid", 800, 600);
        Level3 level3 = new Level3();
        GameLevel game = new GameLevel(level3, gui, new ScoreTrackingListener(new Counter(0)));
        game.initialize();
        game.run();
    }
}
