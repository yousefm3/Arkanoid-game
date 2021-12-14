import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * @author Mohamed Yousef
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    /**
     * @param g the gui
     */
    public AnimationRunner(GUI g)  {
        this.gui = g;
        this.framesPerSecond = 60;
        this.sleeper = new Sleeper();
    }
    /**
     * @param animation the running animation
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = this.gui.getDrawSurface();

            animation.doOneFrame(d);
            this.gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * @return this gui
     */
    public GUI getGui() {
        return this.gui;
    }
}
