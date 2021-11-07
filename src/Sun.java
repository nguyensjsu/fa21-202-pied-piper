import greenfoot.Actor;

// 
// Decompiled by Procyon v0.5.36
// 

public class Sun extends Background
{
    public Sun() {
        this.speed = 1;
    }
    
    @Override
    public void act() {
        this.setLocation(this.getX() - this.speed, this.getY());
        if (this.getX() < -100) {
            this.getWorld().removeObject((Actor)this);
        }
    }
}
