import greenfoot.Actor;

// 
// Decompiled by Procyon v0.5.36
// 

public class Moon extends Background
{
    public Moon() {
        this.speed = 1;
    }
    
    @Override
    public void act() {
        this.setLocation(this.getX() - this.speed, this.getY());
        if (this.getX() < -200) {
            this.getWorld().removeObject((Actor)this);
        }
    }
}
