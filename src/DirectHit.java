import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * class implement level information.
 * class support all level information methods.
 * the class describes a level named Direct Hit.
 */
public class DirectHit implements LevelInformation {
    private static final int BALL_SPEED = 4;
    private static final int PADDLE_SPEED = 7;
    private static final int PADDLE_WIDTH = 80;
    private static final int NUMBER_OF_BALLS = 1;
    private static final int NUMBER_OF_BLOCKS = 1;

    /**
     * @return the number of balls in the level.
     */
    @Override
    public int numberOfBalls() {
        return NUMBER_OF_BALLS;
    }

    /**
     * create a list of the balls velocities in the level.
     *
     * @return the balls velocities.
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(Velocity.fromAngleAndSpeed(0, BALL_SPEED));
        return velocities;
    }

    /**
     * return the paddles' speed in the level.
     *
     * @return the paddle speed.
     */
    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }

    /**
     * return the paddles' width in the level.
     *
     * @return the paddle width.
     */
    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }

    /**
     * @return the levels' name.
     */
    @Override
    public String levelName() {
        return "Direct Hit";
    }

    /**
     * @return the levels' background.
     */
    @Override
    public Sprite getBackground() {
        DirectHitBackground backGround = new DirectHitBackground();
        return backGround;
    }

    /**
     * create a list of the blocks in the level.
     *
     * @return a list of the blocks in the game
     */
    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Point upperLeft = new Point(GameLevel.FRAME_WIDTH / 2 - GameLevel.BLOCK_WIDTH / 2, GameLevel.FRAME_HEIGHT / 4);
        Block block = new Block(upperLeft, GameLevel.BLOCK_WIDTH, GameLevel.BLOCK_HEIGHT);
        block.setColor(Color.RED);
        blocks.add(block);
        return blocks;
    }

    /**
     * @return the number of blocks in the level.
     */
    @Override
    public int numberOfBlocksToRemove() {
        return NUMBER_OF_BLOCKS;
    }
}
