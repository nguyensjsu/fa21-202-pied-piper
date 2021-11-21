import greenfoot.Actor;
import java.util.ArrayList;

// 
// Decompiled by Procyon v0.5.36
// 

public class Laser extends Actor implements ISubject
{
    int type;
    private ArrayList<IObserver> observers = new ArrayList<>() ;

    public Laser() {
        this(1);
    }

    private IDebugObserver debugObserver;
    public Laser(final int t, IDebugObserver debugObserver) {
        this(t);
        this.debugObserver = debugObserver;
    }

    public Laser(final int t) {
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
            // Lazer hit a UFO
            debugObserver.update("numHits", 1);
            notifyObservers(1); // Default score per hit is 1 at the moment
            this.getWorld().addObject((Actor)new Explosion(), a.getX(), a.getY());
            this.getWorld().removeObject((Actor)a);
            this.getWorld().removeObject((Actor)this);
        }
        else if (this.getX() > this.getWorld().getWidth()) {
            this.getWorld().removeObject((Actor)this);
        }
    }

    // ROGER - Observer Pattern
    public void attach(IObserver obj) {
        observers.add(obj) ;
    }

    public void detach(IObserver obj) {
        observers.remove(obj) ;
    }

    public void notifyObservers(int num) {
        for (IObserver obj : observers) {
            obj.update(num);
        }
    }
    // END - ROGER - Observer Pattern
}
