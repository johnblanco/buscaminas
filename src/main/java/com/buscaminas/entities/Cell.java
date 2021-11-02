package com.buscaminas.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Entity
public class Cell {


    @Id
    @GeneratedValue
    private long id;
    private int x;
    private boolean hasFlag;
    private int y;
    private boolean isMine;
    private boolean visible;
    private int adjacentMines;

    public boolean isHasFlag() {
        return hasFlag;
    }

    public void setHasFlag(boolean hasFlag) {
        this.hasFlag = hasFlag;
    }

    public Cell() {
    }

    public Cell(int x, int y, boolean isMine, boolean visible) {
        this.x = x;
        this.y = y;
        this.isMine = isMine;
        this.visible = visible;
    }

    public Cell(int x, int y, boolean isMine) {
        this.x = x;
        this.y = y;
        this.isMine = isMine;
    }

    public Cell(int i) {
        this.x = Math.floorDiv(i, 9);
        this.y = i % 9;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getAdjacentMines() {
        return adjacentMines;
    }

    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }

    public boolean isAdjacent(Cell other) {
        double diffX = Math.pow(this.getX() - other.getX(), 2);
        double diffY = Math.pow(this.getY() - other.getY(), 2);
        return Math.floor(Math.sqrt(diffX + diffY)) == 1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCssClass() {
        String cssClass = "cell size24";
        if (!this.isVisible()) {
            cssClass += " closed";
        } else if (this.isMine) {
            cssClass += " mine";
        } else {
            cssClass += " type" + this.adjacentMines;
        }
        return cssClass;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public List<Cell> adjacentCells(List<Cell> cells) {
        return cells.stream()
                .filter(this::isAdjacent)
                .collect(Collectors.toList());
    }

    public void updateAdjacentMinesCount(List<Cell> board) {
        int count = (int) board.stream()
                .filter(other -> this.isAdjacent(other) && other.isMine())
                .count();
        this.setAdjacentMines(count);
    }

    @Override
    public boolean equals(Object obj) {
        Cell other = (Cell) obj;
        return other.getX() == this.getX() && other.getY() == this.getY();
    }

    private void clickedOnZeroMine(List<Cell> cells) {
        if(this.isVisible()){
            return;
        }
        this.setVisible(true);
        this.adjacentCells(cells).stream()
                .filter(c -> c.getAdjacentMines() == 0)
                .forEach(c-> c.clickedOnZeroMine(cells));
    }

    public void updateBoardStatusAfterClick(List<Cell> cells) {
        if (this.getAdjacentMines() == 0) {
            clickedOnZeroMine(cells);
        }
    }
}
