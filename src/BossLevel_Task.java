import java.util.*;

public class BossLevel_Task extends BaseLevel {

    private AttackStrategy attackStrategy;

    public BossLevel_Task(final GameWorld t) {
        super(t);
    }

    private static final int PHASE_1 = 1;
    private static final int PHASE_2 = 2;
    private static final int PHASE_3 = 3;
    private static final int PHASE_4 = 4;
    private static final int PHASE_5 = 5;
    private static final int PHASE_6 = 6;
    private static final int PHASE_7 = 7;

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
                case PHASE_1: {
                    updateDebugData();
                    ++this.counter;
                    changeAttackStrategy(new AttackPattern1());
                    attackStrategy.attack(this.theWorld, this.counter);
                    this.onBreak = true;
                    break;
                }
                case PHASE_2: {
                    updateDebugData();
                    ++this.counter;
                    changeAttackStrategy(new AttackPattern2());
                    attackStrategy.attack(this.theWorld, this.counter);
                    this.onBreak = true;
                    break;
                }
                case PHASE_3: {
                    updateDebugData();
                    ++this.counter;
                    changeAttackStrategy(new AttackPattern3());
                    attackStrategy.attack(this.theWorld, this.counter);
                    this.onBreak = true;
                    break;
                }
                case PHASE_4: {
                    updateDebugData();
                    ++this.counter;
                    changeAttackStrategy(new AttackPattern4());
                    attackStrategy.attack(this.theWorld, this.counter);
                    this.onBreak = true;
                    break;
                }
                case PHASE_5: {
                    updateDebugData();
                    ++this.counter;
                    changeAttackStrategy(new AttackPattern5());
                    attackStrategy.attack(this.theWorld, this.counter);
                    this.onBreak = true;
                    break;
                }
                case PHASE_6: {
                    updateDebugData();
                    ++this.counter;
                    changeAttackStrategy(new AttackPattern6());
                    attackStrategy.attack(this.theWorld, this.counter);
                    this.onBreak = true;
                    break;
                }
                case PHASE_7: {
                    ++this.counter;
                    final List l = this.theWorld.getObjects((Class)Ufo.class);
                    debugData.put("enemiesLeft", l.size());
                    updateDebugData();
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

    private void changeAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }
}