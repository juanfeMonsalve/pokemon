package com.pokemon.mapper.impl;

import com.example.demosoap.gen.GetPokemonResponse;

import com.example.demosoap.gen.Pokemon;
import com.pokemon.dto.ResultPokemon;
import com.pokemon.mapper.Mapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class MapperImpl  implements Mapper {
    @Override
    public GetPokemonResponse resultPokemonToGetPokemonRepoonse(ResultPokemon resultPokemon) {
        GetPokemonResponse getPokemonResponse = new GetPokemonResponse();
        List<Pokemon> pokemons = new ArrayList<>();
        resultPokemon.getResults().forEach(data -> {
            Pokemon pokemon = new Pokemon();
            pokemon.setName(data.getName());
            pokemon.setUrl(data.getUrl());
            pokemons.add(pokemon);
        });
        getPokemonResponse.getPokemons().addAll(pokemons);
        return getPokemonResponse;
    }
}
