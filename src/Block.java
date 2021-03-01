// ID: 322225897.

import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * rectangular Block in the game.
 * class support getters setters and implements collidables', sprites' methods and HitNotifier methods.
 * implemented by upper left point, width, height and color.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private List<HitListener> hitListeners = new ArrayList<>();
    private Point upperLeft;
    private double width;
    private double height;
    private Color color;

    /**
     * constructor.
     *
     * @param upperLeft upper left point of the block.
     * @param width     the blocks' width.
     * @param height    the blocks' height.
     */
    public Block(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        //default color
        this.color = Color.GRAY;
    }

    /**
     * @return the blocks' height.
     */
    public double getHeight() {
        return height;
    }

    /**
     * @return the blocks' width.
     */
    public double getWidth() {
        return width;
    }

    /**
     * @return the blocks' upper left point.
     */
    public Point getUpperLeft() {
        return upperLeft;
    }

    /**
     * sets the blocks' color.
     *
     * @param c a given color
     */
    public void setColor(Color c) {
        this.color = c;
    }

    /**
     * @return the blocks' color.
     */
    public Color getColor() {
        return color;
    }

    /**
     * @return the rectangle that the block made of.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        Rectangle rect = new Rectangle(upperLeft, this.width, this.height);
        return rect;
    }

    /**
     * the method change the given velocity according to where it hit the block.
     *
     * @param collisionPoint  a point on the block.
     * @param currentVelocity the current velocity of the ball.
     * @param hitter          the ball which hit the block.
     * @return a new velocity.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity newVelocity = currentVelocity;
        // there is no collision point
        if (collisionPoint == null) {
            return currentVelocity;
        }
        // notifies that a hit occurred.
        notifyHit(hitter);
        // calculates the four points of the block.
        Point upperLeftPoint = this.upperLeft;
        Point upperRight = new Point(getUpperLeft().getX() + getWidth(),
                getUpperLeft().getY());
        Point lowerRight = new Point(getUpperLeft().getX() + getWidth(),
                getUpperLeft().getY() + getHeight());
        Point lowerLeft = new Point(getUpperLeft().getX(),
                getUpperLeft().getY() + getHeight());
        // checks if the collision point is on edges.
        if (collisionPoint.equals(upperLeftPoint) || collisionPoint.equals(lowerLeft)
                || collisionPoint.equals(upperRight) || collisionPoint.equals(lowerRight)) {
            newVelocity.setDx(-newVelocity.getDxVelocity());
            newVelocity.setDy(-newVelocity.getDyVelocity());
            return newVelocity;
        }
        //checks if the collision is on the vertical sides.
        if ((collisionPoint.getY() > upperLeftPoint.getY() && collisionPoint.getY() < lowerLeft.getY())) {
            newVelocity.setDx(-newVelocity.getDxVelocity());
        }
        // checks if the collision is on the horizontal sides.
        if ((collisionPoint.getX() > upperLeftPoint.getX() && collisionPoint.getX() < upperRight.getX())) {
            newVelocity.setDy(-newVelocity.getDyVelocity());
        }
        return newVelocity;
    }

    /**
     * notify all the listeners that the block has been hit.
     *
     * @param hitter the hitter ball.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event.
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * draws the block in the draw surface.
     *
     * @param d a given draw surface.
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(getColor());
        d.fillRectangle((int) this.upperLeft.getX(), (int) this.upperLeft.getY(), (int) this.width, (int) this.height);
        d.setColor(Color.BLACK);
        d.drawRectangle((int) this.upperLeft.getX(), (int) this.upperLeft.getY(), (int) this.width, (int) this.height);
    }

    /**
     * what the block do when a time passed on the game loop.
     */
    @Override
    public void timePassed() {

    }

    /**
     * remove the current block from the game.
     *
     * @param game the game the block will be removed from.
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    /**
     * adds the block to the game.
     *
     * @param g a game.
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }
}
