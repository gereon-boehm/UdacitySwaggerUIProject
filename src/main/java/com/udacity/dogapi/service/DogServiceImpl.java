package com.udacity.dogapi.service;

import com.udacity.dogapi.entity.Dog;
import com.udacity.dogapi.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {
    @Autowired
    DogRepository dogRepository;

    public List<Dog> retrieveDogs(){ return (List<Dog>)dogRepository.findAll(); }
    public String retrieveDogBreedById(Long id){
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreedById(id));
        String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
        return breed;
    }
    public List<String> retrieveDogBreed(){ return dogRepository.findAllBreed(); }
    public List<String> retrieveDogNames(){ return dogRepository.findAllName(); }

}