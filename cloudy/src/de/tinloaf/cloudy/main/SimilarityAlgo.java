package de.tinloaf.cloudy.main;

import java.util.Map;
import java.util.Vector;

import wordcram.Word;
import de.tinloaf.cloudy.utils.UnorderedPair;

public interface SimilarityAlgo {
	public void initialize(String text, Map<String, Word> strToWord, Vector<Word> words);
	public void run();
	
	public Map<UnorderedPair<Word,Word>, Double> getSimilarity();
}
