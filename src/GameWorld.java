import java.util.Collection;
import java.util.TimerTask;
import java.util.List;
import java.util.Timer;
import java.util.EnumMap;
import greenfoot.Greenfoot;
import greenfoot.Actor;
import greenfoot.GreenfootSound;
import greenfoot.World;
import greenfoot.GreenfootImage;
import greenfoot.Color;
import java.util.LinkedHashMap;
import javax.swing.*;
import java.util.ArrayList;
import java.util.*;


// Decompiled by Procyon v0.5.36
// 

public class GameWorld extends World implements ISubject, IObserver
{
    int runningLevel;
    double d;
    Timer timer;
    Player player;
    int gameState;
    StartScreen startScreen;

    private static final int RUNNING = 1;
    private static final int GAMEOVER_SCREEN = 2;
    private static final int START_SCREEN = 3;
    private static final int BETWEEN_LEVELS = 4;
    private static final int SETTINGS_SCREEN = 5;
    private static final int FINISH_SCREEN = 6;
    private static final int TRANSITION_SCREEN = 7;
    private static final int LEADERBOARD_SCREEN = 8;

    // lives and score tracking
    int playerLives;
    int playerScore;
    private LifeObserver lifeObserver;
    private ScoreObserver scoreObserver;
    private enum Observer {
        LIFE, SCORE
    }
    private EnumMap<Observer, IObserver> obsMap = new EnumMap<>(Observer.class);

    // debug overlay mechanism
    private IDebugObserver debugObserver;

    // Sound Settings
    public int bgMusic;
    public int soundEffects;
    private Label bgMusicPlus;
    private Label bgMusicMinus;
    private Label soundEffectsPlus;
    private Label soundEffectsMinus;
    Sound seSound;
    Sound bgSound;
    ChangeVolSE seCommand;
    ChangeVolBG bgCommand;
    GreenfootSound introMusic  = new GreenfootSound("sanxion.mp3");
    GreenfootSound gameMusic = new GreenfootSound("delta.mp3");

    // Transition Screen
    String playerAlias;
    JFrame jFrame;

    // Leaderboard
    LinkedHashMap<Integer, String> leaderBoard;
    LinkedHashMap<String, String> sortedleaderBoard;
    ArrayList<Integer> sortedKeys;
    LeaderBoardIterator iter;
    int lastPositionScore;

    public GameWorld() {
        super(600, 400, 1, false);
        this.runningLevel = -1;
        this.d = 0.0;
        this.playerLives = 3;
        this.playerScore = 0;
        this.gameState = START_SCREEN;
        this.prepare();
    }

    private void prepare() {
        this.addObject((Actor)new Space(), 0, 200);
        this.addObject((Actor)new Space(), 600, 200);

        this.bgMusic = 20;
        this.soundEffects = 20;
        (this.introMusic).setVolume(this.bgMusic);
        (this.gameMusic).setVolume(this.soundEffects);

        this.addObject((Actor)(this.startScreen = new StartScreen()), 300, 200);
        this.addObject((Actor)(this.player = new Player()), 83, 215);

        // Roger - Create and attach life and score observers
        this.addObject((Actor)(this.lifeObserver =
                new LifeObserver(this, this.playerLives)), 175, 50);
        this.attach(Observer.LIFE, this.lifeObserver);
        this.addObject((Actor)(this.scoreObserver =
                new ScoreObserver(this, this.playerScore)), 325, 50);
        this.attach(Observer.SCORE, this.scoreObserver);
        this.showPlayer(false);

        this.addObject((Actor)(this.debugObserver = new DebugObserver()), 500, 50);
        this.player.setDebugObserver(this.debugObserver);

        // Sid - Initialization of buttons for Settings Screen
        seSound = SoundType.getSoundType("se", this);
        bgSound = SoundType.getSoundType("bg", this);
        seCommand = new ChangeVolSE(seSound);
        bgCommand = new ChangeVolBG(bgSound);
        this.bgMusicPlus = new Label("plus.png", this, "up", bgCommand);
        this.bgMusicMinus = new Label("minus.png", this, "down", bgCommand);
        this.soundEffectsPlus = new Label("plus.png", this, "up", seCommand);
        this.soundEffectsMinus = new Label("minus.png", this, "down", seCommand);

        //Sid - Initialization of Hash Maps for Leaderboard
        this.leaderBoard = new LinkedHashMap();
        this.sortedleaderBoard = new LinkedHashMap();
        this.lastPositionScore = 0;

        final Class[] x = {LeaderboardScreen.class, Label.class, Explosion.class, Player.class, Laser.class, Ufo.class, StartScreen.class, SettingsScreen.class, Moon.class};
        this.setPaintOrder(x);
    }
    
