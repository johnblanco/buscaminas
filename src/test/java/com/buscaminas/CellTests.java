package com.buscaminas;

import com.buscaminas.entities.Cell;
import com.buscaminas.service.Board;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CellTests {

    Board board = new Board(0L);

    @Test
    public void testCoordinates() {
        Cell c = new Cell(0);

        assertEquals(0, c.getX());
        assertEquals(0, c.getY());

        Cell c2 = new Cell(3);

        assertEquals(0, c2.getX());
        assertEquals(3, c2.getY());

        Cell c3 = new Cell(9);

        assertEquals(1, c3.getX());
        assertEquals(0, c3.getY());

        Cell c4 = new Cell(80);

        assertEquals(8, c4.getX());
        assertEquals(8, c4.getY());
    }

    @Test
    public void testAdjacentCells() {
        Cell c1 = new Cell(0,0,true);
        Cell c2 = new Cell(0,1,true);
        Cell c3 = new Cell(1,0,true);
        Cell c4 = new Cell(1,1,false);

        List<Cell> board = List.of(c1, c2, c3, c4);

        assertEquals(0, c4.getAdjacentMines());
        c4.updateAdjacentMinesCount(board);

        assertEquals(3, c4.getAdjacentMines());
    }

    @Test
    public void testClickOnNumberedCell(){
        Cell c1 = new Cell(0,0, false,false);
        Cell c2 = new Cell(0,1, false,false);
        Cell c3 = new Cell(1,0, false,false);
        Cell c4 = new Cell(1,1, true,false);

        List<Cell> cells = List.of(c1, c2, c3, c4);

        c1.updateBoardStatusAfterClick(cells);


    }
}
