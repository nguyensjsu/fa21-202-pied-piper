import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class LeaderboardScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LeaderboardScreen extends Actor
{
    GreenfootImage background;
    int counter;
    public LeaderboardScreen(List<List<String>> Leaderboard)
    {
        this.background = new GreenfootImage("leaderboardscreen.png");
    }
    /**
     * Act - do whatever the LeaderboardScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        switch (this.counter) {
            case 300:{
                this.setImage(this.background);
                break;
            }
        }++this.counter;
    }
}
