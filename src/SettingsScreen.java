import greenfoot.GreenfootImage;
import greenfoot.Actor;
import greenfoot.Color;

// 
// Decompiled by Procyon v0.5.36
// 

public class SettingsScreen extends Actor
{   
    GreenfootImage i;
    GreenfootImage bg;
    int counter;
    
    public SettingsScreen() {
        this.bg = new GreenfootImage("settings.png");
        this.i = new GreenfootImage("settings2.png");
        this.counter = 0;
    }
    
    public void act() {
        switch (this.counter) {
            case 0: {
                this.getImage().clear();
                this.getImage().drawImage(this.bg, 0, 0);
                break;
            }
            case 30: {
                this.getImage().drawImage(this.i, 100, 330);
                break;
            }
            case 60: {
                this.counter = -1;
                break;
            }
        }
        ++this.counter;
    }
}
