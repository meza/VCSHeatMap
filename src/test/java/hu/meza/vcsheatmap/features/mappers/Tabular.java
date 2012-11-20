package hu.meza.vcsheatmap.features.mappers;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import hu.meza.vcsheatmap.ScoreCalculator;
import hu.meza.vcsheatmap.ScoreList;
import hu.meza.vcsheatmap.helpers.HistorySource;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;

public class Tabular {

	private HistorySource historySource;
	private ScoreCalculator scoreCalculator;

	public Tabular(HistorySource historySource, ScoreCalculator scoreCalculator) {
		this.historySource = historySource;
		this.scoreCalculator = scoreCalculator;
	}

	@Given("^a history$")
	public void a_history(DataTable history) {
		for (List<String> row : history.raw()) {
			HashMap<String, String> x = new HashMap<String, String>();
			String[] files = row.get(0).split("\\*");
			for (String file : files) {
				x.put(file, row.get(1));
			}
			historySource.add(x);
		}
	}

	@Then("^the score is$")
	public void the_score_is(List<List<String>> expectedScoreTable) {
		List<HashMap<String, String>> history = historySource.get();
		ScoreList actualScore = scoreCalculator.getScoreFor(history);
		ScoreList scoreList = new ScoreList();
		for (List<String> x : expectedScoreTable) {

			scoreList.add(x.get(0), Integer.valueOf(x.get(1)));
		}

		Assert.assertEquals(scoreList.toString(), actualScore.toString());

	}
}
