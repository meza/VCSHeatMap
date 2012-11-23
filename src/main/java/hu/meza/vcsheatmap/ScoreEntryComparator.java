package hu.meza.vcsheatmap;

import java.util.Comparator;

class ScoreEntryComparator implements Comparator<ScoreEntry> {

    @Override
    public int compare(ScoreEntry o1, ScoreEntry o2) {
        if (o1.getScore() > o2.getScore()) {
            return -1;
        }
        if (o1.getScore() < o2.getScore()) {
            return 1;
        }

        return o1.getFileName().compareTo(o2.getFileName());
    }

}
