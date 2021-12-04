public class soundEffects implements Sound {
    
    GameWorld gw;
    public soundEffects(){}
    
    public soundEffects(GameWorld gw){
        this.gw = gw;
    }
    
    @Override
    public void volumeUp() {
        if(gw.soundEffects < 100){
            gw.soundEffects  += 5;
            (gw.gameMusic).setVolume(gw.soundEffects);
        }
    }

    @Override
    public void volumeDown() {
        if(gw.soundEffects  > 0){
            gw.soundEffects  -= 5;
            (gw.gameMusic).setVolume(gw.soundEffects);
        }
    }
}
