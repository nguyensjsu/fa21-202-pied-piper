import greenfoot.*;
import greenfoot.Actor;
import greenfoot.GreenfootImage;
import java.util.List;
import java.util.Collection;

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Label extends Actor
{
    private GameWorld gw;
    int val;
    String sounddirection;
    DeviceButton dbutton;
    bgMusic tempbg;
    soundEffects tempse;
    
    public Label(String imagefilename, GameWorld gw, String soundDirection, Command onCommand)
    {
        dbutton = new DeviceButton(onCommand);
        setImage(new GreenfootImage(imagefilename));
        this.gw = gw;
        this.sounddirection = soundDirection;
    }
    
    public Label(String str, int temp)
    {
        if(str == "bg")
        {
            GreenfootImage textlabel = new GreenfootImage(String.valueOf(temp), 25, Color.WHITE, null, Color.WHITE);
            setImage(textlabel);
        }
        else
        {
            GreenfootImage textlabel = new GreenfootImage(String.valueOf(temp), 25, Color.WHITE, null, Color.WHITE);
            setImage(textlabel);
        }
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this)){
            if(sounddirection == "up"){
                dbutton.press();
            }
            else if(sounddirection == "down"){
                dbutton.undo();
            }
        }
    }
}
