//ID: 322225897.

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * collection of sprites.
 * implemented by an array list of sprites.
 * supports adding sprite,notify the sprites int the sprite collection that the time passed and draw all.
 */
public class SpriteCollection {
    private List<Sprite> spriteCollection;

    /**
     * constructor.
     * creating new array list of sprites.
     */
    public SpriteCollection() {
        this.spriteCollection = new ArrayList<Sprite>();
    }

    /**
     * adding sprite object to the sprite collection.
     *
     * @param s a sprite object.
     */
    public void addSprite(Sprite s) {
        this.spriteCollection.add(s);
    }

    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spColl = new ArrayList<>(this.spriteCollection);
        for (Sprite sprite : spColl) {
            sprite.timePassed();
        }
    }

    /**
     * remove a given sprite from the sprite collection.
     *
     * @param s the sprite that will be remove from the collection.
     */
    public void removeSprite(Sprite s) {
        this.spriteCollection.remove(s);
    }

    /**
     * call drawOn(d) on all sprites.
     *
     * @param d a draw surface.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite sprite : this.spriteCollection) {
            sprite.drawOn(d);
        }
    }
}
