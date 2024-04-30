package com.rbu.rta.admin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@FeignClient(name = "books-service", url = "${books.service.url}")
public interface BooksFeignClient {

    @PostMapping("/api/bookservice/v1/")
    ResponseEntity<Books> createBook(@RequestBody Books book);

    @PutMapping("/api/bookservice/v1/")
    ResponseEntity<Books> updateBook(@RequestBody Books book);

    @DeleteMapping("/api/bookservice/v1/")
    ResponseEntity<Books> deleteBook(@RequestBody Books book);

    @GetMapping("/api/bookservice/v1/{id}")
    ResponseEntity<Books> selectBook(@PathVariable("id") String id);

    @GetMapping("/api/bookservice/v1/")
    ResponseEntity<Map<String, Books>> selectAllBook();
}
