//ID: 322225897.

import biuoop.DrawSurface;

/**
 * Sprites can be drawn on the screen, and can be notified that time has passed.
 * (so that they know to change their position / shape / appearance / etc). moreover, add it to a game.
 */
public interface Sprite {
    /**
     * draw the sprite to the screen.
     *
     * @param d a draw surface.
     */
    void drawOn(DrawSurface d);

    /**
     * notify the sprite that time has passed.
     */
    void timePassed();

    /**
     * add the ball to the game.
     *
     * @param g a game.
     */
    void addToGame(GameLevel g);
}