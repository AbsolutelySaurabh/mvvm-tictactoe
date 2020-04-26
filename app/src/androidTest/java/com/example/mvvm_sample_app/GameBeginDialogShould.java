package com.example.mvvm_sample_app;

import androidx.test.rule.ActivityTestRule;

import com.example.mvvm_sample_app.view.MainActivity;

import org.junit.Rule;
import org.junit.Test;

import static com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed;
import static com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotExist;
import static com.schibsted.spain.barista.interaction.BaristaDialogInteractions.clickDialogPositiveButton;
import static com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo;

public class GameBeginDialogShould {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void display_empty_names_message_if_names_empty() throws Exception {
        writeTo(R.id.et_player1, "");
        writeTo(R.id.et_player2, "");

        clickDialogPositiveButton();

        assertDisplayed(R.string.game_dialog_empty_name);
    }

    @Test
    public void display_same_names_message_if_names_same() throws Exception {
        writeTo(R.id.et_player1, "sammmer");
        writeTo(R.id.et_player2, "sammmer");

        clickDialogPositiveButton();

        assertDisplayed(R.string.game_dialog_same_names);
    }

    @Test
    public void display_empty_name_message_if_one_name_empty() throws Exception {
        writeTo(R.id.et_player1, "");
        writeTo(R.id.et_player2, "sammmer");

        clickDialogPositiveButton();

        assertDisplayed(R.string.game_dialog_empty_name);
    }

    @Test
    public void close_dialog_after_names_valid() throws Exception {
        writeTo(R.id.et_player1, "sammmer 1");
        writeTo(R.id.et_player2, "sammmer 2");

        clickDialogPositiveButton();

        assertNotExist(R.id.layout_player1);
    }
}
