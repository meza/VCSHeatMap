package hu.meza.vcsheatmap;

import java.util.List;
import java.util.Map;

import hu.meza.vcsheatmap.connectors.GitConnector;

public class VCSHeatMap {

    GitConnector gc = new GitConnector();
    ScoreCalculator sc = new ScoreCalculator();
    private String location;
    private Integer depth = 0;

    public VCSHeatMap(String location) {

        this.location = location;
    }

    public VCSHeatMap(String location, Integer depth) {

        this.location = location;
        this.depth = depth;
    }

    public void work() {
        try {
            List<Map<String, String>> history = gc.browse(location, depth);
            ScoreList result = sc.getScoreFor(history);
            System.out.println(result.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please specify a path");

        } else if (args.length > 1) {
            VCSHeatMap hm = new VCSHeatMap(args[0], Integer.valueOf(args[1]));
            hm.work();
        } else {
            VCSHeatMap hm = new VCSHeatMap(args[0]);
            hm.work();
        }
    }

}


