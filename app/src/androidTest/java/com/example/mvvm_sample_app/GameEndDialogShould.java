package com.example.mvvm_sample_app;

import androidx.test.rule.ActivityTestRule;

import com.example.mvvm_sample_app.model.Player;
import com.example.mvvm_sample_app.view.MainActivity;

import org.junit.Rule;
import org.junit.Test;

import static com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed;
import static com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotExist;
import static com.schibsted.spain.barista.interaction.BaristaDialogInteractions.clickDialogPositiveButton;

/**
 * Created by absolutelysaurabh
 */
public class GameEndDialogShould {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void display_winner_when_game_ends() throws Exception {
        givenGameEnded();

        assertDisplayed(R.id.tv_winner);
    }

    @Test
    public void display_begin_dialog_when_done_clicked() throws Exception {
        givenGameEnded();

        clickDialogPositiveButton();

        assertNotExist(R.id.tv_winner);
        assertDisplayed(R.id.et_player1);
    }

    private void givenGameEnded() {
        activityRule.getActivity().onGameWinnerChanged(new Player("sameer", "x"));
    }
}