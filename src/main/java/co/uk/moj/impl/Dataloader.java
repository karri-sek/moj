package co.uk.moj.impl;
import co.uk.moj.service.AnagramDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Dataloader implements ApplicationRunner {

	@Autowired
	private AnagramDataService anagramDataService;

	@Override public void run(ApplicationArguments applicationArguments) throws Exception {
		anagramDataService.readData("http://static.abscond.org/wordlist.txt");
		anagramDataService.initalizeAnagramData();
	}
}
