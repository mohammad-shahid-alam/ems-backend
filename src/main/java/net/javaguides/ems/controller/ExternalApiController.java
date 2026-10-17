package net.javaguides.ems.controller;

import net.javaguides.ems.dto.ExternalPostDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/api/external")
public class ExternalApiController {

    private final RestClient restClient;

    public ExternalApiController(RestClient restClient) {
        this.restClient = restClient;
    }

    @GetMapping("/posts/{id}")
    public ExternalPostDto getPost(@PathVariable int id) {
        return restClient.get()
                .uri("/posts/{id}", id)
                .retrieve()
                .body(ExternalPostDto.class);
    }
}