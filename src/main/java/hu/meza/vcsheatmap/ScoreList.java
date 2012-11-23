package hu.meza.vcsheatmap;

import java.util.PriorityQueue;
import java.util.Queue;

public class ScoreList {

    private Queue<ScoreEntry> score = new PriorityQueue<ScoreEntry>();

    public void add(String s, Integer integer) {
        score.add(new ScoreEntry(s, integer));
    }

    @Override
    public String toString() {
        return "ScoreList{" +
            "score=" + score +
            '}';
    }
}
