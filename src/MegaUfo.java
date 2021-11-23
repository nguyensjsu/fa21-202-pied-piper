import greenfoot.Actor;

public class MegaUfo extends Actor {

    int y;
    double d;
    int speed;
    private int hit;
    private static final int MAX_HITS = 10;

    public MegaUfo(final int speed) {
        this.y = 150;
        this.d = 0.0;
        this.hit = 0;
        this.speed = speed;
        this.setImage("ufo-ship.png");
    }

    public boolean hit() {
        hit += 1;
        return hit >= MAX_HITS;
    }

    public void act() {
        this.d += 0.05;
        this.y = this.getY() - (int)(Math.sin(this.d) * 4.0);
        this.setLocation(450, this.y);
    }
}
