package co.uk.moj.impl;

import co.uk.moj.modal.AnagramDataRepo;
import co.uk.moj.modal.Response;
import co.uk.moj.service.AnagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnagramServiceImpl implements AnagramService {

	@Autowired private AnagramDataRepo anagramDataRepo;

	@Override public Response getAnagrams(List<String> words) {
		Response response = new Response();
		words.forEach( word ->{
			String rword = word;
			char[] key = word.toCharArray();
			Arrays.sort(key);
			word = new String(key).toLowerCase();
			if(anagramDataRepo.getWordAndAnagrams().get(word) != null && !anagramDataRepo.getWordAndAnagrams().get(word).isEmpty()){
				response.getResultAnagrams().put(rword,anagramDataRepo.getWordAndAnagrams().get(word).stream().filter(w-> !w.equalsIgnoreCase(rword)).collect(
						Collectors.toList()));
			}else{
				response.getResultAnagrams().put(rword,new ArrayList());
			}

		});
		return response;
	}
}
