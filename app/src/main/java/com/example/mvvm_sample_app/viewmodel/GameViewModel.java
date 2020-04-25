package com.example.mvvm_sample_app.viewmodel;

import androidx.databinding.ObservableArrayMap;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_sample_app.model.Cell;
import com.example.mvvm_sample_app.model.Game;
import com.example.mvvm_sample_app.model.Player;

import static com.example.mvvm_sample_app.utilities.StringUtility.stringFromNumbers;

public class GameViewModel extends ViewModel {

    /*

    Google’s ViewModel/Observer pattern architecture component with LiveData.
    Other ways to do this by using eventbus, RxAndroid.

     Note : View Model is not tied to the views ? This means that it shouldn’t know about them,
     which is why you won’t find an instance of the View in the View Model class.
     But if this is the case, how does the View Model communicate with the View ?
     */

    /*
    LiveData : Think of LiveData as a wrapper around some data in your app, data that’s susceptible to change over time.
    This wrapper provides the data to anyone listining (or “observing”, which is the term widely used).
    So if A is a LiveData instance and B is observing it,
    anytime A’s data changes, B is notified about this change and gets the latest value of A’s data.

    More concretely, the View Model will notify the View about when the Game ends, this will allow the View to update the UI.
     */

    public ObservableArrayMap<String, String> cells;
    private Game game;

    public void init(String p1, String p2) {
        game = new Game(p1, p2);
        cells = new ObservableArrayMap<>();
    }

    public void onClickedCellAt(int row, int col) {
        if (game.cells[row][col] == null) {
            game.cells[row][col] = new Cell(game.currentPlayer);
            cells.put(stringFromNumbers(row, col), game.currentPlayer.value);
            if (game.hasGameEnded()) {
                game.reset();
            } else {
                game.switchPlayer();
            }
        }
    }

    public LiveData<Player> getWinner() {
        return game.winner;
    }


}
