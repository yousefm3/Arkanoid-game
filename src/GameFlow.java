/**
 * @author Mohamed Yousef
 */
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;
import java.util.ArrayList;
import java.util.List;

/**
 * This class will be in charge of creating the different levels, and moving from one level to the next.
 */
public class GameFlow {
    private List<LevelInformation> levels;
    private GUI gui;
    private ScoreTrackingListener score = new ScoreTrackingListener(new Counter(0));
    private boolean checkIfBallsOver = false;
    private AnimationRunner runner;
    private biuoop.KeyboardSensor keyboard;
    private Highscores highScore;

    /**
     * @param levels the levels we r about to play
     */
    public GameFlow(List<LevelInformation> levels) {
        this.levels = levels;
        this.gui = new GUI("Arkanoid", 800, 600);
        this.runner = new AnimationRunner(this.gui);
    }

    /**
     * @param lvls the levels we will run into
     */
    public void runLevels(List<LevelInformation> lvls) {
        this.keyboard = this.runner.getGui().getKeyboardSensor();
        this.highScore = new Highscores(this.keyboard);
        while (true) {
            this.runner.run(new MenuAnimation(this.keyboard, this.gui, this.highScore));
            for (LevelInformation levelInfo : lvls) {

                GameLevel level = new GameLevel(levelInfo, this.gui, score);
                level.initialize();
                while (level.getBallCount() > 0 && level.getBlocksCount() > 0) {
                    level.run();
                }
                if (level.getBallCount() == 0) {
                    checkIfBallsOver = true;
                    break;
                }
            }
            this.highScore.checkMax(this.score.getCurrentScore().getValue());
            biuoop.KeyboardSensor keyboard1 = gui.getKeyboardSensor();
            while (!keyboard1.isPressed(KeyboardSensor.SPACE_KEY)) {
                int millisecondsPerFrame = 1000 / 60;
                Sleeper sleeper = new Sleeper();
                long startTime = System.currentTimeMillis(); // timing
                DrawSurface d = this.gui.getDrawSurface();
                if (checkIfBallsOver) {
                    d.drawText(170, 300, "Game Over. Your score is "
                            + this.score.getCurrentScore().getValue(), 30);
                } else {
                    d.drawText(195, 300, "You Win! Your score is "
                            + this.score.getCurrentScore().getValue(), 30);
                }
                this.gui.show(d);
                long usedTime = System.currentTimeMillis() - startTime;
                long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
                if (milliSecondLeftToSleep > 0) {
                    sleeper.sleepFor(milliSecondLeftToSleep);
                }
            }
            this.runner.run(this.highScore);
            this.highScore.setStop(false);
            this.score = new ScoreTrackingListener(new Counter(0));
        }
    }

    /**
     * @param args null
     *  testing
     */
    public static void main(String[] args) {
        List<LevelInformation> lev = new ArrayList<>();
        lev.add(new Level3());
        GameFlow game = new GameFlow(lev);
        game.runLevels(lev);
    }
}
