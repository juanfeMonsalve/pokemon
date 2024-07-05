package com.pokemon.enpoint;


import com.example.demosoap.gen.GetPokemonRequest;
import com.example.demosoap.gen.GetPokemonResponse;
import com.pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PokemonEndpoint {

    @Autowired
    PokemonService pokemonService;
    private static final String NAMESPACE_URI = "http://www.example.com/demosoap/gen";



    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonRequest")
    @ResponsePayload
    public GetPokemonResponse getPokemon(@RequestPayload GetPokemonRequest request) {

        return pokemonService.getPokemones(request);
    }
}