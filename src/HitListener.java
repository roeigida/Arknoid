//ID: 322225897.

/**
 * notified when a block is being hit and preform the hit event that fits to the listener.
 */
public interface HitListener {

    /**
     * This method is called whenever the beingHit object is hit.
     *
     * @param hitter   is the Ball that's doing the hitting.
     * @param beingHit the block that being hit.
     */
    void hitEvent(Block beingHit, Ball hitter);
}