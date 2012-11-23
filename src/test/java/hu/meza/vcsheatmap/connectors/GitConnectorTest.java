package hu.meza.vcsheatmap.connectors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.jgit.api.errors.GitAPIException;
import org.junit.Test;

import hu.meza.vcsheatmap.ScoreCalculator;
import hu.meza.vcsheatmap.ScoreList;

public class GitConnectorTest {
    @Test
    public void testName() throws IOException, GitAPIException {
        GitConnector gc = new GitConnector();
        ScoreCalculator sc = new ScoreCalculator();

        List<Map<String, String>> history = gc.browse("/home/meza/dev/workspace/VCSHeatMap", 0);
        List<Map<String, String>> history2 = new ArrayList<Map<String, String>>(history);


        ScoreList x = sc.getScoreFor(history2);

        System.out.println(x);

    }
}
