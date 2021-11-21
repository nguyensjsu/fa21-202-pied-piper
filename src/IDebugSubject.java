import java.util.Map;

public interface IDebugSubject {
    void attach(IDebugObserver obj);
    void detach(IDebugObserver obj);
    void notifyObservers(Map<String,Object> data);
}
