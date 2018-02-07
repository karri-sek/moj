package co.uk.moj.controller;

import co.uk.moj.modal.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AnagramsControllerTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void ShouldReturnAllTheAnagramForcrepitus() throws Exception{
		Collection expected = new ArrayList();
		expected.add("cuprites");
		expected.add("pictures");
		expected.add("piecrust");
		ResponseEntity<Response> responseEntity = restTemplate.getForEntity("/moj/crepitus", Response.class);
		assertTrue(responseEntity.getBody().getResultAnagrams().get("crepitus").contains("cuprites"));
		assertEquals(3,responseEntity.getBody().getResultAnagrams().get("crepitus").size());
		assertEquals(expected, responseEntity.getBody().getResultAnagrams().get("crepitus"));
	}
	@Test
	public void ShouldReturnEmptyList() throws Exception{
		ResponseEntity<Response> responseEntity = restTemplate.getForEntity("/moj/sdfwehrtgegfg", Response.class);
		assertEquals(0,responseEntity.getBody().getResultAnagrams().get("sdfwehrtgegfg").size());
		assertTrue(responseEntity.getBody().getResultAnagrams().get("sdfwehrtgegfg").isEmpty());
	}
	@Test
	public void ShouldReturnAllTheAnagramForGivenWords() throws Exception{
		Collection cupritesExpectedList = new ArrayList();
		cupritesExpectedList.add("cuprites");
		cupritesExpectedList.add("pictures");
		cupritesExpectedList.add("piecrust");
		ResponseEntity<Response> responseEntity = restTemplate.getForEntity("/moj/crepitus,paste,kinship,enlist,boaster,fresher,sinks,knits,sort", Response.class);
		assertTrue(responseEntity.getBody().getResultAnagrams().get("crepitus").contains("cuprites"));
		assertEquals(3,responseEntity.getBody().getResultAnagrams().get("crepitus").size());
		assertEquals(cupritesExpectedList, responseEntity.getBody().getResultAnagrams().get("crepitus"));
		Collection sortExpectedList = new ArrayList();
		sortExpectedList.add("orts");
		sortExpectedList.add("rots");
		sortExpectedList.add("stor");
		sortExpectedList.add("tors");
		assertEquals(sortExpectedList, responseEntity.getBody().getResultAnagrams().get("sort"));
	}

	@Test
	public void ShouldReturnAllTheAnagramForfresher() throws Exception{
		Collection expectedList = new ArrayList();
		expectedList.add("refresh");
		ResponseEntity<Response> responseEntity = restTemplate.getForEntity("/moj/fresher", Response.class);
		assertTrue(responseEntity.getBody().getResultAnagrams().get("fresher").contains("refresh"));
		assertEquals(1,responseEntity.getBody().getResultAnagrams().get("fresher").size());
		assertEquals(expectedList, responseEntity.getBody().getResultAnagrams().get("fresher"));
	}
}
