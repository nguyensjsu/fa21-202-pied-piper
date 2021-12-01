import greenfoot.Actor;

public class AttackPattern5 implements AttackStrategy {
    @Override
    public void attack(GameWorld theWorld, int counter) {
        if (counter == 1) {
            theWorld.addObject((Actor) new Ufo(0), 600, 100);
            theWorld.addObject((Actor) new Ufo(0), 600, 300);
        }
        if (counter == 2) {
            theWorld.addObject((Actor) new RedSun(), 800, 360);
            theWorld.addObject((Actor) new Ufo(0), 600, 150);
            theWorld.addObject((Actor) new Ufo(0), 600, 250);
        }
        if (counter == 3) {
            theWorld.addObject((Actor) new Ufo(0), 600, 200);
        }
    }
}
