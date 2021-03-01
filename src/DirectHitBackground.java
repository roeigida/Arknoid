import biuoop.DrawSurface;

import java.awt.Color;

/**
 * class implements sprite methods.
 * the class used as the background of Direct Hit level
 */
public class DirectHitBackground implements Sprite {

    /**
     * @return the color of the background.
     */
    public Color getColor() {
        return Color.BLACK;
    }

    /**
     * draws the background.
     *
     * @param d a draw surface
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(getColor());
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.green);
        d.fillCircle(GameLevel.FRAME_WIDTH / 2 - GameLevel.BLOCK_WIDTH / 2 + 20, GameLevel.FRAME_HEIGHT / 4 + 7, 65);
        d.setColor(Color.black);
        d.fillCircle(GameLevel.FRAME_WIDTH / 2 - GameLevel.BLOCK_WIDTH / 2 + 20, GameLevel.FRAME_HEIGHT / 4 + 7, 60);
        d.setColor(Color.green);
        d.fillCircle(GameLevel.FRAME_WIDTH / 2 - GameLevel.BLOCK_WIDTH / 2 + 20, GameLevel.FRAME_HEIGHT / 4 + 7, 50);
        d.setColor(Color.black);
        d.fillCircle(GameLevel.FRAME_WIDTH / 2 - GameLevel.BLOCK_WIDTH / 2 + 20, GameLevel.FRAME_HEIGHT / 4 + 7, 45);
        d.setColor(Color.green);
        d.fillCircle(GameLevel.FRAME_WIDTH / 2 - GameLevel.BLOCK_WIDTH / 2 + 20, GameLevel.FRAME_HEIGHT / 4 + 7, 35);
        d.setColor(Color.black);
        d.fillCircle(GameLevel.FRAME_WIDTH / 2 - GameLevel.BLOCK_WIDTH / 2 + 20, GameLevel.FRAME_HEIGHT / 4 + 7, 30);
        d.setColor(Color.green);
        d.drawLine(GameLevel.FRAME_WIDTH / 2 - GameLevel.BLOCK_WIDTH / 2 - 100, GameLevel.FRAME_HEIGHT / 4 + 7,
                GameLevel.FRAME_WIDTH / 2 - GameLevel.BLOCK_WIDTH / 2 + 140, GameLevel.FRAME_HEIGHT / 4 + 7);
        d.drawLine(GameLevel.FRAME_WIDTH / 2 - GameLevel.BLOCK_WIDTH / 2 + 20, GameLevel.FRAME_HEIGHT / 4 - 100,
                GameLevel.FRAME_WIDTH / 2 - GameLevel.BLOCK_WIDTH / 2 + 20, GameLevel.FRAME_HEIGHT / 4 + 120);
    }

    /**
     * notify the time passed.
     */
    @Override
    public void timePassed() {
    }

    /**
     * add the background as sprite to the game.
     *
     * @param g add the background to this parameter (game).
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
