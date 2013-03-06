package de.tinloaf.cloudy.main;

import java.util.Collections;
import java.util.Vector;

import wordcram.Word;
import wordcram.WordCounter;
import wordcram.WordSorterAndScaler;

public class WordCramWordifier {

	public Vector<Word> getWords(String text) {
		Word[] words = new WordCounter().count(text);
        words = new WordSorterAndScaler().sortAndScale(words);

		Vector<Word> ret = new Vector<Word>();
		Collections.addAll(ret, words);
		
		return ret;
	}
}
