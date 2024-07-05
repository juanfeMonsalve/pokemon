package com.pokemon.consumer;

import com.pokemon.dto.ResultPokemon;

public interface IConsumer {
    ResultPokemon sendGET();
}
