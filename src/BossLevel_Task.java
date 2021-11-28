import java.util.*;

public class BossLevel_Task extends BaseLevel {

    private AttackStrategy attackStrategy;

    public BossLevel_Task(final GameWorld t) {
        super(t);
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
                    changeAttackStrategy(new AttackPattern1());
                    attackStrategy.attack(this.theWorld, this.counter);
                    this.onBreak = true;
                    break;
                }
                case 2: {
                    updateDebugData();
                    ++this.counter;
                    changeAttackStrategy(new AttackPattern2());
                    attackStrategy.attack(this.theWorld, this.counter);
                    this.onBreak = true;
                    break;
                }
                case 3: {
                    updateDebugData();
                    ++this.counter;
                    changeAttackStrategy(new AttackPattern3());
                    attackStrategy.attack(this.theWorld, this.counter);
                    this.onBreak = true;
                    break;
                }
                case 4: {
                    updateDebugData();
                    ++this.counter;
                    changeAttackStrategy(new AttackPattern4());
                    attackStrategy.attack(this.theWorld, this.counter);
                    this.onBreak = true;
                    break;
                }
                case 5: {
                    updateDebugData();
                    ++this.counter;
                    changeAttackStrategy(new AttackPattern5());
                    attackStrategy.attack(this.theWorld, this.counter);
                    this.onBreak = true;
                    break;
                }
                case 6: {
                    updateDebugData();
                    ++this.counter;
                    changeAttackStrategy(new AttackPattern6());
                    attackStrategy.attack(this.theWorld, this.counter);
                    this.onBreak = true;
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

    private void changeAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }
}