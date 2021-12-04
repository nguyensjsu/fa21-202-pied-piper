public class ChangeVolSE implements Command{
    Sound theDevice;

    public ChangeVolSE(Sound newDevice){
        theDevice = newDevice;
    }
    @Override
    public void execute() {
        theDevice.volumeUp();
    }
    public void undo(){theDevice.volumeDown();}
}