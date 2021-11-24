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
    GreenfootImage alias;
    public TransitionScreen(String playeralias, int playerscore)
    {
        this.setImage(new GreenfootImage("Alias: " + playeralias + "\nScore: " + String.valueOf(playerscore), 36, Color.CYAN, null, Color.WHITE));
    }
    /**
     * Act - do whatever the TransitionScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
}
