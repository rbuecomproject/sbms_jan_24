package com.rbu.rta.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookservice/v1/")
public class BooksController {

	public static Map<String, Books> map = new HashMap<>();

	@PostMapping
	public ResponseEntity<Books> createBook(@RequestBody Books book) {
		map.put(book.getId(), book);
		return new ResponseEntity<Books>(book, HttpStatus.ACCEPTED);
	}

	@PutMapping
	public ResponseEntity<Books> updateBook(@RequestBody Books book) {
		if (!ObjectUtils.isEmpty(map.get(book.getId()))) {
			map.put(book.getId(), book);
			return new ResponseEntity<Books>(book, HttpStatus.OK);
		} else
			return new ResponseEntity<Books>(book, HttpStatus.BAD_REQUEST);

	}

	@DeleteMapping
	public ResponseEntity<Books> deleteBook(@RequestBody Books book) {
		if (!ObjectUtils.isEmpty(map.get(book.getId()))) {
			map.remove(book.getId());
			return new ResponseEntity<Books>(book, HttpStatus.OK);
		} else
			return new ResponseEntity<Books>(book, HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Books> selectBook(@PathVariable("id") String id) {
		if (!ObjectUtils.isEmpty(map.get(id))) {

			return new ResponseEntity<Books>(map.get(id), HttpStatus.OK);
		} else
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

	}

	@GetMapping()
	public ResponseEntity<Map<String, Books>> selectAllBook() {

		return new ResponseEntity<Map<String, Books>>(map, HttpStatus.OK);

	}

}
