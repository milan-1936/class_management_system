package com.example.studentdashboard.messages;

import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Message {
    public void showMessageAndFadeAway(String text, Label message ) {
        // Set the message text
        message.setText(text);
        message.setOpacity(1.0); // Ensure it's fully visible

        // Create a FadeTransition for fading out
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), message);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        // Create a PauseTransition to delay the fade effect
        PauseTransition pause = new PauseTransition(Duration.seconds(1));

        // Create a SequentialTransition to combine the pause and fade
        SequentialTransition sequentialTransition = new SequentialTransition(pause, fadeOut);

        // Start the transitions
        sequentialTransition.play();
    }
}
