package com.pokemon.service;

import com.example.demosoap.gen.GetPokemonRequest;
import com.example.demosoap.gen.GetPokemonResponse;

public interface PokemonService {

    GetPokemonResponse getPokemones(GetPokemonRequest getPokemonRequest);
}
