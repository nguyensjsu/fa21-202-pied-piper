public class bgMusic implements Sound {

    GameWorld gw;
    public bgMusic(){}
    
    public bgMusic(GameWorld gw){
        this.gw = gw;
    }
    
    @Override
    public void volumeUp() {
        if(gw.bgmusic < 100){
            gw.bgmusic += 5;
            (gw.introMusic).setVolume(gw.bgmusic);
        }
    }

    @Override
    public void volumeDown() {
        if(gw.bgmusic > 0){
            gw.bgmusic -= 5;
            (gw.introMusic).setVolume(gw.bgmusic);
        }
    }
}
