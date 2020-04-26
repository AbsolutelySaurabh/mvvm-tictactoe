package com.example.mvvm_sample_app;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import androidx.test.rule.ActivityTestRule;

import com.example.mvvm_sample_app.model.Player;
import com.example.mvvm_sample_app.view.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed;
import static com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn;
import static com.schibsted.spain.barista.interaction.BaristaDialogInteractions.clickDialogPositiveButton;
import static com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class GameActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    private Player player1 = new Player("Shubham", "x");
    private Player player2 = new Player("Sonali", "o");

    @Test
    public void end_game_when_one_player_wins() {
        writeTo(R.id.et_player1, player1.name);
        writeTo(R.id.et_player2, player2.name);
        clickDialogPositiveButton();

        clickOn(R.id.cell_00);
        clickOn(R.id.cell_10);
        clickOn(R.id.cell_01);
        clickOn(R.id.cell_11);
        clickOn(R.id.cell_02);

        assertDisplayed(R.id.tv_winner);
        assertDisplayed(player1.name);
    }
}
