import greenfoot.GreenfootSound;
import greenfoot.Actor;

// 
// Decompiled by Procyon v0.5.36
// 

public class Explosion extends Actor
{
    int dyingFrame;
    boolean newFrame;
    GreenfootSound explosion;
    
    public Explosion() {
        this.dyingFrame = 1;
        this.newFrame = false;
        (this.explosion = new GreenfootSound("explosion.mp3")).play();
    }
    
    public void act() {
        if (this.dyingFrame > 15) {
            this.getWorld().removeObject((Actor)this);
            return;
        }
        if (this.newFrame) {
            this.setImage("explosion" + this.dyingFrame + ".png");
            ++this.dyingFrame;
            this.newFrame = false;
        }
        else {
            this.newFrame = true;
        }
    }
}
