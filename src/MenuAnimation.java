import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * the Menu class.
 */
public class MenuAnimation implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private GUI gui;
    private Highscores highScore;
    private AnimationRunner runner;
    /**
     * @param k the press
     * @param g the GUI
     * @param highScore1 the high score
     */
    public MenuAnimation(KeyboardSensor k, GUI g, Highscores highScore1) {
        this.keyboard = k;
        this.stop = false;
        this.gui = g;
        this.highScore = highScore1;
        this.runner = new AnimationRunner(this.gui);
    }

    /**
     * @param d where we have the objects
     */
    public void doOneFrame(DrawSurface d) {

            d.setColor(Color.yellow);
            d.fillCircle(20, 20, 20);
            d.setColor(Color.lightGray);
            d.fillCircle(100, 100, 60);
            d.setColor(Color.black);
            d.fillRectangle(50, 450, 90, 135);
            d.setColor(Color.white);
            d.fillRectangle(60, 460, 80, 125);
            d.setColor(Color.black);
            for (int i = 0; i < 4; i++) {
                d.fillRectangle(70 + (i * 20), 450, 10, 150);
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
            for (int i = 1; i < 3; i++) {
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

        d.setColor(Color.BLACK);
        d.drawText(340, 250, "Menu", 50);
        d.drawText(290, 350, "press s to start the game", 20);
        d.drawText(290, 390, "press h to see the current high score", 20);
        d.drawText(290, 430, "press q to quit the game", 20);
        d.fillRectangle(70, 450, 10, 150);
        if (this.keyboard.isPressed("s")) { this.stop = true; }
        if (this.keyboard.isPressed("q")) {
            this.gui.close();
        }
        if (this.keyboard.isPressed("h")) { this.runner.run(this.highScore); }
    }
    /**
     *
     * @return if should stop or not
     */
    public boolean shouldStop() { return this.stop; }
}
