import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * AnimationRunner takes an Animation object and runs it.
 * implements a run method, constructor and getter for gui.
 */
public class AnimationRunner {
    private static final int FRAMES_PER_SECOND = 60;
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    /**
     * constructor.
     */
    public AnimationRunner() {
        this.sleeper = new Sleeper();
        this.framesPerSecond = FRAMES_PER_SECOND;
        this.gui = new GUI("Arknoid", GameLevel.FRAME_WIDTH, GameLevel.FRAME_HEIGHT);
    }

    /**
     * @return gui.
     */
    public GUI getGui() {
        return gui;
    }

    /**
     * runs a given animation till it should stop.
     *
     * @param animation an animation.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        //run the animation
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}