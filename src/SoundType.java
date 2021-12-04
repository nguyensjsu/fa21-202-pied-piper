public class SoundType {
    public static Sound getSoundType(String type, GameWorld gw){
        if(type == "bg")
        {
            return new bgMusic(gw);
        }
        else 
        {
            return new soundEffects(gw);
        }
        
    }
}
