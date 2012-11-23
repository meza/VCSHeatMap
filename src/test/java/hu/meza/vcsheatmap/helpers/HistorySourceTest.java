package hu.meza.vcsheatmap.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class HistorySourceTest {

    private HistorySource historySource;

    @Before
    public void setUp() {
        historySource = new HistorySource();
    }

    @Test
    public void testHistory() {
        List<Map<String, String>> history = new ArrayList<Map<String, String>>();

        Map<String, String> entries = new HashMap<String, String>();
        entries.put("a", "b");
        entries.put("c", "d");
        history.add(entries);

        historySource.add(entries);
        Assert.assertEquals(history, historySource.get());

    }

}
