package de.tinloaf.cloudy.similarity;

import java.util.Map;
import java.util.Vector;

import wordcram.Word;
import de.tinloaf.cloudy.main.SimilarityAlgo;
import de.tinloaf.cloudy.utils.UnorderedPair;

public class CosineAlgo implements SimilarityAlgo {
	private String text;
	private Map<String, Word> strToWord;
	private Vector<Word> words;
	
	@Override
	public void initialize(String text, Map<String, Word> strToWord,
			Vector<Word> words) {
		this.text = text;
		this.strToWord = strToWord;
		this.words = words;
	}

	@Override
	public void run() {
		
	}

	@Override
	public Map<UnorderedPair<Word, Word>, Double> getSimilarity() {
		// TODO Auto-generated method stub
		return null;
	}

}
