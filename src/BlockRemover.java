//ID: 322225897.

/**
 * a BlockRemover is in charge of removing blocks from the game, as well as keeping count
 * of the number of blocks that remain.
 * support a hit event method, Block remover method and game getter.
 * implemented by a game and counter of the remaining blocks.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * constructor.
     *
     * @param game           the game the lock will be remove from.
     * @param remainedBlocks the number of the removable blocks in the game.
     */
    public BlockRemover(GameLevel game, Counter remainedBlocks) {
        this.game = game;
        this.remainingBlocks = remainedBlocks;
    }

    /**
     * gets the game field.
     *
     * @return the game field.
     */
    public GameLevel getGame() {
        return game;
    }

    /**
     * when a hit event happens with a block that holds this listener the being hit block will be remove.
     *
     * @param beingHit the hit block.
     * @param hitter   the hitter ball.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(getGame());
        remainingBlocks.decrease(1);
    }
}