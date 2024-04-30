package com.rbu.rta.admin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BooksRestClient {
	@Autowired
	RestTemplate restTemplate;

	private final String BASE_URL = "http://localhost:9090/api/bookservice/v1/";

	public ResponseEntity<Books> createBook(Books book) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Books> requestEntity = new HttpEntity<>(book, headers);

		return restTemplate.exchange(BASE_URL, HttpMethod.POST, requestEntity, Books.class);
	}

	public ResponseEntity<Books> updateBook(Books book) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Books> requestEntity = new HttpEntity<>(book, headers);

		return restTemplate.exchange(BASE_URL, HttpMethod.PUT, requestEntity, Books.class);
	}

	public ResponseEntity<Books> deleteBook(Books book) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<Books> requestEntity = new HttpEntity<>(book, headers);

		return restTemplate.exchange(BASE_URL, HttpMethod.DELETE, requestEntity, Books.class);
	}

	public ResponseEntity<Books> selectBook(String id) {
		return restTemplate.getForEntity(BASE_URL + id, Books.class);
	}

	public ResponseEntity<Map<String, Books>> selectAllBooks() {
		return restTemplate.exchange(BASE_URL, HttpMethod.GET, null,
				new ParameterizedTypeReference<Map<String, Books>>() {
				});
	}

}
