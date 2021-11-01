package com.buscaminas.service;

import com.buscaminas.entities.Cell;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public
class MinesweeperBoard {
//    List<List<Cell>> cells;
//
//    public List<List<Cell>> getCells() {
//        return cells;
//    }
//
//    public void setCells(List<List<Cell>> cells) {
//        this.cells = cells;
//    }
//
//    boolean boardWithOneRowAndNoColumns = false;
//
//    public MinesweeperBoard() {
//        List<Cell> firstRow = List.of(new Cell(0, 0, true),
//                new Cell(0, 1, false),
//                new Cell(0, 2, true),
//                new Cell(0, 3, true)
//
//        );
//        this.cells = List.of(firstRow);
//    }
//
//    public MinesweeperBoard(List<String> inputBoard) {
//        if (inputBoard.equals(Collections.singletonList(""))) {
//            boardWithOneRowAndNoColumns = true;
//        } else {
//            cells = IntStream.range(0, inputBoard.size())
//                    .boxed()
//                    .map(i -> rowCells(i, inputBoard.get(i)))
//                    .collect(Collectors.toList());
//        }
//    }
//
//    private List<Cell> rowCells(int index, String row) {
//        String[] charList = row.split("");
//        return IntStream.range(0, charList.length)
//                .mapToObj(i -> new Cell(index, i, charList[i].equals("*")))
//                .collect(Collectors.toList());
//    }
//
//
//    String mapRow(List<Cell> row) {
//        List<String> rowStr = row.stream()
//                .map(c -> c.toString(cells))
//                .collect(Collectors.toList());
//
//        return String.join("", rowStr);
//    }
//
//    List<String> withNumbers() {
//        if (boardWithOneRowAndNoColumns) {
//            return Collections.singletonList("");
//        }
//        return cells.stream()
//                .map(this::mapRow)
//                .collect(Collectors.toList());
//    }

}