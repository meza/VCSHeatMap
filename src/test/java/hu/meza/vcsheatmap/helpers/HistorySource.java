package hu.meza.vcsheatmap.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HistorySource {
    private List<Map<String, String>> history = new ArrayList<Map<String, String>>();

    public void add(Map<String, String> entries) {
        history.add(entries);
    }

    public List<Map<String, String>> get() {
        return history;
    }
}
