//ID: 322225897.

/**
 * the class purpose is to remove a ball when hitting a block that has BallRemover listener.
 * the class implements hit listener.
 * the class supports the methods hitEvent a constructor and a game getter method.
 * implemented by a game and counter of the remaining blocks.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * constructor.
     *
     * @param game          the game the ball will be removed from.
     * @param remainedBalls the number of balls in the game.
     */
    public BallRemover(GameLevel game, Counter remainedBalls) {
        this.game = game;
        this.remainingBalls = remainedBalls;
    }

    /**
     * gets the game field.
     *
     * @return game.
     */
    public GameLevel getGame() {
        return game;
    }

    /**
     * when a hit event happens with a block that holds this listener the hitter ball will be remove from the game.
     *
     * @param beingHit the hit block.
     * @param hitter   the hitter ball.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(getGame());
        remainingBalls.decrease(1);
    }
}
