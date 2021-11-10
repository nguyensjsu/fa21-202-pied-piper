import java.util.Collection;
import java.util.TimerTask;
import java.util.List;
import greenfoot.Greenfoot;
import greenfoot.Actor;
import greenfoot.GreenfootSound;
import java.util.Timer;
import greenfoot.World;

// 
// Decompiled by Procyon v0.5.36
// 

public class GameWorld extends World
{
    int x;
    int y;
    int runningLevel;
    double d;
    Timer timer;
    Player player;
    int playerLives;
    StartScreen startScreen;
    private static final int RUNNING = 1;
    private static final int GAMEOVER_SCREEN = 2;
    private static final int START_SCREEN = 3;
    private static final int BETWEEN_LEVELS = 4;
    int gameState;
    GreenfootSound introMusic;
    GreenfootSound gameMusic;
    
    public GameWorld() {
        super(600, 400, 1, false);
        this.runningLevel = -1;
        this.d = 0.0;
        this.playerLives = 3;
        this.gameState = 3;
        this.prepare();
    }
    
    private void prepare() {
        this.addObject((Actor)new Space(), 0, 200);
        this.addObject((Actor)new Space(), 600, 200);
        (this.introMusic = new GreenfootSound("sanxion.mp3")).setVolume(0);
        (this.gameMusic = new GreenfootSound("delta.mp3")).setVolume(0);
        this.addObject((Actor)(this.startScreen = new StartScreen()), 300, 200);
        this.addObject((Actor)(this.player = new Player()), 83, 215);
        this.player.showPlayer(false);
        final Class[] x = { Explosion.class, Player.class, Laser.class, Ufo.class, StartScreen.class, Moon.class };
        this.setPaintOrder(x);
    }
    
    public void act() {
        switch (this.gameState) {
            case 2: {
                final List l = this.getObjects((Class)GameOverScreen.class);
                if (l.isEmpty()) {
                    this.timer.cancel();
                    this.resetGame();
                    this.gameState = 3;
                    break;
                }
                break;
            }
            case 3: {
                if (!this.introMusic.isPlaying()) {
                    this.introMusic.play();
                }
                if (!Greenfoot.isKeyDown("space")) {
                    break;
                }
                this.gameState = 4;
                this.removeObject((Actor)this.startScreen);
                this.player.showPlayer(false);
                if (this.introMusic.isPlaying()) {
                    this.introMusic.stop();
                    break;
                }
                break;
            }
            case 4: {
                this.startNewLevel();
                this.gameState = 1;
                break;
            }
        }
    }
    
    public void endGame() {
        this.player.showPlayer(false);
        this.addObject((Actor)new GameOverScreen(), 300, 200);
        this.gameState = 2;
        if (this.gameMusic.isPlaying()) {
            this.gameMusic.stop();
        }
        final GreenfootSound swoosh = new GreenfootSound("swoosh.mp3");
        swoosh.setVolume(100);
        swoosh.play();
    }
    
    public void startNewLevel() {
        if (this.runningLevel == 1) {
            this.runningLevel = 2;
            (this.timer = new Timer()).scheduleAtFixedRate(new Level_2_Task(this), 1000L, 600L);
        }
        else {
            if (!this.gameMusic.isPlaying()) {
                this.gameMusic.playLoop();
            }
            this.runningLevel = 1;
            (this.timer = new Timer()).scheduleAtFixedRate(new Level_1_Task(this), 1000L, 600L);
        }
    }
    
    public void takeLife() {
        --this.playerLives;
        if (this.playerLives == 0) {
            this.endGame();
        }
        else {
            this.restartLevel();
        }
    }
    
    public void restartLevel() {
        --this.runningLevel;
        this.timer.cancel();
        this.startNewLevel();
    }
    
    public void endLevel() {
        this.showPlayer(false);
        this.timer.cancel();
        this.gameState = 4;
    }
    
    public void resetGame() {
        final List l = this.getObjects((Class)Ufo.class);
        if (!l.isEmpty()) {
            this.removeObjects((Collection)l);
        }
        this.gameState = 3;
        this.addObject((Actor)this.startScreen, 300, 200);
        this.runningLevel = -1;
        this.playerLives = 3;
    }
    
    public void showPlayer(final boolean b) {
        this.player.showPlayer(b);
    }
}
