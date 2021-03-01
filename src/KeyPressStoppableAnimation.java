import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * decorator-class that will wrap an existing animation and add a "waiting-for-key" behavior to it.
 * implements animation methods.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboardSensor;
    private String key;
    private Animation animation;
    private boolean shouldStop;
    private boolean isAlreadyPressed;

    /**
     * constructor.
     *
     * @param animation an animation that stops by a key.
     * @param key       a pressed key.
     * @param sensor    a keyboard sensor.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyboardSensor = sensor;
        this.key = key;
        this.animation = animation;
        this.shouldStop = false;
        this.isAlreadyPressed = true;
    }

    /**
     * check if the key is still pressed.
     *
     * @param d draw surface.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        if (!this.isAlreadyPressed && this.keyboardSensor.isPressed(this.key)) {
            this.shouldStop = true;
        }
        if (!this.keyboardSensor.isPressed(this.key)) {
            this.isAlreadyPressed = false;
        }
        this.animation.doOneFrame(d);
    }

    /**
     * @return if the animation should stop.
     */
    @Override
    public boolean shouldStop() {
        return this.shouldStop;
    }

}