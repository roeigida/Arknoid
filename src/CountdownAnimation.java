import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;


/**
 * The CountdownAnimation will display the given gameScreen,
 * for numOfSeconds seconds, and on top of them it will show
 * a countdown from countFrom back to 1, where each number will
 * appear on the screen for (numOfSeconds / countFrom) seconds, before it is replaced with the next one.
 * implements animation methods.
 */
public class CountdownAnimation implements Animation {
    private static final int END = -2;
    private static final int FONT = 60;
    private int countFrom;
    private double numOfSeconds;
    private SpriteCollection gameScreen;
    private boolean done;
    private boolean isFirstFrame;

    /**
     * constructor.
     *
     * @param numOfSeconds the number of seconds the countdown take.
     * @param countFrom    from where to start the countdown.
     * @param gameScreen   the sprite collection that represent the game screen.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds / countFrom;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.done = false;
        this.isFirstFrame = true;
    }

    /**
     * do one frame and draws it.
     *
     * @param d draw surface.
     */
    public void doOneFrame(DrawSurface d) {
        Sleeper sleeper = new Sleeper();
        this.gameScreen.drawAllOn(d);
        //in case the count went to 0 it should draw "GO!".
        if (this.countFrom == 0) {
            d.setColor(Color.BLACK);
            d.drawText(d.getWidth() / 2, d.getHeight() / 2, "GO!", FONT + 1);
            d.setColor(Color.WHITE);
            d.drawText(d.getWidth() / 2, d.getHeight() / 2, "GO!", FONT);
        } else {
            d.setColor(Color.BLACK);
            d.drawText(d.getWidth() / 2, d.getHeight() / 2, "" + this.countFrom, FONT + 1);
            d.setColor(Color.WHITE);
            d.drawText(d.getWidth() / 2, d.getHeight() / 2, "" + this.countFrom, FONT);
        }
        this.countFrom--;
        // should not sleep if it is the first frame
        if (this.isFirstFrame) {
            this.isFirstFrame = false;
            return;
        }
        sleeper.sleepFor((long) (1000 * this.numOfSeconds));
        if (countFrom == END) {
            this.done = true;
        }
    }

    /**
     * @return if the count down go to "GO!" so it should stop.
     */
    public boolean shouldStop() {
        return this.done;
    }
}