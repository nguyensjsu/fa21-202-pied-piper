import greenfoot.Actor;

public class RedSun extends Background
{
    public RedSun() {
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

