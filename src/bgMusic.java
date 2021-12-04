public class bgMusic implements Sound {

    GameWorld gw;
    public bgMusic(){}
    
    public bgMusic(GameWorld gw){
        this.gw = gw;
    }
    
    @Override
    public void volumeUp() {
        if(gw.bgMusic < 100){
            gw.bgMusic += 5;
            (gw.introMusic).setVolume(gw.bgMusic);
        }
    }

    @Override
    public void volumeDown() {
        if(gw.bgMusic > 0){
            gw.bgMusic -= 5;
            (gw.introMusic).setVolume(gw.bgMusic);
        }
    }
}
