import greenfoot.Greenfoot;
import greenfoot.GreenfootSound;
import greenfoot.GreenfootImage;
import greenfoot.World;
import greenfoot.Actor;
import greenfoot.Color;

public class ScoreObserver extends Actor implements IObserver {

    protected int score;
    private GameWorld subject;

    public ScoreObserver(GameWorld subject, int score) {
        this.subject = subject;
        this.score = score;
    }

    public void update() {
        this.score = this.subject.getScore();
        this.showState(true);
    }

    public void update(int num) {
        // empty
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