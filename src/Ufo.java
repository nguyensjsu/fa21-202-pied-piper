import greenfoot.Actor;

// 
// Decompiled by Procyon v0.5.36
// 

public class Ufo extends Actor
{
    double d;
    int pattern;
    int y;
    int UFO_TYPE_1;
    int UFO_TYPE_2;
    int UFO_TYPE_3;
    int speed;
    
    public Ufo(final int p) {
        this.d = 0.0;
        this.pattern = 0;
        this.y = 250;
        this.UFO_TYPE_1 = 1;
        this.UFO_TYPE_2 = 2;
        this.UFO_TYPE_3 = 3;
        this.speed = 2;
        this.pattern = p;
    }
    
    public Ufo(final int p, final int type) {
        this.d = 0.0;
        this.pattern = 0;
        this.y = 250;
        this.UFO_TYPE_1 = 1;
        this.UFO_TYPE_2 = 2;
        this.UFO_TYPE_3 = 3;
        this.speed = 2;
        this.pattern = p;
        if (type == this.UFO_TYPE_1) {
            this.setImage("ufo.png");
        }
        else if (type == this.UFO_TYPE_2) {
            this.setImage("bug.png");
            this.speed = 3;
        }
        else if (type == this.UFO_TYPE_3) {
            this.setImage("saucer.png");
            this.speed = 2;
        }
    }
    
    public void act() {
        switch (this.pattern) {
            case 1: {
                this.d += 0.05;
                this.y = this.getY() - (int)(Math.sin(this.d) * 4.0);
                break;
            }
            case 2: {
                this.d += 0.02;
                if (this.d < 3.141592653589793) {
                    this.y = this.getY() - (int)(Math.sin(this.d) * 4.3);
                    break;
                }
                break;
            }
            case 3: {
                this.d += 0.02;
                if (this.d < 3.141592653589793) {
                    this.y = this.getY() + (int)(Math.sin(this.d) * 4.3);
                    break;
                }
                break;
            }
            default: {
                this.y = this.getY();
                break;
            }
        }
        this.setLocation(this.getX() - this.speed, this.y);
        if (this.getX() < -10) {
            this.getWorld().removeObject((Actor)this);
        }
    }
}
