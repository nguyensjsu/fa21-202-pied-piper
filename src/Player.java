import greenfoot.Greenfoot;
import greenfoot.GreenfootSound;
import greenfoot.GreenfootImage;
import greenfoot.Actor;

// 
// Decompiled by Procyon v0.5.36
// 

public class Player extends Actor
{
    int counter;
    int speedV;
    int speedH;
    boolean enableKeys;
    GreenfootImage i3;
    GreenfootImage i1;
    GreenfootImage i2;
    GreenfootImage i4;
    int imageCounter;
    GreenfootSound laserShot;
    public static final int WEAPON_LASER = 1;
    public static final int WEAPON_BULLET = 2;
    
    public Player() {
        this.counter = 0;
        this.speedV = 3;
        this.speedH = 3;
        this.enableKeys = true;
        this.imageCounter = 1;
        this.laserShot = new GreenfootSound("lasershot.mp3");
        this.i1 = new GreenfootImage("player1.png");
        this.i2 = new GreenfootImage("player2.png");
        this.i3 = new GreenfootImage("player3.png");
        this.i4 = new GreenfootImage("player2.png");
    }

    private IDebugObserver debugObserver;
    public void setDebugObserver(IDebugObserver debugObserver) {
        this.debugObserver = debugObserver;
    }

    public void act() {
        if (this.enableKeys) {
            this.checkKeys();
            switch (this.imageCounter) {
                case 1: {
                    this.setImage(this.i1);
                    break;
                }
                case 8: {
                    this.setImage(this.i2);
                    break;
                }
                case 15: {
                    this.setImage(this.i3);
                    break;
                }
                case 22: {
                    this.setImage(this.i4);
                    break;
                }
                case 30: {
                    this.imageCounter = 0;
                    break;
                }
            }
            ++this.imageCounter;
            final Ufo a = (Ufo)this.getOneIntersectingObject((Class)Ufo.class);
            if (a != null) {
                this.getWorld().addObject((Actor)new Explosion(), this.getX(), this.getY());
                this.showPlayer(false);
                // Deduct Life Point
                ((GameWorld)this.getWorld()).takeLife();
            }
        }
    }


    public void checkKeys() {
        if (Greenfoot.isKeyDown("up")) {
            if (this.getY() > 15) {
                this.setLocation(this.getX(), this.getY() - this.speedV);
            }
        }
        else if (Greenfoot.isKeyDown("down") && this.getY() < 385) {
            this.setLocation(this.getX(), this.getY() + this.speedV);
        }
        if (Greenfoot.isKeyDown("right")) {
            if (this.getX() < 570) {
                this.setLocation(this.getX() + this.speedH, this.getY());
            }
        }
        else if (Greenfoot.isKeyDown("left") && this.getX() > 20) {
            this.setLocation(this.getX() - this.speedH, this.getY());
        }
        ++this.counter;
        if (Greenfoot.isKeyDown("space") && this.counter > 14) {
            this.counter = 0;
            Laser laser = new Laser(2, debugObserver);
            // Add gameworld as observer for scoring
            laser.attach((GameWorld)this.getWorld());
            this.getWorld().addObject((Actor)laser, this.getX() + 24, this.getY() + 4);
            this.laserShot.play();
        }
    }
    
    public void showPlayer(final boolean b) {
        if (b) {
            this.setImage(this.i1);
            this.enableKeys(true);
        }
        else {
            this.setImage("empty.png");
            this.enableKeys(false);
        }
        this.resetLocation();
    }
    
    public void enableKeys(final boolean b) {
        this.enableKeys = b;
    }
    
    public void resetLocation() {
        this.setLocation(83, 215);
    }

}
