import greenfoot.Actor;

import java.util.List;
import java.util.TimerTask;

public class BossLevel_Task extends TimerTask {

    GameWorld theWorld;
    private int MAXPHASE;
    int counter;
    int phase;
    int breakCounter;
    boolean onBreak;
    Actor entering;

    public BossLevel_Task(final GameWorld t) {
        this.MAXPHASE = 7;
        this.counter = 0;
        this.phase = 0;
        this.breakCounter = 0;
        this.onBreak = false;
        this.entering = new NowEntering();
        this.theWorld = t;
    }

    @Override
    public void run() {
        if (this.onBreak) {
            ++this.breakCounter;
            if (this.breakCounter > 2) {
                this.onBreak = false;
                ++this.phase;
                this.counter = 0;
                this.breakCounter = 0;
            }
        }
        else {
            switch (this.phase) {
                case 0: {
                    ++this.counter;
                    if (this.counter == 1) {
                        this.theWorld.showPlayer(false);
                        this.entering.setImage("boss_level.png");
                        this.theWorld.addObject(this.entering, 300, 200);
                        break;
                    }
                    if (this.counter == 6) {
                        this.theWorld.showPlayer(true);
                        this.theWorld.removeObject(this.entering);
                        this.onBreak = true;
                        break;
                    }
                    break;
                }
                case 1: {
                    ++this.counter;
                    if (this.counter < 6) {
                        this.theWorld.addObject((Actor)new Ufo(1, 3), 600, 250);
                        break;
                    }
                    if (this.counter == 6) {
                        this.theWorld.addObject((Actor)new Sun(), 800, 360);
                        break;
                    }
                    this.onBreak = true;
                    break;
                }
                case 2: {
                    ++this.counter;
                    if (this.counter < 6) {
                        this.theWorld.addObject((Actor)new Ufo(2, 3), 600, 380);
                        break;
                    }
                    this.onBreak = true;
                    break;
                }
                case 3: {
                    ++this.counter;
                    if (this.counter < 6) {
                        this.theWorld.addObject((Actor)new Ufo(3, 3), 600, 20);
                        break;
                    }
                    this.onBreak = true;
                    break;
                }
                case 4: {
                    ++this.counter;
                    if (this.counter == 1) {
                        this.theWorld.addObject((Actor)new Ufo(0), 600, 100);
                        break;
                    }
                    if (this.counter == 2) {
                        this.theWorld.addObject((Actor)new Ufo(0), 600, 300);
                        break;
                    }
                    if (this.counter == 3) {
                        this.theWorld.addObject((Actor)new Ufo(0), 600, 150);
                        break;
                    }
                    if (this.counter == 4) {
                        this.theWorld.addObject((Actor)new Ufo(0), 600, 250);
                        break;
                    }
                    if (this.counter == 5) {
                        this.theWorld.addObject((Actor)new Ufo(0), 600, 200);
                        break;
                    }
                    this.onBreak = true;
                    break;
                }
                case 5: {
                    ++this.counter;
                    if (this.counter == 1) {
                        this.theWorld.addObject((Actor)new Ufo(0), 600, 100);
                        this.theWorld.addObject((Actor)new Ufo(0), 600, 300);
                        break;
                    }
                    if (this.counter == 2) {
                        this.theWorld.addObject((Actor)new Sun(), 800, 360);
                        this.theWorld.addObject((Actor)new Ufo(0), 600, 150);
                        this.theWorld.addObject((Actor)new Ufo(0), 600, 250);
                        break;
                    }
                    if (this.counter == 3) {
                        this.theWorld.addObject((Actor)new Ufo(0), 600, 200);
                        break;
                    }
                    this.onBreak = true;
                    break;
                }
                case 6: {
                    ++this.counter;
                    if (this.counter == 1) {
                        this.theWorld.addObject((Actor)new Ufo(0), 600, 200);
                        break;
                    }
                    if (this.counter == 2) {
                        this.theWorld.addObject((Actor)new Ufo(2), 600, 380);
                        this.theWorld.addObject((Actor)new Ufo(3), 600, 20);
                        break;
                    }
                    if (this.counter == 3) {
                        this.theWorld.addObject((Actor)new Ufo(0), 600, 200);
                        break;
                    }
                    if (this.counter == 4) {
                        this.theWorld.addObject((Actor)new Ufo(2), 600, 380);
                        this.theWorld.addObject((Actor)new Ufo(3), 600, 20);
                        break;
                    }
                    if (this.counter == 5) {
                        this.theWorld.addObject((Actor)new Ufo(0), 600, 140);
                        this.theWorld.addObject((Actor)new Ufo(0), 600, 260);
                        break;
                    }
                    this.onBreak = true;
                    break;
                }
                case 7: {
                    ++this.counter;
                    final List l = this.theWorld.getObjects((Class)Ufo.class);
                    if (l.isEmpty()) {
                        this.theWorld.endGame();
                        this.onBreak = true;
                        break;
                    }
                    break;
                }
            }
        }
    }
}