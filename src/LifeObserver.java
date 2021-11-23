import greenfoot.Greenfoot;
import greenfoot.GreenfootSound;
import greenfoot.GreenfootImage;
import greenfoot.World;
import greenfoot.Actor;
import greenfoot.Color;

public class LifeObserver extends Actor implements IObserver {

    protected int lives;

    public LifeObserver(int lives ) {
        this.lives = lives;
    }

    public void update() {
        // Empty
    }

    public void update(int num) {
        this.lives = num;
        this.showState(true);
    }

    public void showState(final boolean b) {
        if (b) {
            this.setImage(
                    new GreenfootImage(
                            "LIVES: " + this.lives, 25,
                            Color.ORANGE, null, Color.WHITE));
        }
        else {
            this.setImage("empty.png");
        }
    }

}