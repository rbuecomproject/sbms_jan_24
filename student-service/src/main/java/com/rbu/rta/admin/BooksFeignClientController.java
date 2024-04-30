package com.rbu.rta.admin;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BooksFeignClientController {

    @Autowired
    private BooksFeignClient booksFeignClient;

    @PostMapping("/create")
    public ResponseEntity<Books> createBook(@RequestBody Books book) {
        return booksFeignClient.createBook(book);
    }

    @PutMapping("/update")
    public ResponseEntity<Books> updateBook(@RequestBody Books book) {
        return booksFeignClient.updateBook(book);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Books> deleteBook(@RequestBody Books book) {
        return booksFeignClient.deleteBook(book);
    }

    @GetMapping("/select/{id}")
    public ResponseEntity<Books> selectBook(@PathVariable("id") String id) {
        return booksFeignClient.selectBook(id);
    }

    @GetMapping("/selectAll")
    public ResponseEntity<Map<String, Books>> selectAllBooks() {
        return booksFeignClient.selectAllBook();
    }
}