    public void act() {
        switch (this.gameState) {
            case GAMEOVER_SCREEN: {

                final List l = this.getObjects((Class)GameOverScreen.class);
                if (l.isEmpty()) {
                    if (playerScore > this.lastPositionScore){
                        this.gameState = TRANSITION_SCREEN;
                        break;
                    }
                    else {
                        this.gameState = LEADERBOARD_SCREEN;
                        break;
                    }
                }
                break;
            }
            case START_SCREEN: {

                if (!this.introMusic.isPlaying()) {
                    this.introMusic.play();
                }
                if (Greenfoot.isKeyDown("space")) {
                    this.gameState = BETWEEN_LEVELS;
                    this.removeObject((Actor)this.startScreen);
                    this.showPlayer(false);
                    if (this.introMusic.isPlaying()) {
                        this.introMusic.stop();
                    }
                    break;
                }
                if (Greenfoot.isKeyDown("s")) {
                    this.gameState = SETTINGS_SCREEN;
                    break;
                }
                break;
            }
            case BETWEEN_LEVELS: {
                this.startNewLevel();
                this.gameState = RUNNING;
                break;
            }
            case SETTINGS_SCREEN: {
                this.displaysettings();
                this.addButtons();
                if (Greenfoot.isKeyDown("escape")) {
                    this.backtoStart();
                    break;
                }
                break;
            }
            case FINISH_SCREEN: {

                // Finish Screen (The Screen that is displayed when you pass all the levels)

                final List l = this.getObjects((Class)FinishScreen.class);
                if (l.isEmpty()) {
                    if(playerScore > this.lastPositionScore){
                        this.gameState = TRANSITION_SCREEN;
                        break;
                    }
                    else{
                        this.gameState = LEADERBOARD_SCREEN;
                        break;
                    }
                }
                break;
            }
            case TRANSITION_SCREEN: {

                this.playerAlias = JOptionPane.showInputDialog(jFrame,"Enter your Name for the Leaderboard!");
                this.playerAlias = this.playerAlias.substring(0,3).toUpperCase();
                this.gameState = LEADERBOARD_SCREEN;
                this.addObject((Actor)new TransitionScreen(playerAlias, playerScore), 300, 200);
                break;
            }
            case LEADERBOARD_SCREEN: {

                this.leaderBoard.put(playerScore, playerAlias);
                this.sortedKeys = new ArrayList<Integer>(leaderBoard.keySet());
                Collections.sort(sortedKeys, Collections.reverseOrder());
                if(sortedKeys.size() < 10) {
                    this.lastPositionScore = 0;
                }
                else {
                    this.lastPositionScore = sortedKeys.get(sortedKeys.size()-1);
                }
                for (int x : sortedKeys) {
                    this.sortedleaderBoard.put(String.valueOf(x), leaderBoard.get(x));
                }
                this.iter = new LeaderBoardIterator(this.sortedleaderBoard);
                final List l = this.getObjects((Class)Ufo.class);
                if (!l.isEmpty()) {
                    this.removeObjects((Collection)l);
                }
                this.showPlayer(false);
                this.addObject((Actor)new LeaderboardScreen(iter), 300, 200);
                this.sortedleaderBoard.clear();
                if(Greenfoot.isKeyDown("escape")) {
                    this.timer.cancel();
                    this.resetGame();
                    this.gameState = START_SCREEN;
                    break;
                }
                break;
            }
        }
    }
    
