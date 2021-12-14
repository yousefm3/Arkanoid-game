import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;

/**
 * the count down animation class.
 */
public class CountdownAnimation implements Animation {
    private SpriteCollection sprites;
    private boolean running;
    private double numOfSeconds;
    private int countFrom;
    private LevelInformation level;
    /**
     * @param gameScreen   is the list of the sprites of the game.
     * @param numOfSeconds how much it longs
     * @param countFrom the start count
     * @param lev this level information
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen, LevelInformation lev) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.sprites = gameScreen;
        this.level = lev;
        running = false;
    }

    /**
     * doOneFrame method draws the numbers from contFrom to 1 on the screen.
     *
     * @param d  the draw surface
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(500, 30, "Level Name: " + this.level.levelName(), 15);
        if (this.level.numberOfBalls() == 3) {
            d.drawText(20, 500, "I'll bet 4 points that u'll lose first two tries", 20);
        }
        Sleeper sleeper = new Sleeper();
        this.sprites.drawAllOn(d);
        String timeLeft;
        d.setColor(Color.black);
        if (this.countFrom == -1) {
            running = true;
        } else {
            timeLeft = Integer.toString(this.countFrom);
            if (this.countFrom == 0) {
                timeLeft = "GO";
            }
            d.drawText(d.getWidth() / 2, d.getHeight() / 2, timeLeft, 25);
            this.countFrom = this.countFrom - 1;
        }

        sleeper.sleepFor((long) ((1000) * this.numOfSeconds) / 3);

    }

    /**
     * @return if should stop or not.
     */
    public boolean shouldStop() {
        return running;
    }
}