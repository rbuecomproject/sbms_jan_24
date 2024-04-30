package com.rbu.rta.admin;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/webcleintbooks")
public class BooksWebClientController {

    @Autowired
    private BooksWebClientService booksWebClientService;

    @PostMapping("/create")
    public Mono<ResponseEntity<Books>> createBook(@RequestBody Books book) {
        return booksWebClientService.createBook(book)
                .map(ResponseEntity::ok);
    }

    @PutMapping("/update")
    public Mono<ResponseEntity<Books>> updateBook(@RequestBody Books book) {
        return booksWebClientService.updateBook(book)
                .map(ResponseEntity::ok);
    }

    @DeleteMapping("/delete")
    public Mono<ResponseEntity<Books>> deleteBook(@RequestBody Books book) {
        return booksWebClientService.deleteBook(book)
                .map(ResponseEntity::ok);
    }

    @GetMapping("/select/{id}")
    public Mono<ResponseEntity<Books>> selectBook(@PathVariable("id") String id) {
        return booksWebClientService.selectBook(id)
                .map(ResponseEntity::ok);
    }

    @GetMapping("/selectAll")
    public Mono<ResponseEntity<Map<String, Books>>> selectAllBooks() {
        return booksWebClientService.selectAllBooks()
                .map(ResponseEntity::ok);
    }
}
