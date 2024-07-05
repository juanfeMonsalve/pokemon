package com.pokemon.dto;

import java.util.List;
import lombok.Data;

@Data
public class ResultPokemon {
    private int count;
    private String next;
    private String previous;
    private List<Result> results;
}
