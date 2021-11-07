import greenfoot.GreenfootImage;
import greenfoot.Actor;

// 
// Decompiled by Procyon v0.5.36
// 

public class StartScreen extends Actor
{
    GreenfootImage i;
    GreenfootImage bg;
    int counter;
    
    public StartScreen() {
        this.i = new GreenfootImage("press_space.png");
        this.bg = new GreenfootImage("startscreen.png");
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
                this.getImage().drawImage(this.i, 200, 350);
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
