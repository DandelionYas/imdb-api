package com.imdb.api;

import com.imdb.api.configs.TestConfiguration;
import com.imdb.api.helpers.HelperPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Import(TestConfiguration.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiTests {

	@LocalServerPort
	private int port;
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Return all the titles in which both director and writer are the same person
	 * and he/she is still alive
	 */
	@Test
	void testGettingTitlesWithSameDirectorAndWriterWhoIsAlive() {
		UriComponents uri = UriComponentsBuilder.newInstance()
				.scheme("http")
				.host("localhost")
				.port(port)
				.path("/api/titles/same-alive-crew")
				.queryParam("size", 10)
				.queryParam("number", 0).build();

		ResponseEntity<?> response = restTemplate.exchange(uri.toString(),
				HttpMethod.GET, null, HelperPage.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
	}

}
