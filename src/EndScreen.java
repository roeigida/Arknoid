import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * Once the game is over (either the player died, or he managed to clear all the levels),
 * we will display the final score. If the game ended with the player dying (i.e. all balls fall off the screen),
 * the end screen should display the message "Game Over. Your score is X" (X being the final score).
 * If the game ended by clearing all the levels, the screen should display "You Win! Your score is X".
 * implements animation methods.
 */
public class EndScreen implements Animation {
    private int score;
    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private boolean isWon;
    private boolean shouldStop;
    private static final int FONT = 30;

    /**
     * constructor.
     *
     * @param ar  an animation runner.
     * @param ks  a keyboard sensor.
     * @param sc  the score.
     * @param won an indicator if the player won or lost to know what display.
     */
    public EndScreen(int sc, KeyboardSensor ks, AnimationRunner ar, boolean won) {
        this.score = sc;
        this.keyboardSensor = ks;
        this.animationRunner = ar;
        this.isWon = won;
        this.shouldStop = false;
    }

    /**
     * do one frame and draw the end screen.
     *
     * @param d draw surface.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.isWon) {
            d.setColor(Color.lightGray);
            d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
            d.setColor(Color.BLUE);
            d.drawText(d.getWidth() / 4, d.getHeight() / 2, "You Win! Your score is " + this.score, FONT);
            d.setColor(Color.CYAN);
            d.drawText(d.getWidth() / 4, d.getHeight() / 2 + 1, "You Win! Your score is " + this.score, FONT);
        } else {
            d.setColor(Color.BLUE);
            d.drawText(d.getWidth() / 4, d.getHeight() / 2, "Game Over. Your score is " + this.score, FONT);
            d.setColor(Color.CYAN);
            d.drawText(d.getWidth() / 4, d.getHeight() / 2 + 1, "Game Over. Your score is " + this.score, FONT);
        }
        if (this.keyboardSensor.isPressed(keyboardSensor.SPACE_KEY)) {
            // if the space key pressed the gui should be close.
            animationRunner.getGui().close();
            this.shouldStop = true;
        }
    }

    /**
     * @return if the animation should stop.
     */
    @Override
    public boolean shouldStop() {
        return this.shouldStop;
    }

}
