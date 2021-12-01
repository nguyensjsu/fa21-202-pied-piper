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

    public static final int DEFAULT_SPEED = 2;
    public static final int SPEED_PLUS_ONE = DEFAULT_SPEED + 1;
    public static final int SPEED_MEDIUM = DEFAULT_SPEED + 2;
    public static final int SPEED_MAX = DEFAULT_SPEED + 5;

    public Ufo(final int pattern, final int type, final int speed) {
        this.d = 0.0;
        this.y = 250;
        this.UFO_TYPE_1 = 1;
        this.UFO_TYPE_2 = 2;
        this.UFO_TYPE_3 = 3;
        this.speed = speed;
        this.pattern = pattern;
        if (type == this.UFO_TYPE_1) {
            this.setImage("ufo.png");
        }
        else if (type == this.UFO_TYPE_2) {
            this.setImage("bug.png");
        }
        else if (type == this.UFO_TYPE_3) {
            this.setImage("saucer.png");
        }
    }

    public Ufo(final int p) {
        this.d = 0.0;
        this.y = 250;
        this.UFO_TYPE_1 = 1;
        this.UFO_TYPE_2 = 2;
        this.UFO_TYPE_3 = 3;
        this.speed = DEFAULT_SPEED;
        this.pattern = p;
    }

    public Ufo(final int p, final int type) {
        this(p, type, SPEED_PLUS_ONE);
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
