package com.pokemon.consumer.impl;

import com.pokemon.consumer.IConsumer;
import com.pokemon.dto.ResultPokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Consumer implements IConsumer {
    @Autowired
    RestTemplate restTemplate;

    @Value("${pokemon.url}")
    private String url;

    @Override
    public ResultPokemon sendGET() {
       ResponseEntity<ResultPokemon> responseEntity = restTemplate.getForEntity(url,ResultPokemon.class);

        if(!(responseEntity.getStatusCode().value()==200)){
            return  null;
        }
        return responseEntity.getBody();
    }
}
