package co.uk.moj.modal;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

@Component
public class AnagramDataRepo {

	ArrayList<String> anagrams = new ArrayList<>();


	HashMap<String, ArrayList<String>> wordAndAnagrams = new HashMap<>();

	public ArrayList<String> getAnagrams() {
		return anagrams;
	}

	public void setAnagrams(ArrayList<String> anagrams) {
		this.anagrams = anagrams;
	}

	public HashMap<String, ArrayList<String>> getWordAndAnagrams() {
		return wordAndAnagrams;
	}

	public void setWordAndAnagrams(HashMap<String, ArrayList<String>> wordAndAnagrams) {
		this.wordAndAnagrams = wordAndAnagrams;
	}
}
