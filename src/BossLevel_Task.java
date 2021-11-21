import greenfoot.Actor;

import java.util.*;

public class BossLevel_Task extends BaseLevel {

    public BossLevel_Task(final GameWorld t) {
        super(t);
    }

    private static final boolean ENABLE_PHASE_1 = true;
    private static final boolean ENABLE_PHASE_2 = true;
    private static final boolean ENABLE_PHASE_3 = true;
    private static final boolean ENABLE_PHASE_4 = true;
    private static final boolean ENABLE_PHASE_5 = true;
    private static final boolean ENABLE_PHASE_6 = true;

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
            updateDebugData();
        }
        else {
            switch (this.phase) {
                case 0: {
                    updateDebugData();
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
                    updateDebugData();
                    ++this.counter;
                    if (ENABLE_PHASE_1) {
                        if (this.counter < 6) {
                            this.theWorld.addObject((Actor) new Ufo(1, 3), 600, 250);
                            break;
                        }
                        if (this.counter == 6) {
                            this.theWorld.addObject((Actor) new Sun(), 800, 360);
                            break;
                        }
                    }
                    this.onBreak = true;
                    break;
                }
                case 2: {
                    updateDebugData();
                    ++this.counter;
                    if (ENABLE_PHASE_2) {
                        if (this.counter < 6) {
                            this.theWorld.addObject((Actor) new Ufo(2, 3), 600, 380);
                            break;
                        }
                    }
                    this.onBreak = true;
                    break;
                }
                case 3: {
                    updateDebugData();
                    ++this.counter;
                    if (ENABLE_PHASE_3) {
                        if (this.counter < 6) {
                            this.theWorld.addObject((Actor) new Ufo(3, 3), 600, 20);
                            break;
                        }
                    }
                    this.onBreak = true;
                    break;
                }
                case 4: {
                    updateDebugData();
                    ++this.counter;
                    if (ENABLE_PHASE_4) {
                        if (this.counter == 1) {
                            this.theWorld.addObject((Actor) new Ufo(0), 600, 100);
                            break;
                        }
                        if (this.counter == 2) {
                            this.theWorld.addObject((Actor) new Ufo(0), 600, 300);
                            break;
                        }
                        if (this.counter == 3) {
                            this.theWorld.addObject((Actor) new Ufo(0), 600, 150);
                            break;
                        }
                        if (this.counter == 4) {
                            this.theWorld.addObject((Actor) new Ufo(0), 600, 250);
                            break;
                        }
                        if (this.counter == 5) {
                            this.theWorld.addObject((Actor) new Ufo(0), 600, 200);
                            break;
                        }
                    }
                    this.onBreak = true;
                    break;
                }
                case 5: {
                    updateDebugData();
                    ++this.counter;
                    if (ENABLE_PHASE_5) {
                        if (this.counter == 1) {
                            this.theWorld.addObject((Actor) new Ufo(0), 600, 100);
                            this.theWorld.addObject((Actor) new Ufo(0), 600, 300);
                            break;
                        }
                        if (this.counter == 2) {
                            this.theWorld.addObject((Actor) new Sun(), 800, 360);
                            this.theWorld.addObject((Actor) new Ufo(0), 600, 150);
                            this.theWorld.addObject((Actor) new Ufo(0), 600, 250);
                            break;
                        }
                        if (this.counter == 3) {
                            this.theWorld.addObject((Actor) new Ufo(0), 600, 200);
                            break;
                        }
                    }
                    this.onBreak = true;
                    break;
                }
                case 6: {
                    updateDebugData();
                    ++this.counter;
                    if (ENABLE_PHASE_6) {
                        if (this.counter == 1) {
                            this.theWorld.addObject((Actor) new Ufo(0), 600, 200);
                            break;
                        }
                        if (this.counter == 2) {
                            this.theWorld.addObject((Actor) new Ufo(2), 600, 380);
                            this.theWorld.addObject((Actor) new Ufo(3), 600, 20);
                            break;
                        }
                        if (this.counter == 3) {
                            this.theWorld.addObject((Actor) new Ufo(0), 600, 200);
                            break;
                        }
                        if (this.counter == 4) {
                            this.theWorld.addObject((Actor) new Ufo(2), 600, 380);
                            this.theWorld.addObject((Actor) new Ufo(3), 600, 20);
                            break;
                        }
                        if (this.counter == 5) {
                            this.theWorld.addObject((Actor) new Ufo(0), 600, 140);
                            this.theWorld.addObject((Actor) new Ufo(0), 600, 260);
                            break;
                        }
                    }
                    this.onBreak = true;
                    break;
                }
                case 7: {
                    updateDebugData();
                    ++this.counter;
                    final List l = this.theWorld.getObjects((Class)Ufo.class);
                    if (l.isEmpty()) {
                        this.theWorld.endGame();
                        //this.theWorld.endLevel();
                        this.onBreak = true;
                        break;
                    }
                    break;
                }
            }
        }
    }
}