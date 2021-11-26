import java.util.*;
import java.lang.*;

class LeaderBoardIterator implements LeaderBoardNames{
    private int counter = 0;
    private LinkedHashMap<String, String> rawLb = new LinkedHashMap();
    private ArrayList<String> lb = new ArrayList<String>();
    LeaderBoardIterator(LinkedHashMap<String, String> inLb){
        rawLb = inLb;
        for(String k : rawLb.keySet()){
            lb.add(k);
        }
    }

    public boolean hasMore(){
        if(lb.size() > counter){
            return true;
        }
        else{
            return false;
        }
    }

    public LinkedHashMap<String, String> nextItem(){
        LinkedHashMap<String, String> item = new LinkedHashMap();
        item.put(lb.get(counter), rawLb.get(lb.get(counter)));
        counter++;
        return item;
    }
}