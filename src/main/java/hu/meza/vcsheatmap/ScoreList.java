package hu.meza.vcsheatmap;

import java.util.SortedSet;
import java.util.TreeSet;

public class ScoreList {

    private SortedSet<ScoreEntry> score = new TreeSet<ScoreEntry>(new ScoreEntryComparator());

    public void add(String s, Integer integer) {
        score.add(new ScoreEntry(s, integer));
    }

    @Override
    public String toString() {
        return toPlainText();
    }

    private String toPlainText() {
        StringBuilder sb = new StringBuilder();
        sb.append("Heatmap:\n");

        for (ScoreEntry e : score) {
            sb.append(String.format("%d\t%s\n", e.getScore(), e.getFileName()));
        }
        return sb.toString();
    }
}
