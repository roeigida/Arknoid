import biuoop.DrawSurface;

import java.awt.Color;

/**
 * class implements sprite methods.
 * the class used as the background of Wide Easy level
 */
public class WideEasyBackground implements Sprite {

    /**
     * @return the color of the background.
     */
    public Color getColor() {
        return new Color(0, 5, 47);
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
        d.setColor(new Color(229, 255, 200));
        d.fillCircle(50, 60, 40);
        d.setColor(new Color(238, 231, 226));
        d.fillCircle(40, 40, 5);
        d.fillCircle(60, 80, 3);
        d.fillCircle(70, 50, 4);
        d.fillCircle(300, 100, 2);
        d.fillCircle(200, 80, 3);
        d.fillCircle(640, 150, 2);
        d.fillCircle(130, 70, 2);
        d.fillCircle(40, 187, 2);
        d.fillCircle(86, 172, 2);
        d.fillCircle(589, 163, 2);
        d.fillCircle(424, 80, 2);
        d.fillCircle(238, 210, 3);
        d.fillCircle(354, 120, 2);
        d.fillCircle(643, 60, 2);
        d.fillCircle(400, 150, 3);
        d.fillCircle(330, 140, 2);
        d.fillCircle(224, 117, 2);
        d.fillCircle(531, 48, 1);
        d.fillCircle(142, 163, 2);
        d.fillCircle(700, 80, 2);
        d.fillCircle(740, 210, 1);
        d.setColor(new Color(154, 34, 0));
        d.fillCircle(500, 200, 20);
        d.setColor(new Color(116, 26, 0));
        d.fillCircle(490, 200, 3);
        d.fillCircle(500, 195, 4);
        d.fillCircle(505, 210, 5);
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
