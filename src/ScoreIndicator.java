//ID: 322225897.

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * counts the score and drawn as a rectangle with the score in it.
 * implemented by a counter and a rectangle.
 * support rectangle getter,constructor, draw on, time passed and add to game method.
 */
public class ScoreIndicator implements Sprite {
    private static final int FIX = 2;
    private static final int TEXT_PLACE = 350;

    private Counter score;
    private Rectangle rectangle;
    private String levelName;

    /**
     * constructor.
     *
     * @param counter a score counter.
     * @param rect    a "board" that the score will be drawn on.
     * @param ln      level name.
     */
    public ScoreIndicator(Counter counter, Rectangle rect, String ln) {
        this.score = counter;
        this.rectangle = rect;
        this.levelName = ln;
    }

    /**
     * gets the score rectangle.
     *
     * @return the score rectangle.
     */
    public Rectangle getRectangle() {
        return rectangle;
    }

    /**
     * draw the score rectangle and the score number.
     *
     * @param d the draw surface
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.lightGray);
        d.fillRectangle((int) getRectangle().getUpperLeft().getX(), (int) getRectangle().getUpperLeft().getY(),
                (int) getRectangle().getWidth(), (int) getRectangle().getHeight());
        d.setColor(Color.BLACK);
        d.drawRectangle((int) getRectangle().getUpperLeft().getX(), (int) getRectangle().getUpperLeft().getY(),
                (int) getRectangle().getWidth(), (int) getRectangle().getHeight());
        d.drawText(TEXT_PLACE, (int) rectangle.getUpperLeft().getY() + (int) rectangle.getHeight() - FIX,
                "score: " + score.getValue(), (int) rectangle.getHeight());
        d.drawText(50, (int) rectangle.getUpperLeft().getY() + (int) rectangle.getHeight() - FIX,
                "Level Name: " + this.levelName, (int) rectangle.getHeight());


    }

    /**
     * what the ScoreIndicator do when a time passed on the game loop.
     */
    @Override
    public void timePassed() {
    }

    /**
     * add this Score indicator to the game.
     *
     * @param g the game that the score indicator object will be added to.
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
