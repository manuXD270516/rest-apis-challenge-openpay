package com.codechallenge.openpay.restapisopenpay.web;

import com.codechallenge.library.clientapi.domain.Result;
import com.codechallenge.openpay.restapisopenpay.entities.LogEndpoint;
import com.codechallenge.openpay.restapisopenpay.service.LogEndpointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/marvel")

public class LogsController {



    @Autowired
    private LogEndpointService logEndpointService;

    @GetMapping("/logs")
    public List<LogEndpoint> getAllCharacters() {
        return logEndpointService.getAll();
    }
}
