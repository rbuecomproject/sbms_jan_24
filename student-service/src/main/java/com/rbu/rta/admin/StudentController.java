package com.rbu.rta.admin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/studentservice/v1/")
public class StudentController {

	@Autowired
	BooksRestClient booksRestClient;

	@PostMapping("/create")
	public ResponseEntity<Books> createBook(@RequestBody Books book) {
		return booksRestClient.createBook(book);
	}

	@PutMapping("/update")
	public ResponseEntity<Books> updateBook(@RequestBody Books book) {
		return booksRestClient.updateBook(book);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Books> deleteBook(@RequestBody Books book) {
		return booksRestClient.deleteBook(book);
	}

	@GetMapping("/select/{id}")
	public ResponseEntity<Books> selectBook(@PathVariable("id") String id) {
		return booksRestClient.selectBook(id);
	}

	@GetMapping("/selectAll")
	public ResponseEntity<Map<String, Books>> selectAllBooks() {
		return booksRestClient.selectAllBooks();
	}
}
