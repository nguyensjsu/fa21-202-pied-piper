import java.util.Collection;
import java.util.TimerTask;
import java.util.List;
import greenfoot.Greenfoot;
import greenfoot.Actor;
import greenfoot.GreenfootSound;
import java.util.Timer;
import greenfoot.World;
import greenfoot.GreenfootImage;
import greenfoot.Color;

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
    GreenfootSound introMusic  = new GreenfootSound("sanxion.mp3");
    GreenfootSound gameMusic = new GreenfootSound("delta.mp3");

    // Roger - Added life observer
    IObserver lifeObserver;
    
    // Sid - Initialized variables and instantiated objects for Settings Screen 
    int bgmusic = 100;
    int soundeffects = 100;
    private static final int SETTINGS_SCREEN = 5;
    Button plus; 
    Button minus;
    Button plus1;
    Button minus1;
    
    public GameWorld() {
        super(600, 400, 1, false);
        this.runningLevel = -1;
        this.d = 0.0;
        this.playerLives = 3;
        this.gameState = 3;
        this.prepare();
        prepare();
    }
    
    private void prepare() {
        this.addObject((Actor)new Space(), 0, 200);
        this.addObject((Actor)new Space(), 600, 200);

        (this.introMusic).setVolume(bgmusic);
        (this.gameMusic).setVolume(soundeffects);

        this.addObject((Actor)(this.startScreen = new StartScreen()), 300, 200);
        this.addObject((Actor)(this.player = new Player()), 83, 215);

        // Roger - Create and attach life oberserver
        this.addObject((Actor)(this.lifeObserver =
                new LifeObserver(this.player, this.playerLives)), 300, 50);
        this.player.attach(this.lifeObserver);
        this.showPlayer(false);

        // Sid - Initialization of buttons for Settings Screen
        
        this.plus = new Button("plus.png", this, "bgmusic", 5);
        this.minus = new Button("minus.png", this, "bgmusic", -5);
        this.plus1 = new Button("plus.png", this, "soundeffects", 5);
        this.minus1 = new Button("minus.png", this, "soundeffects", -5);
        
        final Class[] x = { Button.class, Explosion.class, Player.class, Laser.class, Ufo.class, StartScreen.class, Moon.class};
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
                if (Greenfoot.isKeyDown("space")) {
                    this.gameState = 4;
                    this.removeObject((Actor)this.startScreen);
                    this.showPlayer(false);
                    if (this.introMusic.isPlaying()) {
                        this.introMusic.stop();
                    }
                    break;
                }
                if (Greenfoot.isKeyDown("s")){
                    this.gameState = 5;
                    break;
                }
                break;
            }
            case 4: {
                this.startNewLevel();
                this.gameState = 1;
                break;
            }
            case 5: {
                this.displaysettings();
                this.addButtons();
                if (Greenfoot.isKeyDown("escape")){
                    this.backtoStart();
                    break;
                }
                break;
            }
        }
    }
    
    public void endGame() {
        this.showPlayer(false);
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
        } else if (this.runningLevel == 2) {
            this.runningLevel = 3;
            (this.timer = new Timer()).scheduleAtFixedRate(new BossLevel_Task(this), 1000L, 600L);
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
        this.lifeObserver.showState(b);
    }
    
    // Sid - added methods to support functioning of settings page
    
    // This method displays the content of Settings Screen
    public void displaysettings(){
        final List l = this.getObjects((Class)StartScreen.class);
        if (!l.isEmpty()) {
            this.removeObjects((Collection)l);
        }
        this.addObject((Actor)new SettingsScreen(), 300, 200);
    }
    
    // This method is used to navigate back to StartScreen
    public void backtoStart(){
        final List l = this.getObjects((Class)SettingsScreen.class);
        final List l1 = this.getObjects((Class)Button.class);
        if (!l.isEmpty() && !l1.isEmpty()) {
            this.removeObjects((Collection)l);
            this.removeObjects((Collection)l1);
        }
        this.gameState = 3;
        this.addObject((Actor)this.startScreen, 300, 200);
        this.runningLevel = -1;
        this.playerLives = 3;
    }
    
    // This method is used to add buttons to adjust Sound
    public void addButtons(){
        final List l = this.getObjects((Class)Button.class);
        if (!l.isEmpty()) {
            this.removeObjects((Collection)l);
        }
        addObject(minus, 400, 150);
        addObject(plus, 500, 150);
        addObject(minus1, 400, 250);
        addObject(plus1, 500, 250);
        GreenfootImage text = new GreenfootImage(String.valueOf(bgmusic), 25, Color.WHITE, null, Color.WHITE);
        Button t = new Button(text);
        GreenfootImage text1 = new GreenfootImage(String.valueOf(soundeffects), 25, Color.WHITE, null, Color.WHITE);
        Button t1 = new Button(text1);
        addObject(t, 450, 150);
        addObject(t1, 450, 250);
    }
    
    // End of Methods for Settings Screen - Sid
}
