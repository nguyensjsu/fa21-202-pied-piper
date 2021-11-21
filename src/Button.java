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
public class Button extends Actor
{
    private GameWorld gw;
    int val;
    String soundtype;
    public Button(String imagefilename, GameWorld gw, String soundtype, int val)
    {
        setImage(new GreenfootImage(imagefilename));
        this.gw = gw;
        this.val = val;
        this.soundtype = soundtype;
    }
    
    public Button(GreenfootImage textlabel)
    {
        setImage(textlabel);
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this)){
            if(soundtype == "bgmusic"){
                gw.bgmusic += val;
                gw.bgmusic = gw.bgmusic > 100 ? 100 : (Math.max(gw.bgmusic, 0));
                (gw.introMusic).setVolume(gw.bgmusic);
            }
            else if(soundtype == "soundeffects"){
                gw.soundeffects += val;
                gw.soundeffects = gw.soundeffects > 100 ? 100 : (Math.max(gw.soundeffects, 0));
                (gw.gameMusic).setVolume(gw.soundeffects);
            }
        }
    }
}
