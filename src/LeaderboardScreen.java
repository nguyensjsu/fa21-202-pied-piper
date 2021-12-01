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
    //LinkedHashMap<String, String> leaderBoard = new LinkedHashMap();
    LeaderBoardIterator iter;
    int counter;
    int count;
    String str;
    
    public LeaderboardScreen(LeaderBoardIterator l) {
        this.iter = l;
        this.count = 0;
        this.counter = 0;
        this.showLeaderBoard();
    }

    public void showLeaderBoard() {
        str = "LEADERBOARD\n\n";
        while (iter.hasMore() == true) {
            if(this.count == 10){
                break;
            }
            str = str + String.valueOf(this.count + 1) + iter.nextItem() + "\n";
            this.count++;
        }
        for(int i = this.count; i < 10; i++)
        {
            str = str + String.valueOf(i + 1) + ". Score: 0\t\tAlias: AAA" + "\n";
        }
        str = str + "\nPress ESC to Restart the game";
        this.background = new GreenfootImage(str, 25, Color.CYAN, null, Color.WHITE);
        //this.background = new GreenfootImage("leaderboardscreen");
    }
    /**
     * Act - do whatever the LeaderboardScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        switch (this.counter) {
            case 50: {
                this.setImage(this.background);
                this.counter = -1;
                break;
            }
        }
        ++this.counter;
    }
}
