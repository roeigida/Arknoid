import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * animation, that will display a screen with the message paused -- press space to continue until SPACE key is pressed.
 * implements animation methods.
 */
public class PauseScreen implements Animation {
    private static final int MIDDLE_SCREEN = 155;
    private KeyboardSensor keyboard;
    private boolean stop;
    private SpriteCollection gameScreen;

    /**
     * constructor.
     *
     * @param gameScreen the game screen that will be draw as a background.
     * @param k          a keyboard sensor.
     */
    public PauseScreen(KeyboardSensor k, SpriteCollection gameScreen) {
        this.keyboard = k;
        this.stop = false;
        this.gameScreen = gameScreen;
    }

    /**
     * do one frame and draw the pause screen animation.
     *
     * @param d draw surface.
     */
    public void doOneFrame(DrawSurface d) {
        if (gameScreen != null) {
            //the game screen that will be draw as a background.
            gameScreen.drawAllOn(d);
        }
        // drawing of pause button
        d.setColor(Color.CYAN);
        d.fillCircle(400, 300, 70);
        d.setColor(Color.BLACK);
        d.drawCircle(400, 300, 70);
        d.setColor(Color.BLUE);
        d.fillRectangle(380, 270, 13, 60);
        d.fillRectangle(405, 270, 13, 60);
        d.drawText(MIDDLE_SCREEN, d.getHeight() / 2 - 150, "paused -- press space to continue", 32);
        d.setColor(Color.CYAN);
        d.drawText(MIDDLE_SCREEN, d.getHeight() / 2 - 149, "paused -- press space to continue", 32);
        // the animation stops when a space key is pressed.
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    /**
     * @return if the animation should stop.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}