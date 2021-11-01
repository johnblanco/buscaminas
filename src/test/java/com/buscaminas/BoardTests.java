package com.buscaminas;

import com.buscaminas.entities.Cell;
import com.buscaminas.service.Board;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTests {

    Board board = new Board(0L);

    @Test
    public void testGenerateNineRowBoard() {
        List<Cell> cells = board.createCells();

        assertEquals(81, cells.size());
    }

    @Test
    public void testMineCount() {
        List<Cell> mines = board.createCells().stream().
                filter(Cell::isMine)
                .collect(Collectors.toList());

        assertEquals(10, mines.size());
    }

}
