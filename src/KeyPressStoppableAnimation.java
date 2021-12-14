/**
 * @author Mohamed Yousef
 */
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * it deals with stopping situations.
 */
public class KeyPressStoppableAnimation implements Animation {
    private  KeyboardSensor sensor;
    private  String key;
    private Animation animation;
    private boolean stop = false;
    private boolean isAlreadyPressed = false;

    /**
     * @param sensor1 the senser
     * @param key1 the key
     * @param animation1 the animation we will run
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor1, String key1, Animation animation1) {
        this.sensor = sensor1;
        this.animation = animation1;
        this.key = key1;
    }
    /**
     * @param d where we have the objects
     */
    public void doOneFrame(DrawSurface d) {
        animation.doOneFrame(d);
        if (this.sensor.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
            isAlreadyPressed = true;
        }
    }

    /**
     * @return if we should stop or not
     */
   public boolean shouldStop() {
       return this.stop;
   }
}