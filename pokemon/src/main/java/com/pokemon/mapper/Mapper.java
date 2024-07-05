package com.pokemon.mapper;

import com.example.demosoap.gen.GetPokemonResponse;
import com.pokemon.dto.ResultPokemon;

public interface Mapper {
    GetPokemonResponse resultPokemonToGetPokemonRepoonse(ResultPokemon resultPokemon);
}
