package hu.meza.vcsheatmap;

public class ScoreEntry implements Comparable {

    private String fileName;
    private Integer score;

    public ScoreEntry(String fileName, Integer score) {
        this.fileName = fileName;
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "ScoreEntry{" +
            "fileName='" + fileName + '\'' +
            ", score=" + score +
            '}';
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(getScore(), ((ScoreEntry) o).getScore());
    }
}
