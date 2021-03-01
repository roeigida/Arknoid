import java.util.List;

/**
 * A necessary information to create and draw a new level.
 */
public interface LevelInformation {

    /**
     * @return the number of balls in the level.
     */
    int numberOfBalls();


    /**
     * @return a list of velocities of each ball.
     * The initial velocity of each ball
     * Note that initialBallVelocities().size() == numberOfBalls()
     */
    List<Velocity> initialBallVelocities();

    /**
     * @return the paddles' speed.
     */
    int paddleSpeed();

    /**
     * @return the paddles' width.
     */
    int paddleWidth();

    /**
     * @return the levels' name;
     */
    String levelName();

    /**
     * @return a sprite with the background of the level
     */
    Sprite getBackground();

    /**
     * @return a list of The Blocks that make up this level, each block contains
     * its size, color and location.
     */
    List<Block> blocks();

    /**
     * @return the Number of blocks that should be removed
     */
    int numberOfBlocksToRemove();
}