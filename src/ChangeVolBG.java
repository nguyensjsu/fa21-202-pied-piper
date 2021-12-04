public class ChangeVolBG implements Command{
    Sound theDevice;

    public ChangeVolBG(Sound newDevice){
        theDevice = newDevice;
    }
    @Override
    public void execute() {
        theDevice.volumeUp();
    }
    public void undo(){theDevice.volumeDown();}
}
