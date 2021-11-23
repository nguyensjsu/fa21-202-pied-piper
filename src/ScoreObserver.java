import greenfoot.Greenfoot;
import greenfoot.GreenfootSound;
import greenfoot.GreenfootImage;
import greenfoot.World;
import greenfoot.Actor;
import greenfoot.Color;

public class ScoreObserver extends Actor implements IObserver {

    protected int score;

    public ScoreObserver(int score) {
        this.score = score;
    }

    public void update() {
        // Empty
    }

    public void update(int num) {
        this.score = num;
        this.showState(true);
    }

    public void showState(final boolean b) {
        if (b) {
            this.setImage(
                    new GreenfootImage(
                            "SCORE: " + this.score, 25,
                            Color.ORANGE, null, Color.WHITE));
        }
        else {
            this.setImage("empty.png");
        }
    }

}