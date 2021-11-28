import greenfoot.Actor;

import java.util.Random;

public class AttackPattern1 implements AttackStrategy {

    private Random random;

    @Override
    public void attack(GameWorld theWorld, int counter) {
        theWorld.addObject((Actor) new MegaUfo(1), 600, 250);
        spawnRandomAttacks(theWorld);
    }

    protected void spawnRandomAttacks(GameWorld theWorld) {
        new Thread(() -> {
            for (int i=0; i<20; i++) {
                random = new Random();
                int y = random.nextInt(300);
                int speed = random.nextInt(8) + 1;
                int pattern = random.nextInt(4);
                int type = random.nextInt(3) + 1;
                theWorld.addObject((Actor) new Ufo(pattern, type, speed), 600, y);
                try {
                    Thread.sleep(y);
                } catch (InterruptedException e) {}
            }
        }).start();
    }
}