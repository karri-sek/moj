package co.uk.moj.service;

import co.uk.moj.modal.Response;

import java.util.List;

public interface AnagramService {
	Response getAnagrams(List<String> words);
}
