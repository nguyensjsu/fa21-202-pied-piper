import greenfoot.Actor;

import java.util.*;

public abstract class BaseLevel extends TimerTask implements IDebugSubject {

    protected List<IDebugObserver> observers = new ArrayList<>() ;
    protected Map<String,Object> debugData = new HashMap<>();

    GameWorld theWorld;
    private int MAXPHASE;
    int counter;
    int phase;
    int breakCounter;
    boolean onBreak;
    Actor entering;

    public BaseLevel(final GameWorld t) {
        this.MAXPHASE = 7;
        this.counter = 0;
        this.phase = 0;
        this.breakCounter = 0;
        this.onBreak = false;
        this.entering = new NowEntering();
        this.theWorld = t;
    }

    protected void updateDebugData() {
        debugData.put("counter", this.counter);
        debugData.put("phase", this.phase);
        debugData.put("onBreak", this.onBreak);
        notifyObservers(debugData);
    }

    @Override
    public void attach(IDebugObserver obj) {
        observers.add(obj);
    }

    @Override
    public void detach(IDebugObserver obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers(Map<String,Object> data) {
        observers.forEach(o -> o.update(data));
    }

    @Override
    public abstract void run();
}
