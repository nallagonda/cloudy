package de.tinloaf.cloudy.similarity;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class SentenceUtil {
	public Map<String, List<Integer>> strToSentenceIndices(String text) {
		InputStream modelIn1 = new FileInputStream("opennlp/models/en-sent.bin");
		SentenceModel model1 = null;
		try {
			model1 = new SentenceModel(modelIn1);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (modelIn1 != null) {
				try {
					modelIn1.close();
				} catch (IOException e) {
				}
			}
		}
		SentenceDetectorME sentenceDetector = new SentenceDetectorME(model1);

		// Initialize the tokenizer
		InputStream modelIn2 = new FileInputStream(
				"opennlp/models/en-token.bin");
		TokenizerModel model2 = null;
		try {
			model2 = new TokenizerModel(modelIn2);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (modelIn2 != null) {
				try {
					modelIn2.close();
				} catch (IOException e) {
				}
			}
		}
		TokenizerME tokenizer = new TokenizerME(model2);

		// Split into sentences
		String sentences[] = sentenceDetector.sentDetect(text);
		
		for (int i = 0; i < sentences.length; i++) {
			String[] temp = tokenizer.tokenize(sentences[i]);
			ArrayList<String> tempList = new ArrayList<String>();
			for (int j = 0; j < temp.length; j++) {
				temp[j] = temp[j].toLowerCase();
				if (!Character.isLetter(temp[j].charAt(0)))
					continue;
				if (stopWords.contains(temp[j] + ","))
					continue;
				tempList.add(temp[j]);
			}
			words.add(i, tempList);
		}

}
