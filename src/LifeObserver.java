import greenfoot.Greenfoot;
import greenfoot.GreenfootSound;
import greenfoot.GreenfootImage;
import greenfoot.Actor;
import greenfoot.Color;

public class LifeObserver extends Actor implements IObserver {

    protected int lives;
    protected Player subject; // not really in use at the moment

    public LifeObserver( Player theSubject, int lives ) {
        this.lives = lives;
        this.subject = theSubject ;
    }

    public void update() {
        this.showState(false);
        this.lives--;
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