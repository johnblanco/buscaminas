package com.buscaminas.service;

import com.buscaminas.entities.Cell;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class Board {
    private Long seed;

    public Board() {
    }

    public Board(Long seed) {
        this.seed = seed;
    }

    public Long getSeed() {
        return seed;
    }

    public void setSeed(Long seed) {
        this.seed = seed;
    }

    public List<Cell> createCells() {
        //creo 81 celdas
        List<Cell> cells = IntStream.range(0, 81)
                .boxed()
                .map(Cell::new)
                .collect(Collectors.toList());

        //elijo 10 y las convierto en minas
        Random r = (seed != null) ? new Random(seed) : new Random();
        Set<Integer> selectedMines = new HashSet<>();
        while (selectedMines.size() < 10) {
            selectedMines.add(r.nextInt(cells.size()));
        }
        selectedMines.forEach(i -> cells.get(i).setMine(true));

        cells.forEach(c -> c.updateAdjacentMinesCount(cells));

        return cells;
    }
    
}
