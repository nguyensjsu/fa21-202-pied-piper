import greenfoot.Greenfoot;
import greenfoot.GreenfootSound;
import greenfoot.GreenfootImage;
import greenfoot.World;
import greenfoot.Actor;
import greenfoot.Color;

public class LifeObserver extends Actor implements IObserver {

    protected int lives;
    private GameWorld subject;

    public LifeObserver(GameWorld subject, int lives ) {
        this.subject = subject;
        this.lives = lives;
    }

    public void update() {
        this.lives = this.subject.getLives();
        this.showState(true);
    }

    public void update(int num) {
        // empty
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