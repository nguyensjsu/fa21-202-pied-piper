import greenfoot.Actor;

public class AttackPattern3 extends AttackPattern1 {
    @Override
    public void attack(GameWorld theWorld, int counter) {
        if (counter < 6) {
            theWorld.addObject((Actor) new Ufo(3, 1, Ufo.SPEED_MAX), 600, 20);
            theWorld.addObject((Actor) new Ufo(3, 2, Ufo.SPEED_PLUS_ONE), 600, 20);
            theWorld.addObject((Actor) new Ufo(3, 3, Ufo.DEFAULT_SPEED), 600, 20);
            theWorld.addObject((Actor) new Ufo(2, 1, Ufo.SPEED_MAX), 600, 20);
            theWorld.addObject((Actor) new Ufo(1, 3, Ufo.SPEED_MEDIUM), 600, 20);
        }
        spawnRandomAttacks(theWorld);
    }
}
