package co.uk.moj.service;

import co.uk.moj.modal.AnagramDataRepo;

public interface AnagramDataService {

	void readData(String httpUrl);

	void initalizeAnagramData();

}
