package com.cats;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CatController {

	private static final String CAT_API_URL =
            "https://api.thecatapi.com/v1/images/search?limit=10"; // aquí va tu endpoint real

    private final RestTemplate restTemplate = new RestTemplate();
    
    @GetMapping("/cats")
    public ResponseEntity<List<CatImage>> getCats() {
        CatImage[] response = restTemplate.getForObject(CAT_API_URL, CatImage[].class);
        return ResponseEntity.ok(Arrays.asList(response));
    }
}


