package hu.meza.vcsheatmap;

import java.util.*;

public class ScoreCalculator {

	private HashMap<String, Integer> score = new HashMap<String, Integer>();
	private HashMap<String, Set<String>> collaborators = new HashMap<String, Set<String>>();

	public ScoreList getScoreFor(List<HashMap<String, String>> history) {
		ScoreList result = new ScoreList();

		for (HashMap<String, String> changeset : history) {

			for (Map.Entry<String, String> entry : changeset.entrySet()) {
				if (score.containsKey(entry.getKey())) {
					Integer origScore = score.get(entry.getKey());
					score.put(entry.getKey(), ++origScore);
				} else {
					score.put(entry.getKey(), 1);
				}

				if (!collaborators.containsKey(entry.getKey())) {
					collaborators.put(entry.getKey(), new HashSet<String>());
				}
				collaborators.get(entry.getKey()).add(entry.getValue());

			}


			for (Map.Entry<String, Integer> scoreEntries : score.entrySet()) {


				if (!changeset.containsKey(scoreEntries.getKey())) {
					if (scoreEntries.getValue() <= 1) {
						score.remove(scoreEntries.getKey());
					} else {
						Integer o = scoreEntries.getValue();
						score.put(scoreEntries.getKey(), --o);
					}
				} else {
					if (collaborators.get(scoreEntries.getKey()).size() > 1) {

						final Integer orig = scoreEntries.getValue();
						final Integer newx = orig + collaborators.get(scoreEntries.getKey()).size();
						score.put(scoreEntries.getKey(), newx);
					}
				}
			}
		}

		populateEndResult(result);


		return result;
	}

	private void populateEndResult(ScoreList result) {
		for (Map.Entry<String, Integer> scoreEntries : score.entrySet()) {
			result.add(scoreEntries.getKey(), scoreEntries.getValue());
		}
	}
}
