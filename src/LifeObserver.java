import greenfoot.Greenfoot;
import greenfoot.GreenfootSound;
import greenfoot.GreenfootImage;
import greenfoot.Actor;
import greenfoot.Color;

public class LifeObserver extends Actor implements IObserver {

    private String display;
    protected int lives;
    protected Player subject;

    public LifeObserver( Player theSubject, int lives ) {
        this.lives = lives;
        this.subject = theSubject ;
        this.display = "LIVES: " + this.lives ;
    }

    public void update() {
        this.showState(false);
        this.lives--;
        this.display = "LIVES: " + this.lives ;
        this.showState(true);
    }

    public void showState(final boolean b) {
        if (b) {
            this.setImage(
                    new GreenfootImage(
                            this.display, 25,
                            Color.ORANGE, null, Color.WHITE));
        }
        else {
            this.setImage("empty.png");
        }
    }

}