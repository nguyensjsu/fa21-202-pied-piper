import greenfoot.Greenfoot;
import greenfoot.GreenfootSound;
import greenfoot.GreenfootImage;
import greenfoot.Actor;
import greenfoot.Color;

public class LifeObserver extends Actor implements IObserver {

    GreenfootImage img;
    private String display;
    protected int lives;
    protected Player subject;

    public LifeObserver( Player theSubject, int lives ) {
        this.lives = lives;
        this.subject = theSubject ;
        this.display = "LIVES: " + this.lives ;

        this.img = new GreenfootImage(100, 30);
        this.img.setColor(Color.ORANGE);
        this.img.drawString(this.display, 2, 20);
    }

    public void update() {
        this.showState(false);
        this.lives--;
        this.display = "LIVES: " + this.lives ;
        this.img.clear();
        this.img.drawString(this.display, 2, 20);
        this.showState(true);
    }

    public void showState(final boolean b) {
        if (b) {
            this.setImage(this.img);
        }
        else {
            this.setImage("empty.png");
        }
    }

}