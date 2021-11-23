import greenfoot.Actor;

import java.util.concurrent.*;

// 
// Decompiled by Procyon v0.5.36
// 

public class Laser extends Actor
{
    int type;

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
        final Ufo ufo = (Ufo)this.getOneIntersectingObject((Class)Ufo.class);
        //final MegaUfo megaUfo = (MegaUfo)this.getOneIntersectingObject((Class)MegaUfo.class);
        if (ufo != null) {
            processUfoHit(ufo);
        }
        //else if (megaUfo != null) {
        //    megaUfoHit(megaUfo);
        //}
        else if (this.getX() > this.getWorld().getWidth()) {
            this.getWorld().removeObject((Actor)this);
        }
    }

    private void processUfoHit(Ufo ufo) {
        debugObserver.update("numHits", 1);
        this.getWorld().addObject((Actor)new Explosion(), ufo.getX(), ufo.getY());
        this.getWorld().removeObject((Actor)ufo);
        this.getWorld().removeObject((Actor)this);
    }

    private void megaUfoHit(MegaUfo megaUfo) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable c = () -> processMegaUfoHit(megaUfo);
        Future<Boolean> future = executor.submit(c);
        try {
            Boolean isDestroyed = future.get();
            if (isDestroyed)
                this.getWorld().removeObject((Actor) megaUfo);
            this.getWorld().removeObject((Actor)this);
        } catch(ExecutionException | InterruptedException e) {
        } finally {
            executor.shutdown();
        }
    }

    private boolean processMegaUfoHit(MegaUfo megaUfo) {
        debugObserver.update("numHits", 1);
        this.getWorld().addObject((Actor)new Explosion(), megaUfo.getX() + 10, this.getY());
        boolean isDestroyed = false;
        if (megaUfo.hit()) {
            for (int i=0; i<10; i++) {
                int x = megaUfo.getX() + (i%2 == 0 ? i : -i);
                int y = this.getY() + (i%2 == 0 ? i : -i);
                this.getWorld().addObject((Actor)new Explosion(), x, y);
            }
            isDestroyed = true;
        }
        return isDestroyed;
    }
}
