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
    GreenfootImage i;
    private GameWorld gw;
    int val;
    String soundtype;
    public Button(String image, GameWorld gw, String soundtype, int val)
    {
        setImage(new GreenfootImage(image));
        this.gw = gw;
        this.val = val;
        this.soundtype = soundtype;
    }
    
    public Button(GreenfootImage t)
    {
        setImage(t);
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this)){
            if(soundtype == "bgmusic"){
                if(val > 0){
                    if(gw.bgmusic < 100){
                        gw.bgmusic += val;
                        (gw.introMusic).setVolume(gw.bgmusic);
                    }
                    else{gw.bgmusic = 100;}
                }
                else if(val < 0){
                    if(gw.bgmusic > 0){
                        gw.bgmusic += val;
                        (gw.introMusic).setVolume(gw.bgmusic);
                    }
                    else{gw.bgmusic = 0;}
                }
            }
            else if(soundtype == "soundeffects"){
                if(val > 0){
                    if(gw.soundeffects < 100){
                        gw.soundeffects += val;
                        (gw.gameMusic).setVolume(gw.soundeffects);
                    }
                    else{gw.soundeffects = 100;}
                    
                }
                else if(val < 0){
                    if(gw.soundeffects > 0){
                        gw.soundeffects += val;
                        (gw.gameMusic).setVolume(gw.soundeffects);
                    }
                    else{gw.soundeffects = 0;}
                }
            }
        }
    }
}
