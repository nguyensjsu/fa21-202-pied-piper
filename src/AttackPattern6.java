import greenfoot.Actor;

public class AttackPattern6 implements AttackStrategy {
    @Override
    public void attack(GameWorld theWorld, int counter) {
        if (counter == 1) {
            theWorld.addObject((Actor) new Ufo(0), 600, 200);
        }
        if (counter == 2) {
            theWorld.addObject((Actor) new Ufo(2), 600, 380);
            theWorld.addObject((Actor) new Ufo(3), 600, 20);
        }
        if (counter == 3) {
            theWorld.addObject((Actor) new Ufo(0), 600, 200);
        }
        if (counter == 4) {
            theWorld.addObject((Actor) new Ufo(2), 600, 380);
            theWorld.addObject((Actor) new Ufo(3), 600, 20);
        }
        if (counter == 5) {
            theWorld.addObject((Actor) new Ufo(0), 600, 140);
            theWorld.addObject((Actor) new Ufo(0), 600, 260);
        }
    }
}