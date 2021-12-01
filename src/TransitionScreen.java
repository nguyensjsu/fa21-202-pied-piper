import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.*;

/**
 * Write a description of class TransitionScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TransitionScreen extends Actor
{
    int counter;
    GreenfootImage alias;
    public TransitionScreen(String alias, int playerscore)
    {
        this.alias = new GreenfootImage("Alias: " + alias + "\nScore: " + String.valueOf(playerscore), 36, Color.CYAN, null, Color.WHITE);
    }
    /**
     * Act - do whatever the TransitionScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        switch (this.counter) {
            case 16: {
                this.setImage(this.alias);
                this.counter = -1;
                break;
            }
        }
        final int t = this.getImage().getTransparency();
        if (t > 1) {
            this.getImage().setTransparency(t - 5);
        }
        else {
            this.alias = null;
            this.getWorld().removeObject((Actor)this);
        }
        ++this.counter;
    }
}
