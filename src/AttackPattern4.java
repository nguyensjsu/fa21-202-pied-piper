import greenfoot.Actor;

public class AttackPattern4 implements AttackStrategy {
    @Override
    public void attack(GameWorld theWorld, int counter) {
        if (counter == 1) {
            theWorld.addObject((Actor) new Ufo(0), 600, 100);
            theWorld.addObject((Actor) new Ufo(3, 3, Ufo.SPEED_MEDIUM), 600, 150);
            theWorld.addObject((Actor) new Ufo(3, 1, Ufo.SPEED_MAX), 600, 250);
        }
        if (counter == 2) {
            theWorld.addObject((Actor) new Ufo(0), 600, 300);
            theWorld.addObject((Actor) new Ufo(3, 3, Ufo.SPEED_MEDIUM), 600, 250);
            theWorld.addObject((Actor) new Ufo(3, 1, Ufo.SPEED_MAX), 600, 250);
        }
        if (counter == 3) {
            theWorld.addObject((Actor) new Ufo(0), 600, 150);
            theWorld.addObject((Actor) new Ufo(3, 3, Ufo.SPEED_MEDIUM), 600, 250);
            theWorld.addObject((Actor) new Ufo(2, 2, Ufo.SPEED_MAX), 600, 250);
        }
        if (counter == 4) {
            theWorld.addObject((Actor) new Ufo(0), 600, 250);
            theWorld.addObject((Actor) new Ufo(3, 3, Ufo.SPEED_MEDIUM), 600, 250);
            theWorld.addObject((Actor) new Ufo(3, 1, Ufo.SPEED_MAX), 600, 300);
        }
        if (counter == 5) {
            theWorld.addObject((Actor) new Ufo(0), 600, 200);
            theWorld.addObject((Actor) new Ufo(3, 3, Ufo.SPEED_MEDIUM), 600, 250);
            theWorld.addObject((Actor) new Ufo(3, 1, Ufo.SPEED_MAX), 600, 250);
        }
    }
}