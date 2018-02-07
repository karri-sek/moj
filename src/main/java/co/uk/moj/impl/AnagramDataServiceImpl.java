package co.uk.moj.impl;

import co.uk.moj.modal.AnagramDataRepo;
import co.uk.moj.service.AnagramDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class AnagramDataServiceImpl implements AnagramDataService {

	@Autowired
	private AnagramDataRepo anagramDataRepo;

	private ArrayList<String> words = new ArrayList<>();

	@Override public void readData(String httpUrl) {
		try {
			String line;
			RestTemplateBuilder restTemplate = new RestTemplateBuilder();
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
			HttpEntity<String> entity = new HttpEntity<>(headers);
			ResponseEntity<Resource> response = restTemplate.build().
					exchange(httpUrl, HttpMethod.GET, entity, Resource.class);
			InputStream s = response.getBody().getInputStream();
			BufferedReader buffer = new BufferedReader(new InputStreamReader(s));
			while((line = buffer.readLine()) != null){
				words.add(line);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override public void initalizeAnagramData() {
		for (String str : words) {
			char[] temp = str.toCharArray();
			Arrays.sort(temp);
			String key = new String(temp).toLowerCase();
			if (anagramDataRepo.getWordAndAnagrams().get(key) != null) {
				anagramDataRepo.getWordAndAnagrams().get(key).add(str.toLowerCase());
			} else {
				ArrayList<String> anagramList = new ArrayList<>();
				anagramList.add(str);
				anagramDataRepo.getWordAndAnagrams().put(key, anagramList);
			}
		}
	}

}
