package co.uk.moj.controller;
import co.uk.moj.modal.Response;
import co.uk.moj.service.AnagramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;

@RestController
@RequestMapping("/moj")
public class AnagramsController {
	@Autowired
	public AnagramService anagramService;

	@GetMapping("/{words}")
	public Response getAnagrams(@PathVariable("words") String words){
		if(words !=null) {
			return anagramService.getAnagrams(Arrays.asList(words.split(",")));
		}
		return new Response("Request should contain word's to get anagrams");
	}

}
