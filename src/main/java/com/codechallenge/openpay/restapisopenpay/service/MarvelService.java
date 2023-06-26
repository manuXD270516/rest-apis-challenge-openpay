package com.codechallenge.openpay.restapisopenpay.service;


import com.codechallenge.library.clientapi.domain.CharacterData;
import com.codechallenge.library.clientapi.domain.ComicApiResponse;
import com.codechallenge.library.clientapi.domain.Result;
import com.codechallenge.library.clientapi.external.MarvelApiClient;
import com.codechallenge.library.clientapi.service.MarvelApiClientService;
import lombok.AllArgsConstructor;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import com.codechallenge.library.clientapi.domain.CharacterData;

import java.util.List;

@Service
public class MarvelService {

    private final MarvelApiClientService marvelApiClientService;

    @Autowired
    public MarvelService(MarvelApiClientService marvelApiClientService){
        this.marvelApiClientService = marvelApiClientService;
    }

    public List<Result> getAllCharacters() {
        return marvelApiClientService.getCharacters()
                .getData()
                .getResults();

    }

    public Result getCharacterById(int id) {
        return marvelApiClientService.getCharacterById(id)
                .getData()
                .getResults()
                .stream()
                .findFirst()
                .orElse(null);
    }
}
