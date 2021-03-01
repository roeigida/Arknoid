import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * class implement level information.
 * class support all level information methods.
 * the class describes a level named Green 3.
 */
public class Green3 implements LevelInformation {
    private static final int BALL_SPEED = 5;
    private static final int PADDLE_SPEED = 7;
    private static final int PADDLE_WIDTH = 80;
    private static final int NUMBER_OF_BALLS = 2;
    private static final int NUMBER_OF_BLOCKS = 34;
    private static final double BLOCKS_START = 150;
    private static final int QUANTITY = 10;

    /**
     * create a row of blocks from point. the quantity of blocks is as the variable qnt.
     *
     * @param point  the start point of the blocks' row.
     * @param qnt    the quantity of blocks.
     * @param color  the color of the blocks.
     * @param blocks list of blocks to add to the game.
     */
    public void addBlocksByPoint(Point point, int qnt, Color color, List<Block> blocks) {
        for (int i = 0; i < qnt; i++) {
            // sets a new upper left block point.
            Point upperLeft = new Point(point.getX(), point.getY());
            Block block = new Block(upperLeft, GameLevel.BLOCK_WIDTH, GameLevel.BLOCK_HEIGHT);
            block.setColor(color);
            // sets new x to the next block.
            point.setX(point.getX() - GameLevel.BLOCK_WIDTH);
            blocks.add(block);
        }
    }

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
        velocities.add(Velocity.fromAngleAndSpeed(330, BALL_SPEED));
        velocities.add(Velocity.fromAngleAndSpeed(30, BALL_SPEED));
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
        return "Green 3";
    }

    /**
     * @return the levels' background.
     */
    @Override
    public Sprite getBackground() {
        return new Green3Background();
    }

    /**
     * create a list of the blocks in the level.
     *
     * @return a list of the blocks in the game
     */
    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Color[] colors = {Color.gray, Color.red, Color.yellow, Color.blue, Color.pink, Color.green};
        for (int i = 0; i < colors.length; i++) {
            Point p = new Point(GameLevel.FRAME_WIDTH - (GameLevel.BLOCK_HEIGHT + GameLevel.BLOCK_WIDTH),
                    BLOCKS_START + GameLevel.BLOCK_HEIGHT * i);
            addBlocksByPoint(p, QUANTITY - i, colors[i], blocks);
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
