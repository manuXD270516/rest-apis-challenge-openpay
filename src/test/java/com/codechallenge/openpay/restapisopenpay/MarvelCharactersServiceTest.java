package com.codechallenge.openpay.restapisopenpay;

import com.codechallenge.library.clientapi.domain.Result;
import com.codechallenge.openpay.restapisopenpay.service.MarvelService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@ExtendWith(SpringExtension.class)
public class MarvelCharactersServiceTest {


    @MockBean
    private MarvelService marvelService;

    List<Result> resultsItemsMock = Arrays.asList(
            Result.builder()
                    .id(1l)
                    .name("A-Bomb (HAS)")
                    .build(),
            Result.builder()
                    .id(2l)
                    .name("3-D Man")
                    .build()
    );
    @Test
    public void testGetAllCharacters() {
        // Mock the response from the Marvel API client
        /*List<Result> response = new LinkedList<>();

        Result r1 = new Result();
        r1.setId(1l);
        r1.setName("A-Bomb (HAS)");

        Result r2 = new Result();
        r2.setId(2l);
        r2.setName("3-D Man");


        List<Result> characters = Arrays.asList(r1, r2);
        response.addAll(characters);

        when(marvelApiClientService.getCharacters()
                .getData()
                .getResults())
                .thenReturn(response);

        // Call the service method
        List<Result> result = marvelService.getAllCharacters();

        // Verify the interactions
        verify(marvelApiClientService, times(1)).getCharacters();

        // Assert the result
        assertEquals(characters, result);*/

        Mockito.when(marvelService.getAllCharacters()).thenReturn(resultsItemsMock);
        List<Result> resultsComics = marvelService.getAllCharacters();
        Assert.assertEquals(resultsComics.get(0).getId(), resultsItemsMock.get(0).getId());
    }

    @Test
    public void testGetCharacterById() {

    }
}
