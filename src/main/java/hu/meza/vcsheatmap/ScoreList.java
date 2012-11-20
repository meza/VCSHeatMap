package hu.meza.vcsheatmap;

import java.util.PriorityQueue;

public class ScoreList {

	PriorityQueue<ScoreEntry> score = new PriorityQueue<ScoreEntry>();

	public void add(String s, Integer integer) {
		score.add(new ScoreEntry(s, integer));
	}

//	public List<ScoreEntry> getScore() {
//		Comparator<ScoreEntry> comp = new Comparator<ScoreEntry>() {
//			@Override
//			public int compare(ScoreEntry o1, ScoreEntry o2) {
//				return Integer.compare(o1.getScore(), o2.getScore());
//			}
//		};
//
//	}

	@Override
	public String toString() {
		return "ScoreList{" +
		"score=" + score +
		'}';
	}
}
