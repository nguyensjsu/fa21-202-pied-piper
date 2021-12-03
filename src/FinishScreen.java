import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FinishScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinishScreen extends Actor
{
    GreenfootImage i;
    int counter;
    
    public FinishScreen() {
        this.i = new GreenfootImage("finishscreen.png");
        this.counter = 0;
    }
    
    public void act() {
        switch (this.counter) {
            case 16: {
                this.getImage().drawImage(this.i, 0, 0);
                this.counter = -1;
                break;
            }
        }
        final int t = this.getImage().getTransparency();
        if (t > 1) {
            this.getImage().setTransparency(t - 1);
        }
        else {
            this.i = null;
            this.getWorld().removeObject((Actor)this);
        }
        ++this.counter;
    }
}
