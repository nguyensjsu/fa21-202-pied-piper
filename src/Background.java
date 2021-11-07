import greenfoot.Actor;

// 
// Decompiled by Procyon v0.5.36
// 

public class Background extends Actor
{
    protected int speed;
    protected int idle;
    double x;
    
    public Background() {
        this.speed = 10;
        this.idle = 2;
        this.x = 0.0;
    }
    
    public void act() {
    }
    
    protected void checkKeys() {
        if (this.x >= 1.0) {
            this.setLocation(this.getX() - this.speed, this.getY());
            this.x = 0.0;
        }
        else {
            this.x += 0.4;
        }
        if (this.getX() < -300) {
            this.setLocation(898, 200);
        }
    }
    
    protected void move() {
        if (this.x >= 1.0) {
            this.setLocation(this.getX() - this.speed, this.getY());
            this.x = 0.0;
        }
        else {
            this.x += 0.4;
        }
    }
}
