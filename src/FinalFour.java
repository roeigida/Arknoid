import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * class implement level information.
 * class support all level information methods.
 * the class describes a level named Final Four.
 */
public class FinalFour implements LevelInformation {
    private static final int BALL_SPEED = 5;
    private static final int PADDLE_SPEED = 8;
    private static final int PADDLE_WIDTH = 100;
    private static final int NUMBER_OF_BALLS = 3;
    private static final int NUMBER_OF_BLOCKS = 140;
    private static final double BLOCKS_START = 120;
    private static final int QUANTITY = 20; // 38 wide
    private static final double BLOCKS_WIDTH = 38;
    private static final double BLOCKS_HEIGHT = 19;
    private static final int ROWS = 8;

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
        velocities.add(Velocity.fromAngleAndSpeed(30, BALL_SPEED));
        velocities.add(Velocity.fromAngleAndSpeed(1, BALL_SPEED));
        velocities.add(Velocity.fromAngleAndSpeed(330, BALL_SPEED));
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
        return "Final Four";
    }

    /**
     * @return the levels' background.
     */
    @Override
    public Sprite getBackground() {
        return new FinalFourBackground();
    }

    /**
     * create a list of the blocks in the level.
     *
     * @return a list of the blocks in the game
     */
    @Override
    public List<Block> blocks() {
        // create an array of colors.
        Color[] colors = {Color.gray, Color.red, Color.yellow, Color.blue,
                Color.pink, Color.green, Color.CYAN, Color.MAGENTA};
        List<Block> blocks = new ArrayList<>();
        // create the blocks.
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < QUANTITY; j++) {
                Point p = new Point(20 + j * BLOCKS_WIDTH, BLOCKS_START + BLOCKS_HEIGHT * i);
                Block b = new Block(p, BLOCKS_WIDTH, BLOCKS_HEIGHT);
                b.setColor(colors[i]);
                blocks.add(b);
            }
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
