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

    // Roger - Added life observer
    IObserver lifeObserver;

    // John - track debug data within a game level
    IDebugObserver debugObserver;

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

        // Roger - Create and attach life observer
        this.addObject((Actor)(this.lifeObserver =
                new LifeObserver(this.player, this.playerLives)), 300, 50);
        this.player.attach(this.lifeObserver);
        this.showPlayer(false);

        this.addObject((Actor)(this.debugObserver = new DebugObserver()), 500, 50);
        this.player.setDebugObserver(this.debugObserver);

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
                this.showPlayer(false);
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
        this.showPlayer(false);
        this.debugObserver.clearData();
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

        Level_1_Task level1Task = new Level_1_Task(this);
        level1Task.attach(this.debugObserver);

        Level_2_Task level2Task = new Level_2_Task(this);
        level2Task.attach(this.debugObserver);

        BossLevel_Task bossLevel = new BossLevel_Task(this);
        bossLevel.attach(this.debugObserver);

        if (this.runningLevel == 1) {
            this.runningLevel = 2;
            (this.timer = new Timer()).scheduleAtFixedRate(level2Task, 1000L, 600L);
            //(this.timer = new Timer()).scheduleAtFixedRate(bossLevel, 1000L, 600L);
        } else if (this.runningLevel == 2) {
            this.runningLevel = 3;
            (this.timer = new Timer()).scheduleAtFixedRate(bossLevel, 1000L, 600L);
            //(this.timer = new Timer()).scheduleAtFixedRate(level1Task, 1000L, 600L);
        }
        else {
            if (!this.gameMusic.isPlaying()) {
                this.gameMusic.playLoop();
            }
            this.runningLevel = 1;
            (this.timer = new Timer()).scheduleAtFixedRate(level1Task, 1000L, 600L);
            //(this.timer = new Timer()).scheduleAtFixedRate(bossLevel, 1000L, 600L);
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
        this.debugObserver.clearData();
    }
    
    public void showPlayer(final boolean b) {
        this.player.showPlayer(b);
        this.lifeObserver.showState(b);
    }
}