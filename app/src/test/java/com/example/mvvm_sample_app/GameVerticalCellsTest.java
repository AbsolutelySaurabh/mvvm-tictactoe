package com.example.mvvm_sample_app;

import com.example.mvvm_sample_app.model.Cell;
import com.example.mvvm_sample_app.model.Game;
import com.example.mvvm_sample_app.model.Player;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameVerticalCellsTest {

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
    public void returnTrueIfHasThreeSameVerticalCellsAtColumn1() throws Exception {
        Cell cell = new Cell(player);
        game.cells[0][0] = cell;
        game.cells[1][0] = cell;
        game.cells[2][0] = cell;
        boolean hasThreeSameVerticalCells = game.hasThreeSameVerticalCells();
        assertTrue(hasThreeSameVerticalCells);
    }

    @Test
    public void returnTrueIfHasThreeSameVerticalCellsAtColumn2() throws Exception {
        Cell cell = new Cell(player);
        game.cells[0][1] = cell;
        game.cells[1][1] = cell;
        game.cells[2][1] = cell;
        boolean hasThreeSameVerticalCells = game.hasThreeSameVerticalCells();
        assertTrue(hasThreeSameVerticalCells);
    }

    @Test
    public void returnTrueIfHasThreeSameVerticalCellsAtColumn3() throws Exception {
        Cell cell = new Cell(player);
        game.cells[0][2] = cell;
        game.cells[1][2] = cell;
        game.cells[2][2] = cell;
        boolean hasThreeSameVerticalCells = game.hasThreeSameVerticalCells();
        assertTrue(hasThreeSameVerticalCells);
    }

    @Test
    public void returnFalseIfDoesNotHaveThreeSameVerticalCells() throws Exception {
        Cell cell = new Cell(player);
        Cell anotherCell = new Cell(anotherPlayer);
        game.cells[0][0] = cell;
        game.cells[1][0] = cell;
        game.cells[2][0] = anotherCell;
        boolean hasThreeSameVerticalCells = game.hasThreeSameVerticalCells();
        assertFalse(hasThreeSameVerticalCells);
    }
}