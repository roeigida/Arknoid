//ID: 322225897.

/**
 * update the game counter when blocks are being hit and removed.
 * implemented by counter.
 * supports constructor and hit event methods.
 */
public class ScoreTrackingListener implements HitListener {
    private static final int SCORE_FOR_HIT = 5;
    private Counter currentScore;

    /**
     * constructor.
     *
     * @param scoreCounter a given score counter.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * when a hit event happens with a block that holds this listener the counter value increase by the agreed score.
     *
     * @param beingHit the hit block.
     * @param hitter   the hitter ball.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        currentScore.increase(SCORE_FOR_HIT);
    }
}