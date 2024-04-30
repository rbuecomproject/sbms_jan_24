package com.rbu.rta.admin;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;

import reactor.core.publisher.Mono;

@Service
public class BooksWebClientService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public Mono<Books> createBook(Books book) {
        return webClientBuilder.build()
                .post()
                .uri("http://localhost:9090/api/bookservice/v1/")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(book))
                .retrieve()
                .bodyToMono(Books.class);
    }

    public Mono<Books> updateBook(Books book) {
        return webClientBuilder.build()
                .put()
                .uri("http://localhost:9090/api/bookservice/v1/")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(book))
                .retrieve()
                .bodyToMono(Books.class);
    }

    public Mono<Books> deleteBook(Books book) {
        return ((RequestBodySpec) webClientBuilder.build()
                .delete()
                .uri("http://localhost:9090/api/bookservice/v1/"))
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(book))
                .retrieve()
                .bodyToMono(Books.class);
    }

    public Mono<Books> selectBook(String id) {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:9090/api/bookservice/v1/{id}", id)
                .retrieve()
                .bodyToMono(Books.class);
    }

    public Mono<Map> selectAllBooks() {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:9090/api/bookservice/v1/")
                .retrieve()
                .bodyToMono(Map.class);
    }
}
