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

    Result itemFindById = Result.builder()
            .id(1l)
            .name("A-Bomb (HAS)")
            .build();

    @Test
    public void testGetAllCharacters() {
        Mockito.when(marvelService.getAllCharacters()).thenReturn(resultsItemsMock);
        List<Result> resultsComics = marvelService.getAllCharacters();
        Assert.assertEquals(resultsComics.get(0).getId(), resultsItemsMock.get(0).getId());
    }

    @Test
    public void testGetCharacterById() {
        long id = 1l;
        Mockito.when(marvelService.getCharacterById(id)).thenReturn(itemFindById);
        Result comicItem = marvelService.getCharacterById(id);
        Assert.assertEquals(comicItem.getId(), itemFindById.getId());
    }
}