    public void endGame() {
        this.showPlayer(false);
        this.debugObserver.clearData();
        if(playerLives == 0) {
            this.addObject((Actor)new GameOverScreen(), 300, 200);
            this.gameState = GAMEOVER_SCREEN;
        }
        else {
            this.addObject((Actor)new FinishScreen(), 300, 200);
            this.gameState = FINISH_SCREEN;
        }
        if (this.gameMusic.isPlaying()) {
            this.gameMusic.stop();
        }
        final GreenfootSound swoosh = new GreenfootSound("swoosh.mp3");
        swoosh.setVolume(this.soundEffects);
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
        } else if (this.runningLevel == 2) {
            this.runningLevel = 3;
            (this.timer = new Timer()).scheduleAtFixedRate(bossLevel, 1000L, 600L);
        }
        else {
            if (!this.gameMusic.isPlaying()) {
                this.gameMusic.playLoop();
            }
            this.runningLevel = 1;
            (this.timer = new Timer()).scheduleAtFixedRate(level1Task, 1000L, 600L);
        }
    }
    
    public void takeLife() {
        // Deduct life point
        --this.playerLives;
        this.notifyObservers(Observer.LIFE);
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
        this.gameState = BETWEEN_LEVELS;
    }
    
    public void resetGame() {
        final List l = this.getObjects((Class)LeaderboardScreen.class);
        if (!l.isEmpty()) {
            this.removeObjects((Collection)l);
        }
        this.gameState = START_SCREEN;
        this.addObject((Actor)this.startScreen, 300, 200);
        this.runningLevel = -1;
        this.playerLives = 3;
        this.playerScore = 0;
        this.debugObserver.clearData();
        // Update/reset life observer
        this.notifyObservers(Observer.LIFE);
        this.notifyObservers(Observer.SCORE);
        this.showPlayer(false);
    }
    
    public void showPlayer(final boolean b) {
        this.player.showPlayer(b);
        this.lifeObserver.showState(b);
        this.scoreObserver.showState(b);
    }

    // New method for player score and lives

    public int getScore() {
        return this.playerScore;
    }

    public int getLives() {
        return this.playerLives;
    }

    private void updateScore(int num) {
        this.playerScore += num;
        this.notifyObservers(Observer.SCORE);
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
        final List l1 = this.getObjects((Class)Label.class);
        if (!l.isEmpty() && !l1.isEmpty()) {
            this.removeObjects((Collection)l);
            this.removeObjects((Collection)l1);
        }
        this.gameState = START_SCREEN;
        this.addObject((Actor)this.startScreen, 300, 200);
        this.runningLevel = -1;
        this.playerLives = 3;
    }
    
    // This method is used to add buttons to adjust Sound
    public void addButtons(){
        final List l = this.getObjects((Class)Label.class);
        if (!l.isEmpty()) {
            this.removeObjects((Collection)l);
        }
        addObject(bgMusicMinus, 400, 160);
        addObject(bgMusicPlus, 500, 160);
        addObject(soundEffectsMinus, 400, 230);
        addObject(soundEffectsPlus, 500, 230);
        Label bgMusicLevelLabel = new Label("bg", this.bgMusic);
        Label soundEffectsLevelLabel = new Label("se", this.soundEffects);
        addObject(bgMusicLevelLabel, 450, 160);
        addObject(soundEffectsLevelLabel, 450, 230);
    }
    
    // End of Methods for Settings Screen - Sid

    // ROGER - Observer Pattern
    // As the Subject
    public void attach(IObserver obj) {
        // Empty
    }

    public void attach(Observer o, IObserver obj) {
        obsMap.put(o, obj);
    }

    public void detach(IObserver obj) {
        // Empty
    }

    public void notifyObservers() {
        // Empty
    }

    public void notifyObservers(Enum o) {
        obsMap.get(o).update();
    }

    // As the Observer
    public void update() {
    }

    public void update(int num) {
        this.updateScore(num);
    }

    public void showState(final boolean b) {
    }
    // END - ROGER - Observer Pattern
}
