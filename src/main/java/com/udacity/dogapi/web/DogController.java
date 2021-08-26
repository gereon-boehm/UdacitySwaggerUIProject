package com.udacity.dogapi.web;

import com.udacity.dogapi.entity.Dog;
import com.udacity.dogapi.service.DogService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ApiResponses(value = {
        @ApiResponse(
                code = 400, message = "This is a bad request, please follow the API documentation for the proper " +
                "request format"),
        @ApiResponse(code = 401, message = "Due to security constraints, your access request cannot be authorized."),
        @ApiResponse(code = 500, message = "The server is down. Please make sure that the Dog microservice is running.")
})
public class DogController {
    private final DogService dogService;

    public DogController(DogService dogService){
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> dogs = dogService.retrieveDogs();
        return new ResponseEntity<List<Dog>>(dogs, HttpStatus.OK);
    }

    @GetMapping("/{id}/breed")
    public ResponseEntity<String> getDogBreedById(@PathVariable Long id) {
        String breed = dogService.retrieveDogBreedById(id);
        return new ResponseEntity<String>(breed, HttpStatus.OK);
    }

    @GetMapping("/dogs/breed")
    public ResponseEntity<List<String>> getAllDogBreeds() {
        List<String> breeds = dogService.retrieveDogBreed();
        return new ResponseEntity<List<String>>(breeds, HttpStatus.OK);
    }

    @GetMapping("/dogs/name")
    public ResponseEntity<List<String>> getAllDogNames() {
        List<String> names = dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(names, HttpStatus.OK);
    }
}