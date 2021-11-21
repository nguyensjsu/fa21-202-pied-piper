import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.GreenfootImage;

import java.util.HashMap;
import java.util.Map;

public class DebugObserver extends Actor implements IDebugObserver {

    Map<String,Object> debugData;

    public DebugObserver() {
        debugData = new HashMap<>();
        this.setImage("empty.png");
    }

    @Override
    public Map<String,Object> getData() {
        return debugData;
    }

    @Override
    public void update(String key, Integer val) {
        //debugData.computeIfPresent(key, (k,v) -> (Integer) v + val);
        Integer v = (Integer) debugData.getOrDefault(key, 0);
        v += val;
        debugData.put(key, v);
        this.showData();
    }

    @Override
    public void update(Map<String, Object> data) {
        this.debugData = data;
        this.showData();
    }

    @Override
    public void showData() {
        StringBuffer sb = new StringBuffer("DEBUG DATA:\n");
        if (!debugData.isEmpty()) {
            debugData.forEach((key, val) -> {
                sb.append(key);
                sb.append(" : ");
                sb.append(val);
                sb.append("\n");
            });
        } else {
            sb.append("-empty-");
        }
        this.setImage(
                new GreenfootImage(
                        sb.toString(), 20,
                        Color.ORANGE, null, Color.WHITE));
    }

    @Override
    public void clearData() {
        debugData.clear();
        this.setImage("empty.png");
    }
}
