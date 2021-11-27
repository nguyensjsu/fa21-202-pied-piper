import greenfoot.Actor;

import java.util.*;

public class BossLevel_Task extends BaseLevel {

    private Random random;
    public BossLevel_Task(final GameWorld t) {
        super(t);
        this.random = new Random();
    }

    private static final boolean ENABLE_PHASE_1 = true;
    private static final boolean ENABLE_PHASE_2 = false;
    private static final boolean ENABLE_PHASE_3 = false;
    private static final boolean ENABLE_PHASE_4 = false;
    private static final boolean ENABLE_PHASE_5 = false;
    private static final boolean ENABLE_PHASE_6 = false;

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
                        // Removes existing UFOs and objects upon reset
                        // However, it is still spawning the next wave.
                        List l = this.theWorld.getObjects((Class)RedSun.class);
                        if (l != null) {
                            this.theWorld.removeObjects((Collection)l);
                        }
                        l = this.theWorld.getObjects((Class)Ufo.class);
                        if (l != null) {
                            this.theWorld.removeObjects((Collection)l);
                        }
                        l = this.theWorld.getObjects((Class)MegaUfo.class);
                        if (l != null) {
                            this.theWorld.removeObjects((Collection)l);
                        }
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
                    pattern1();
                    break;
                }
                case 2: {
                    pattern2();
                    break;
                }
                case 3: {
                    pattern3();
                    break;
                }
                case 4: {
                    pattern4();
                    break;
                }
                case 5: {
                    pattern5();
                    break;
                }
                case 6: {
                    pattern6();
                    break;
                }
                case 7: {
                    ++this.counter;
                    final List l = this.theWorld.getObjects((Class)Ufo.class);
                    debugData.put("enemiesLeft", l.size());
                    updateDebugData();
                    //final List l2 = this.theWorld.getObjects((Class)MegaUfo.class);
                    if (l.isEmpty()) { // && l2.isEmpty()) {
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

    private void patternEmpty() {
        updateDebugData();
        ++this.counter;
        this.onBreak = true;
    }

    private void patternDebug() {
        pattern5();
    }

    private void pattern1() {
        updateDebugData();
        ++this.counter;
        this.theWorld.addObject((Actor) new MegaUfo(1), 600, 250);
        spawnRandomAttacks();
//        pattern1Core();
        this.onBreak = true;
    }

    private void pattern2() {
        updateDebugData();
        ++this.counter;
        pattern2Core();
        this.onBreak = true;
    }

    private void pattern3() {
        updateDebugData();
        ++this.counter;
        spawnRandomAttacks();
        //pattern3Core();
        this.onBreak = true;
    }

    private void pattern4() {
        updateDebugData();
        ++this.counter;
        pattern4Core();
        this.onBreak = true;
    }

    private void pattern1Core() {
        if (this.counter < 6) {
            this.theWorld.addObject((Actor) new Ufo(1, 1, Ufo.DEFAULT_SPEED), 600, 250);
            this.theWorld.addObject((Actor) new Ufo(1, 2, Ufo.SPEED_PLUS_ONE), 600, 250);
            this.theWorld.addObject((Actor) new Ufo(1, 3, Ufo.SPEED_MAX), 600, 250);
            return;
        }
        if (this.counter == 6) {
            this.theWorld.addObject((Actor) new RedSun(), 800, 360);
            return;
        }
    }

    private void pattern2Core() {
        if (this.counter < 6) {
            this.theWorld.addObject((Actor) new Ufo(2, 1, Ufo.DEFAULT_SPEED), 600, 300);
            this.theWorld.addObject((Actor) new Ufo(2, 2, Ufo.SPEED_MEDIUM), 600, 300);
            this.theWorld.addObject((Actor) new Ufo(2, 3, Ufo.SPEED_PLUS_ONE), 600, 300);
            return;
        }
    }

    private void pattern3Core() {
        if (this.counter < 6) {
            this.theWorld.addObject((Actor) new Ufo(3, 1, Ufo.SPEED_MAX), 600, 20);
            this.theWorld.addObject((Actor) new Ufo(3, 2, Ufo.SPEED_PLUS_ONE), 600, 20);
            this.theWorld.addObject((Actor) new Ufo(3, 3, Ufo.DEFAULT_SPEED), 600, 20);
            this.theWorld.addObject((Actor) new Ufo(2, 1, Ufo.SPEED_MAX), 600, 20);
            this.theWorld.addObject((Actor) new Ufo(1, 3, Ufo.SPEED_MEDIUM), 600, 20);
            return;
        }
    }

    private void pattern4Core() {
        if (this.counter == 1) {
            this.theWorld.addObject((Actor) new Ufo(0), 600, 100);
            this.theWorld.addObject((Actor) new Ufo(3, 3, Ufo.SPEED_MEDIUM), 600, 150);
            this.theWorld.addObject((Actor) new Ufo(3, 1, Ufo.SPEED_MAX), 600, 250);
            return;
        }
        if (this.counter == 2) {
            this.theWorld.addObject((Actor) new Ufo(0), 600, 300);
            this.theWorld.addObject((Actor) new Ufo(3, 3, Ufo.SPEED_MEDIUM), 600, 250);
            this.theWorld.addObject((Actor) new Ufo(3, 1, Ufo.SPEED_MAX), 600, 250);
            return;
        }
        if (this.counter == 3) {
            this.theWorld.addObject((Actor) new Ufo(0), 600, 150);
            this.theWorld.addObject((Actor) new Ufo(3, 3, Ufo.SPEED_MEDIUM), 600, 250);
            this.theWorld.addObject((Actor) new Ufo(2, 2, Ufo.SPEED_MAX), 600, 250);
            return;
        }
        if (this.counter == 4) {
            this.theWorld.addObject((Actor) new Ufo(0), 600, 250);
            this.theWorld.addObject((Actor) new Ufo(3, 3, Ufo.SPEED_MEDIUM), 600, 250);
            this.theWorld.addObject((Actor) new Ufo(3, 1, Ufo.SPEED_MAX), 600, 300);
            return;
        }
        if (this.counter == 5) {
            this.theWorld.addObject((Actor) new Ufo(0), 600, 200);
            this.theWorld.addObject((Actor) new Ufo(3, 3, Ufo.SPEED_MEDIUM), 600, 250);
            this.theWorld.addObject((Actor) new Ufo(3, 1, Ufo.SPEED_MAX), 600, 250);
            return;
        }
    }

    private void pattern5Core() {
        if (this.counter == 1) {
            this.theWorld.addObject((Actor) new Ufo(0), 600, 100);
            this.theWorld.addObject((Actor) new Ufo(0), 600, 300);
            return;
        }
        if (this.counter == 2) {
            this.theWorld.addObject((Actor) new RedSun(), 800, 360);
            this.theWorld.addObject((Actor) new Ufo(0), 600, 150);
            this.theWorld.addObject((Actor) new Ufo(0), 600, 250);
            return;
        }
        if (this.counter == 3) {
            this.theWorld.addObject((Actor) new Ufo(0), 600, 200);
            return;
        }
    }

    private void pattern6Core() {
        if (this.counter == 1) {
            this.theWorld.addObject((Actor) new Ufo(0), 600, 200);
            return;
        }
        if (this.counter == 2) {
            this.theWorld.addObject((Actor) new Ufo(2), 600, 380);
            this.theWorld.addObject((Actor) new Ufo(3), 600, 20);
            return;
        }
        if (this.counter == 3) {
            this.theWorld.addObject((Actor) new Ufo(0), 600, 200);
            return;
        }
        if (this.counter == 4) {
            this.theWorld.addObject((Actor) new Ufo(2), 600, 380);
            this.theWorld.addObject((Actor) new Ufo(3), 600, 20);
            return;
        }
        if (this.counter == 5) {
            this.theWorld.addObject((Actor) new Ufo(0), 600, 140);
            this.theWorld.addObject((Actor) new Ufo(0), 600, 260);
            return;
        }
    }

    private void pattern5() {
        updateDebugData();
        ++this.counter;
        //this.theWorld.addObject((Actor) new MegaUfo(1), 600, 250);
        spawnRandomAttacks();
        this.onBreak = true;
    }

    private void pattern6() {
        updateDebugData();
        ++this.counter;
        pattern6Core();
        this.onBreak = true;
    }

    private void spawnRandomAttacks() {
        // This causes UFOs to be spawned, as suggested, on a separate thread.
        // Therefore, it seems that when the level is reset, this method is still running.
        // This causes random UFOs to continue spawning in during the "Now Entering" phase.
        new Thread(() -> {
            for (int i=0; i<20; i++) {
                random = new Random();
                int y = random.nextInt(300);
                int speed = random.nextInt(8) + 1;
                int pattern = random.nextInt(4);
                int type = random.nextInt(3) + 1;
                this.theWorld.addObject((Actor) new Ufo(pattern, type, speed), 600, y);
                try {
                    Thread.sleep(y);
                } catch (InterruptedException e) {}
            }
        }).start();
    }
}