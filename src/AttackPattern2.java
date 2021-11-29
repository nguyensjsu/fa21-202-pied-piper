import greenfoot.Actor;

public class AttackPattern2 implements AttackStrategy {
    @Override
    public void attack(GameWorld theWorld, int counter) {
        if (counter < 6) {
            theWorld.addObject((Actor) new Ufo(2, 1, Ufo.DEFAULT_SPEED), 600, 300);
            theWorld.addObject((Actor) new Ufo(2, 2, Ufo.SPEED_MEDIUM), 600, 300);
            theWorld.addObject((Actor) new Ufo(2, 3, Ufo.SPEED_PLUS_ONE), 600, 300);
        }
    }
}