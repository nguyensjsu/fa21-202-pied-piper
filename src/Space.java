// 
// Decompiled by Procyon v0.5.36
// 

public class Space extends Background
{
    double x;
    
    public Space() {
        this.x = 0.0;
        this.speed = 1;
    }
    
    @Override
    public void act() {
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
}
