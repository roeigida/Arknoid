//ID: 322225897.

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * rectangular paddle that moves on the screen by given keyboard keys.
 * class supports getters, setters draw, move left / right, time passed, get collision rectangle, hit and add to game.
 * implemented by keyboard sensor, the upper-left point of the rectangle made of and color.
 */
public class Paddle implements Sprite, Collidable {
    private static final int PADDLE_HEIGHT = 10;
    private biuoop.KeyboardSensor keyboard;
    private Point upperLeft;
    private Color color;
    private int paddleWidth;
    private double paddleSpeed;

    /**
     * constructor.
     *
     * @param paddleSp  paddle speed.
     * @param paddleWid paddle width.
     */
    public Paddle(int paddleWid, double paddleSp) {
        this.keyboard = null;
        this.upperLeft = new Point(GameLevel.FRAME_WIDTH / 2 - paddleWid / 2,
                GameLevel.FRAME_HEIGHT - GameLevel.BLOCK_HEIGHT);
        // a default color.
        this.color = Color.ORANGE;
        this.paddleWidth = paddleWid;
        this.paddleSpeed = paddleSp;
    }

    /**
     * sets a keyboard sensor.
     *
     * @param keyboard1 keyboard sensor.
     */
    public void setKeyboard(KeyboardSensor keyboard1) {
        this.keyboard = keyboard1;
    }

    /**
     * @return the paddles' color.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * sets the paddles color.
     *
     * @param c the color.
     */
    public void setColor(Color c) {
        this.color = c;
    }

    /**
     * @return point - the upper left point of the paddle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * sets a new upper left point to the peddle.
     *
     * @param upperLeftPoint a new upper left point.
     */
    public void setUpperLeft(Point upperLeftPoint) {
        this.upperLeft = upperLeftPoint;
    }

    /**
     * moves the current upper left point of the paddle "VELOCITY" units left.
     */
    public void moveLeft() {
        if (upperLeft.getX() > GameLevel.BLOCK_HEIGHT) {
            if (upperLeft.getX() - paddleSpeed < GameLevel.BLOCK_HEIGHT) {
                upperLeft.setX(GameLevel.BLOCK_HEIGHT);
                return;
            }
            this.upperLeft.setX(getUpperLeft().getX() - paddleSpeed);
        }
    }

    /**
     * moves the current upper left point of the paddle "VELOCITY" units left.
     */
    public void moveRight() {
        if (upperLeft.getX() < GameLevel.FRAME_WIDTH - (paddleWidth + GameLevel.BLOCK_HEIGHT)) {
            if (getUpperLeft().getX() > GameLevel.FRAME_WIDTH - (GameLevel.BLOCK_HEIGHT + paddleWidth + paddleSpeed)) {
                upperLeft.setX(GameLevel.FRAME_WIDTH - (paddleWidth + GameLevel.BLOCK_HEIGHT));
                return;
            }
            this.upperLeft.setX(getUpperLeft().getX() + paddleSpeed);
        }
    }

    /**
     * tells the paddle where to move according the key pressed.
     */
    @Override
    public void timePassed() {

        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        }
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * draws the paddle on the given draw surface.
     *
     * @param d a draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(getColor());
        d.fillRectangle((int) getUpperLeft().getX(), (int) getUpperLeft().getY(), paddleWidth, PADDLE_HEIGHT);
        d.setColor(Color.BLACK);
        d.drawRectangle((int) getUpperLeft().getX(), (int) getUpperLeft().getY(), paddleWidth, PADDLE_HEIGHT);

    }

    /**
     * creates and return the paddles' rectangle shape.
     *
     * @return the paddles' rectangle shape.
     */
    @Override

    public Rectangle getCollisionRectangle() {
        Rectangle collRec = new Rectangle(getUpperLeft(), paddleWidth, PADDLE_HEIGHT);
        return collRec;
    }

    /**
     * separate the paddle to five parts and calculate the velocity according to the hitting point.
     *
     * @param collisionPoint  the collision point on the paddle.
     * @param currentVelocity the current balls' velocity.
     * @param ball            the ball that hit the paddle.
     * @return the new velocity.
     */
    @Override
    public Velocity hit(Ball ball, Point collisionPoint, Velocity currentVelocity) {
        double fifth = paddleWidth / 5;
        Velocity v = currentVelocity;
        // if hit in the left most part
        if (getUpperLeft().getX() <= collisionPoint.getX()
                && collisionPoint.getX() < getUpperLeft().getX() + fifth) {
            v = Velocity.fromAngleAndSpeed(300, currentVelocity.getVelocityVectorLength());
        }
        // if hit the middle left part
        if (getUpperLeft().getX() + fifth <= collisionPoint.getX()
                && collisionPoint.getX() < getUpperLeft().getX() + fifth * 2) {
            v = Velocity.fromAngleAndSpeed(330, currentVelocity.getVelocityVectorLength());
        }
        // if hit the middle part
        if (getUpperLeft().getX() + fifth * 2 <= collisionPoint.getX()
                && collisionPoint.getX() < getUpperLeft().getX() + fifth * 3) {
            currentVelocity.setDy(-currentVelocity.getDyVelocity());
            return currentVelocity;
        }
        //if hit the middle right part
        if (getUpperLeft().getX() + fifth * 3 <= collisionPoint.getX()
                && collisionPoint.getX() < getUpperLeft().getX() + fifth * 4) {
            v = Velocity.fromAngleAndSpeed(30, currentVelocity.getVelocityVectorLength());
        }
        // if hit the right most part
        if (getUpperLeft().getX() + fifth * 4 <= collisionPoint.getX()
                && collisionPoint.getX() <= getUpperLeft().getX() + fifth * 5) {
            v = Velocity.fromAngleAndSpeed(60, currentVelocity.getVelocityVectorLength());
        }
        return v;
    }

    /**
     * Add this paddle to the game.
     *
     * @param g a given game.
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
}
