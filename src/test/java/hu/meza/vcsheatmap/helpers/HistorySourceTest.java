package hu.meza.vcsheatmap.helpers;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HistorySourceTest {

	private HistorySource historySource;

	@Before
	public void setUp() {
		historySource = new HistorySource();
	}

	@Test
	public void testHistory() {
		List<HashMap<String, String>> history = new ArrayList<HashMap<String, String>>();

		HashMap<String, String> entries = new HashMap<String, String>();
		entries.put("a", "b");
		entries.put("c", "d");
		history.add(entries);

		historySource.add(entries);
		Assert.assertEquals(history, historySource.get());

	}

}
