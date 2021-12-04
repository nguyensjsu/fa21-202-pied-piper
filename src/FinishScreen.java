import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FinishScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinishScreen extends Actor
{
    private static final String FINISH_SCREEN_IMG = "finishscreen.png";
    private GreenfootImage img;
    private int counter;
    
    public FinishScreen() {
        this.img = new GreenfootImage(FINISH_SCREEN_IMG);
        this.counter = 0;
    }
    
    public void act() {
        switch (this.counter) {
            case 16: {
                this.getImage().drawImage(this.img, 0, 0);
                this.counter = -1;
                break;
            }
        }
        final int t = this.getImage().getTransparency();
        if (t > 1) {
            this.getImage().setTransparency(t - 1);
        }
        else {
            this.img = null;
            this.getWorld().removeObject((Actor)this);
        }
        ++this.counter;
    }
}
