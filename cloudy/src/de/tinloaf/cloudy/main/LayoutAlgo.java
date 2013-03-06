package de.tinloaf.cloudy.main;

import java.awt.Point;
import java.awt.Polygon;
import java.util.Map;
import java.util.Vector;

import wordcram.Word;
import wordcram.WordPlacer;
import wordcram.WordShaper;
import de.tinloaf.cloudy.utils.UnorderedPair;

public interface LayoutAlgo {
	public void initialize(Vector<Word> words, Map<UnorderedPair<Word,Word>, Double> similarity);
	public void run();

	// WordCram interface
	public WordPlacer getPlacer();
	public WordShaper getShaper();
	
	// Metrics interface
	public Point getWordCenter(Word w);
	public Polygon getWordPoly(Word w);
}
