import biuoop.DrawSurface;

import java.awt.Color;

/**
 * class implements sprite methods.
 * the class used as the background of Final Four level
 */
public class FinalFourBackground implements Sprite {
    /**
     * @return the color of the background.
     */
    public Color getColor() {
        return new Color(3, 0, 130);
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
        for (int i = 0; i < 28; i++) {
            d.setColor(Color.LIGHT_GRAY);
            d.fillCircle(20 + i * 30, 60, 30);
            if (i % 3 == 0) {
                d.setColor(Color.black);
                d.drawCircle(20 + i * 30, 60, 30);
            }
        }
        d.setColor(new Color(111, 37, 0));
        d.fillRectangle(0, 500, 800, 100);
        d.setColor(new Color(16, 146, 0));
        d.fillRectangle(0, 500, 800, 20);
        d.setColor(new Color(230, 238, 222));
        d.fillRectangle(0, 500, 800, 5);
        d.setColor(Color.white);
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

