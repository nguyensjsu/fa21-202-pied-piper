import java.util.*;
class LeaderBoard{
    LeaderBoardIterator leaderBoardIterator;
    LeaderBoard(LeaderBoardIterator l){
        leaderBoardIterator = l;
    }
    public void showLeaderBoard(){
        while(leaderBoardIterator.hasMore() == true){
            System.out.println(leaderBoardIterator.nextItem());
        }
    }
}