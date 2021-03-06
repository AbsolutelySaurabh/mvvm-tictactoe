package com.example.mvvm_sample_app;

import com.example.mvvm_sample_app.model.Cell;
import com.example.mvvm_sample_app.model.Game;
import com.example.mvvm_sample_app.model.Player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameHorizontalCellsTest {

    private Game game;
    private Player player;
    private Player anotherPlayer;

    @Before
    public void setUp() throws Exception {
        game = new Game("Soniya", "Singh");
        player = game.player1;
        anotherPlayer = game.player2;
    }

    @Test
    public void returnTrueIfHasThreeSameHorizontalCellsAtRow1() throws Exception {
        Cell cell = new Cell(player);
        game.cells[0][0] = cell;
        game.cells[0][1] = cell;
        game.cells[0][2] = cell;
        boolean hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells();
        assertTrue(hasThreeSameHorizontalCells);
    }

    @Test
    public void returnTrueIfHasThreeSameHorizontalCellsAtRow2() throws Exception {
        Cell cell = new Cell(player);
        game.cells[1][0] = cell;
        game.cells[1][1] = cell;
        game.cells[1][2] = cell;
        boolean hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells();
        assertTrue(hasThreeSameHorizontalCells);
    }

    @Test
    public void returnTrueIfHasThreeSameHorizontalCellsAtRow3() throws Exception {
        Cell cell = new Cell(player);
        game.cells[2][0] = cell;
        game.cells[2][1] = cell;
        game.cells[2][2] = cell;
        boolean hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells();
        assertTrue(hasThreeSameHorizontalCells);
    }

    @Test
    public void returnFalseIfDoesNotHaveThreeSameHorizontalCells() throws Exception {
        Cell cell = new Cell(player);
        Cell anotherCell = new Cell(anotherPlayer);
        game.cells[0][0] = cell;
        game.cells[0][1] = cell;
        game.cells[0][2] = anotherCell;
        boolean hasThreeSameHorizontalCells = game.hasThreeSameHorizontalCells();
        assertFalse(hasThreeSameHorizontalCells);
    }
}