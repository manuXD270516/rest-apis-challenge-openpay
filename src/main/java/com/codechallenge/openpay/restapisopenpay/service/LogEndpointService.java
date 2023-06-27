package com.codechallenge.openpay.restapisopenpay.service;

import com.codechallenge.openpay.restapisopenpay.entities.LogEndpoint;
import com.codechallenge.openpay.restapisopenpay.repository.LogEndpointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogEndpointService {
    private final LogEndpointRepository logEndpointRepository;

    @Autowired
    public LogEndpointService(LogEndpointRepository logEndpointRepository) {
        this.logEndpointRepository = logEndpointRepository;
    }

    public void saveLog(String requestEndpointName) {
        logEndpointRepository.save(LogEndpoint.builder()
                .requestName(requestEndpointName)
                .build()
        );
    }
    public List<LogEndpoint> getAll(){
        return logEndpointRepository.findAll();
    }

}
