package com.pokemon.service.impl;

import com.example.demosoap.gen.GetPokemonRequest;
import com.example.demosoap.gen.GetPokemonResponse;
import com.example.demosoap.gen.Pokemon;
import com.pokemon.consumer.IConsumer;
import com.pokemon.dto.ResultPokemon;
import com.pokemon.mapper.Mapper;
import com.pokemon.service.PokemonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonServiceImpl implements PokemonService {

    @Autowired
    IConsumer iConsumer;
    @Autowired
    Mapper mapper;

    @Override
    public GetPokemonResponse getPokemones(GetPokemonRequest getPokemonRequest) {
        ResultPokemon resultPokemon =iConsumer.sendGET();

        GetPokemonResponse getPokemonResponseMapper = mapper.resultPokemonToGetPokemonRepoonse(resultPokemon);

        int start = (getPokemonRequest.getPage() -1)  * getPokemonRequest.getSize();
        int end = Math.min(start + getPokemonRequest.getSize(), getPokemonResponseMapper.getPokemons().size());
        List<Pokemon> pokemons = getPokemonResponseMapper.getPokemons().subList(start,end);

       GetPokemonResponse getPokemonResponse = new GetPokemonResponse();
       getPokemonResponse.getPokemons().addAll(pokemons);
       getPokemonResponse.setPage(getPokemonRequest.getPage());
       getPokemonResponse.setSize(getPokemonRequest.getSize());
       getPokemonResponse.setTotalItems(pokemons.size());

        return getPokemonResponse;
    }
}
