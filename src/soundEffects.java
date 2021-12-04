public class soundEffects implements Sound {
    
    GameWorld gw;
    public soundEffects(){}
    
    public soundEffects(GameWorld gw){
        this.gw = gw;
    }
    
    @Override
    public void volumeUp() {
        if(gw.soundeffects < 100){
            gw.soundeffects  += 5;
            (gw.gameMusic).setVolume(gw.soundeffects);
        }
    }

    @Override
    public void volumeDown() {
        if(gw.soundeffects  > 0){
            gw.soundeffects  -= 5;
            (gw.gameMusic).setVolume(gw.soundeffects);
        }
    }
}
