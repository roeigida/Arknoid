import biuoop.DrawSurface;

import java.awt.Color;

/**
 * class implements sprite methods.
 * the class used as the background of Green 3 level
 */
public class Green3Background implements Sprite {

    /**
     * @return the color of the background.
     */
    public Color getColor() {
        return new Color(14, 17, 72);
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
        d.setColor(Color.BLACK);
        d.fillRectangle(65, 450, 100, 200);
        int startX = 75;
        int startY = 460;
        d.setColor(Color.WHITE);
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (i * j % 3 == 0 && i != 0 && j != 0) {
                    d.setColor(Color.yellow);
                } else {
                    d.setColor(Color.WHITE);
                }
                d.fillRectangle(startX + j * 18, startY + i * 32, 10, 25);
            }
        }

        d.setColor(new Color(63, 23, 24));
        d.fillRectangle(490, 260, 100, 400);
        startX = 500;
        startY = 280;
        d.setColor(Color.WHITE);
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (i * j % 9 == 0 && i != 0 && j != 0) {
                    d.setColor(Color.yellow);
                } else {
                    d.setColor(Color.WHITE);
                }
                d.fillRectangle(startX + j * 18, startY + i * 32, 10, 25);
            }
        }

        d.setColor(new Color(106, 106, 115));
        d.fillRectangle(290, 300, 100, 400);
        startX = 300;
        startY = 310;
        d.setColor(Color.WHITE);
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 5; ++j) {
                if (i * j % 6 == 0 && i != 0 && j != 0) {
                    d.setColor(Color.yellow);
                } else {
                    d.setColor(Color.WHITE);
                }
                d.fillRectangle(startX + j * 18, startY + i * 32, 10, 25);
            }
        }
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
