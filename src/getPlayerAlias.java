import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class getPlayerAlias here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class getPlayerAlias
{
    String alias;
    /**
     * Act - do whatever the getPlayerAlias wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void getalias()
    {
        this.alias = Greenfoot.ask("Please enter your Player Alias for the LEADERBOARD!!");
    }
}
