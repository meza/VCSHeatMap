package hu.meza.vcsheatmap.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HistorySource {
	private List<HashMap<String, String>> history = new ArrayList<HashMap<String, String>>();

	public void add(HashMap<String, String> entries) {
		history.add(entries);
	}

	public List<HashMap<String, String>> get() {
		return history;
	}
}
