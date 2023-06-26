package com.codechallenge.openpay.restapisopenpay.web;

import com.codechallenge.openpay.restapisopenpay.domain.Character;
import com.codechallenge.openpay.restapisopenpay.service.MarvelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/marvel")
public class MarvelController {

    @Autowired
    private MarvelService marvelService;

    @GetMapping("/characters")
    public List<Character> getAllCharacters() {
        return marvelService.getAllCharacters();
    }

    @GetMapping("/characters/{id}")
    public Character getCharacterById(@PathVariable int id) {
        return marvelService.getCharacterById(id);
    }
}
