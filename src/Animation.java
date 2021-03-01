import biuoop.DrawSurface;

/**
 * the interface introduce an animation methods.
 */
public interface Animation {

    /**
     * draw a frame of the animation.
     *
     * @param d a draw surface.
     **/
    void doOneFrame(DrawSurface d);

    /**
     * @return if the animation should stop.
     */
    boolean shouldStop();
}
