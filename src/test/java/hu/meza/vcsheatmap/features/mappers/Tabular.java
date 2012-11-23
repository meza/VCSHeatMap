package hu.meza.vcsheatmap.features.mappers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import hu.meza.vcsheatmap.ScoreCalculator;
import hu.meza.vcsheatmap.ScoreList;
import hu.meza.vcsheatmap.helpers.HistorySource;

public class Tabular {

    private HistorySource historySource;
    private ScoreCalculator scoreCalculator;

    public Tabular(HistorySource historySource, ScoreCalculator scoreCalculator) {
        this.historySource = historySource;
        this.scoreCalculator = scoreCalculator;
    }

    @Given("^a history$")
    public void aHistory(DataTable history) {
        for (List<String> row : history.raw()) {
            Map<String, String> x = new HashMap<String, String>();
            String[] files = row.get(0).split("\\*");
            for (String file : files) {
                x.put(file, row.get(1));
            }
            historySource.add(x);
        }
    }

    @Then("^the score is$")
    public void assertScore(List<List<String>> expectedScoreTable) {
        List<Map<String, String>> history = historySource.get();
        ScoreList actualScore = scoreCalculator.getScoreFor(history);
        ScoreList scoreList = new ScoreList();
        for (List<String> x : expectedScoreTable) {

            scoreList.add(x.get(0), Integer.valueOf(x.get(1)));
        }

        Assert.assertEquals(scoreList.toString(), actualScore.toString());

    }
}
