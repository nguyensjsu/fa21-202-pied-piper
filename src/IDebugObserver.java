import java.util.Map;

public interface IDebugObserver {
    Map<String,Object> getData();
    void update(String key, Integer val);
    void update(Map<String,Object> data);
    void showData();
    void clearData();
}
