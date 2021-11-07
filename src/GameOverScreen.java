import greenfoot.GreenfootImage;
import greenfoot.Actor;

// 
// Decompiled by Procyon v0.5.36
// 

public class GameOverScreen extends Actor
{
    GreenfootImage i;
    int counter;
    
    public GameOverScreen() {
        this.i = new GreenfootImage("gameover2.png");
        this.counter = 0;
    }
    
    public void act() {
        switch (this.counter) {
            case 16: {
                this.getImage().drawImage(this.i, 0, 0);
                this.counter = -1;
                break;
            }
        }
        final int t = this.getImage().getTransparency();
        if (t > 1) {
            this.getImage().setTransparency(t - 1);
        }
        else {
            this.i = null;
            this.getWorld().removeObject((Actor)this);
        }
        ++this.counter;
    }
}
