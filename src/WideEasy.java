import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * class implement level information.
 * class support all level information methods.
 * the class describes a level named Wide Easy.
 */
public class WideEasy implements LevelInformation {
    private static final int BLOCK_WIDTH = 76;
    private static final int BLOCKS_HEIGHT = 250;
    private static final int BALL_SPEED = 5;
    private static final int PADDLE_SPEED = 5;
    private static final int PADDLE_WIDTH = 680;
    private static final int NUMBER_OF_BALLS = 10;
    private static final int NUMBER_OF_BLOCKS = 10;

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
        for (int i = 0; i < NUMBER_OF_BALLS / 2; i++) {
            velocities.add(Velocity.fromAngleAndSpeed(30 + (5 * i), BALL_SPEED));
        }
        for (int i = 0; i < NUMBER_OF_BALLS / 2; i++) {
            velocities.add(Velocity.fromAngleAndSpeed(310 + (5 * i), BALL_SPEED));
        }
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
        return "Wide Easy";
    }

    /**
     * @return the levels' background.
     */
    @Override
    public Sprite getBackground() {
        WideEasyBackground background = new WideEasyBackground();
        return background;
    }

    /**
     * create a list of the blocks in the level.
     *
     * @return a list of the blocks in the game
     */
    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_BLOCKS; i++) {
            Point upperLeft = new Point(20 + i * BLOCK_WIDTH, BLOCKS_HEIGHT);
            Block block = new Block(upperLeft, BLOCK_WIDTH, GameLevel.BLOCK_HEIGHT);
            block.setColor(Color.CYAN);
            blocks.add(block);
        }
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
