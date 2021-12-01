import greenfoot.Actor;
import greenfoot.Color;
import greenfoot.GreenfootImage;

import java.util.HashMap;
import java.util.Map;

public class DebugObserver extends Actor implements IDebugObserver {

    private Map<String,Object> debugData;
    private boolean enableVisibility;

    public DebugObserver() {
        this.debugData = new HashMap<>();
        this.enableVisibility = false;
        this.setImage("empty.png");
    }

    @Override
    public void setEnableVisibility(boolean enableVisibility) {
        this.enableVisibility = enableVisibility;
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
        if (this.enableVisibility) {
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
        } else {
            this.setImage("empty.png");
        }
    }

    @Override
    public void clearData() {
        debugData.clear();
        this.setImage("empty.png");
    }
}
