import greenfoot.Actor;

// 
// Decompiled by Procyon v0.5.36
// 

public class Laser extends Actor
{
    int type;
    
    public Laser() {
        this(1);
    }
    
    public Laser(final int t) {
        this.type = 1;
        this.type = t;
        if (this.type == 1) {
            this.setImage("laser.png");
        }
        else {
            this.setImage("bullet.png");
        }
    }
    
    public void act() {
        this.setLocation(this.getX() + 5, this.getY());
        final Ufo a = (Ufo)this.getOneIntersectingObject((Class)Ufo.class);
        if (a != null) {
            this.getWorld().addObject((Actor)new Explosion(), a.getX(), a.getY());
            this.getWorld().removeObject((Actor)a);
            this.getWorld().removeObject((Actor)this);
        }
        else if (this.getX() > this.getWorld().getWidth()) {
            this.getWorld().removeObject((Actor)this);
        }
    }
}
