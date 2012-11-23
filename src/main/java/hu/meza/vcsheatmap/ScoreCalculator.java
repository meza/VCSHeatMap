package hu.meza.vcsheatmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ScoreCalculator {

    private Map<String, Integer> score = new ConcurrentHashMap<String, Integer>();
    private Map<String, Set<String>> collaborators = new HashMap<String, Set<String>>();

    public ScoreList getScoreFor(List<Map<String, String>> history) {

        for (Map<String, String> changeset : history) {
            processChangeset(changeset, score, collaborators);
        }

        return endResult(score.entrySet());
    }

    private void processChangeset(Map<String, String> changeset, Map<String, Integer> scoreTable, Map<String, Set<String>> collabs) {
        for (Map.Entry<String, String> entry : changeset.entrySet()) {
            updateScoreForFile(entry, scoreTable);
            addCollaboratorsForFile(entry, collabs);
        }

        for (Map.Entry<String, Integer> scoreEntries : scoreTable.entrySet()) {
            if (!changeset.containsKey(scoreEntries.getKey())) {
                if (scoreEntries.getValue() <= 1) {
                    scoreTable.remove(scoreEntries.getKey());
                } else {
                    Integer o = scoreEntries.getValue();
                    scoreTable.put(scoreEntries.getKey(), --o);
                }
            }
        }

        adjustScoreRegardingCollaborators(changeset, scoreTable, collabs);
    }

    private void addCollaboratorsForFile(Map.Entry<String, String> entry, Map<String, Set<String>> collabs) {
        if (!collabs.containsKey(entry.getKey())) {
            collabs.put(entry.getKey(), new HashSet<String>());
        }
        collabs.get(entry.getKey()).add(entry.getValue());
    }

    private void updateScoreForFile(Map.Entry<String, String> entry, Map<String, Integer> scoreTable) {
        if (scoreTable.containsKey(entry.getKey())) {
            Integer origScore = scoreTable.get(entry.getKey());
            scoreTable.put(entry.getKey(), ++origScore);
        } else {
            scoreTable.put(entry.getKey(), 1);
        }
    }

    private void adjustScoreRegardingCollaborators(Map<String, String> changeset, Map<String, Integer> scoreTable, Map<String, Set<String>> collabs) {
        for (Map.Entry<String, Integer> scoreEntries : scoreTable.entrySet()) {
            if (collabs.get(scoreEntries.getKey()).size() > 1) {
                final Integer orig = scoreEntries.getValue();
                final Integer newx = orig + collabs.get(scoreEntries.getKey()).size();
                scoreTable.put(scoreEntries.getKey(), newx);
            }
        }
    }

    private ScoreList endResult(Set<Map.Entry<String, Integer>> entries) {
        ScoreList result = new ScoreList();
        for (Map.Entry<String, Integer> scoreEntries : entries) {
            result.add(scoreEntries.getKey(), scoreEntries.getValue());
        }
        return result;
    }
}
