package com.buscaminas;

import com.buscaminas.entities.Cell;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CellTests {

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
        c4.updateAdjacentMines(board);

        assertEquals(3, c4.getAdjacentMines());
    }
}
