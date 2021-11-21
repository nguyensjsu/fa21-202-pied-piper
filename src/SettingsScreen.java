import greenfoot.GreenfootImage;
import greenfoot.Actor;
import greenfoot.Color;

// 
// Decompiled by Procyon v0.5.36
// 

public class SettingsScreen extends Actor
{   
    GameWorld gw;
    GreenfootImage gobacktext;
    GreenfootImage gobacktext1;
    int counter;
    public SettingsScreen() {
        this.gobacktext = new GreenfootImage("settings2.png");
    }
    
    public void act() {
        this.getImage().drawImage(this.gobacktext, 100, 325);
    }
}
