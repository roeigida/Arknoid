//ID: 322225897.

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * game initialization and run.
 * class support adding a collidable and sprite objects to the game, initialize and run methods.
 * implemented by a sprite collection, game environment and GUI.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private biuoop.KeyboardSensor keyboard;
    private Counter blockCounter;
    private Counter ballCounter;
    private Counter scoreCounter;
    private AnimationRunner runner;
    private boolean running;
    private LevelInformation levelInfo;

    public static final int FRAME_WIDTH = 800;
    public static final int FRAME_HEIGHT = 600;
    public static final int BLOCK_HEIGHT = 20;
    public static final int BLOCK_WIDTH = 40;
    public static final int SCORE_BLOCK_HEIGHT = 15;
    private static final int RED = 31;
    private static final int GREEN = 0;
    private static final int BLUE = 131;
    private static final int RADIUS = 4;
    private static final int BALLS_START_HEIGHT = 550;
    private static final int BONUS = 100;

    /**
     * constructor.
     *
     * @param ar               animation runner.
     * @param kbs              keyboard sensor.
     * @param levelInformation level information.
     * @param score            the score.
     */
    public GameLevel(LevelInformation levelInformation, KeyboardSensor kbs, AnimationRunner ar, int score) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.blockCounter = new Counter(0);
        this.ballCounter = new Counter(0);
        this.scoreCounter = new Counter(score);
        this.keyboard = kbs;
        this.runner = ar;
        this.levelInfo = levelInformation;
    }

    /**
     * add a collidable object to the game.
     *
     * @param c a collidable object.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * gets the block counter.
     *
     * @return the block counter.
     */
    public Counter getBlockCounter() {
        return blockCounter;
    }

    /**
     * gets the ball counter.
     *
     * @return the ball counter
     */
    public Counter getBallCounter() {
        return ballCounter;
    }

    /**
     * gets the score counter.
     *
     * @return the score counter.
     */
    public Counter getScoreCounter() {
        return scoreCounter;
    }

    /**
     * add sprite object to the game.
     *
     * @param s a sprite object.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle) and add them to the game.
     */
    public void initialize() {

        ScoreTrackingListener stl = new ScoreTrackingListener(scoreCounter);
        BlockRemover blockRemover = new BlockRemover(this, getBlockCounter());
        BallRemover ballRemover = new BallRemover(this, getBallCounter());
        // create big block - background.
        Block backGround = new Block(new Point(0, 0), FRAME_WIDTH, FRAME_HEIGHT);
        backGround.setColor(new Color(RED, GREEN, BLUE));
        backGround.addHitListener(ballRemover);
        backGround.addToGame(this);
        this.levelInfo.getBackground().addToGame(this);
        //create the frame
        addFrame();
        Rectangle scoreRec = new Rectangle(new Point(0, 0), FRAME_WIDTH, SCORE_BLOCK_HEIGHT);
        ScoreIndicator scoreIndicator = new ScoreIndicator(getScoreCounter(), scoreRec, levelInfo.levelName());
        scoreIndicator.addToGame(this);
        // create paddle
        Paddle paddle = new Paddle(this.levelInfo.paddleWidth(), this.levelInfo.paddleSpeed());
        paddle.setKeyboard(this.keyboard);
        paddle.addToGame(this);
        for (Block b : this.levelInfo.blocks()) {
            b.addHitListener(blockRemover);
            b.addHitListener(stl);
            this.blockCounter.increase(1);
            b.addToGame(this);
        }
        // creates balls to the current game.
        Point p = new Point(FRAME_WIDTH / 2, BALLS_START_HEIGHT);
        int ballsAdded = 0;
        for (Velocity v : this.levelInfo.initialBallVelocities()) {
            Ball b = new Ball(p, RADIUS, Color.WHITE, this.environment);
            b.setVelocity(v);
            b.addToGame(this);
            ballsAdded++;
        }
        this.ballCounter.increase(ballsAdded);
    }


    /**
     * add the frame to the game.
     */
    public void addFrame() {
        Block upperFrame = new Block(new Point(0, SCORE_BLOCK_HEIGHT), FRAME_WIDTH, BLOCK_HEIGHT);
        upperFrame.addToGame(this);
        Block leftFrame = new Block(new Point(0, BLOCK_HEIGHT + SCORE_BLOCK_HEIGHT),
                BLOCK_HEIGHT, FRAME_HEIGHT - BLOCK_HEIGHT - SCORE_BLOCK_HEIGHT);
        leftFrame.addToGame(this);
        Block rightFrame = new Block(new Point(FRAME_WIDTH - BLOCK_HEIGHT, BLOCK_HEIGHT + SCORE_BLOCK_HEIGHT)
                , BLOCK_HEIGHT, FRAME_HEIGHT - BLOCK_HEIGHT - SCORE_BLOCK_HEIGHT);
        rightFrame.addToGame(this);
    }

    /**
     * Remove a given collidable from the game environment.
     *
     * @param c the collidable that will remove from the game environment.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * remove a given sprite from the sprite collection.
     *
     * @param s the sprite that will remove from the sprite collection.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }


    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                    new PauseScreen(this.keyboard, this.sprites)));
        }
        // check if there are balls in the game.
        if (ballCounter.getValue() == 0) {
            this.running = false;
        }
        //check if there are no more blocks to add the bonus to the score.
        if (blockCounter.getValue() == 0) {
            this.scoreCounter.increase(BONUS);
            this.running = false;
        }
        // notify the objects that the time past and the need to do what they should.
        this.sprites.notifyAllTimePassed();
        //draw all the sprites objects in the game.
        this.sprites.drawAllOn(d);

    }

    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        initialize();
        this.running = true;
        this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.runner.run(this);

    }
}
