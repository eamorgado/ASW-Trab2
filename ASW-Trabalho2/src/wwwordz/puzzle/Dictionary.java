package wwwordz.puzzle;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Locale;

import wwwordz.puzzle.Trie;
import wwwordz.puzzle.Trie.Search;

public class Dictionary {
	private static final String DICT_FILE = "wwwordz/puzzle/pt-PT-AO.dic";
	private static final String PAT = "[A-Z]+";
	private static final Dictionary dictionary = new Dictionary();
	private Trie trie = new Trie();
	
	
	private Dictionary() {
		try {
			InputStream stream = ClassLoader.getSystemResourceAsStream(DICT_FILE);
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream,"UTF-8"));
			
			String line;
			while((line = reader.readLine()) != null) {
				if(Character.isAlphabetic(line.charAt(0))) {
					String word = line.split("/|\\s+")[0];
					//Ignore words with less than 3 chars
					if(word.length() < 3) continue;
					
					//Ignore accent marks
					word = Normalizer.normalize(word.toUpperCase(Locale.ENGLISH),Form.NFD).
		            replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
					
					if(!isAlpha(word)) continue;
					trie.put(word);
				}
			}
			reader.close();
		}catch(Exception e) {
			e.printStackTrace(System.err);
		}
	}
	
	private boolean isAlpha(String name) {
	    return name.matches(PAT);
	}
	
	static Dictionary getInstance() {
		return dictionary;
	}
	
	String getRandomLargeWord() {
		return trie.getRandomLargeWord();
	}
	Search startSearch() {
		return trie.startSearch();
	}
}
