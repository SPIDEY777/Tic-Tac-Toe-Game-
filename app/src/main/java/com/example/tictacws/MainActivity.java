package com.example.tictacws;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button button1, button2, button3, button4, button5, button6, button7, button8, button9;
    int flag = 0;
    int count = 0;
    String ButtonValue1,ButtonValue2,ButtonValue3,ButtonValue4,ButtonValue5,ButtonValue6,ButtonValue7,ButtonValue8,ButtonValue9;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        init(); // call the init method here

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // This method initializes all the buttons
    private void init() {
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        

    }
    public void check(View view) {
        Button buttonCurrent = (Button) view;

        // Don't overwrite a cell that's already played
        if (!buttonCurrent.getText().toString().equals("")) return;

        if (flag == 0) {
            buttonCurrent.setText("X");
            flag = 1;
        } else {
            buttonCurrent.setText("O");
            flag = 0;
        }

        count++;

        if (count > 4) {
            ButtonValue1 = button1.getText().toString();
            ButtonValue2 = button2.getText().toString();
            ButtonValue3 = button3.getText().toString();
            ButtonValue4 = button4.getText().toString();
            ButtonValue5 = button5.getText().toString();
            ButtonValue6 = button6.getText().toString();
            ButtonValue7 = button7.getText().toString();
            ButtonValue8 = button8.getText().toString();
            ButtonValue9 = button9.getText().toString();

            boolean winnerFound = false;

            // Winning Conditions
            if (ButtonValue1.equals(ButtonValue2) && ButtonValue2.equals(ButtonValue3) && !ButtonValue1.equals("")) {
                winnerFound = true;
                showWinner(ButtonValue1);
            } else if (ButtonValue4.equals(ButtonValue5) && ButtonValue5.equals(ButtonValue6) && !ButtonValue4.equals("")) {
                winnerFound = true;
                showWinner(ButtonValue4);
            } else if (ButtonValue7.equals(ButtonValue8) && ButtonValue8.equals(ButtonValue9) && !ButtonValue7.equals("")) {
                winnerFound = true;
                showWinner(ButtonValue7);
            } else if (ButtonValue1.equals(ButtonValue4) && ButtonValue4.equals(ButtonValue7) && !ButtonValue1.equals("")) {
                winnerFound = true;
                showWinner(ButtonValue1);
            } else if (ButtonValue2.equals(ButtonValue5) && ButtonValue5.equals(ButtonValue8) && !ButtonValue2.equals("")) {
                winnerFound = true;
                showWinner(ButtonValue2);
            } else if (ButtonValue3.equals(ButtonValue6) && ButtonValue6.equals(ButtonValue9) && !ButtonValue3.equals("")) {
                winnerFound = true;
                showWinner(ButtonValue3);
            } else if (ButtonValue1.equals(ButtonValue5) && ButtonValue5.equals(ButtonValue9) && !ButtonValue1.equals("")) {
                winnerFound = true;
                showWinner(ButtonValue1);
            } else if (ButtonValue3.equals(ButtonValue5) && ButtonValue5.equals(ButtonValue7) && !ButtonValue3.equals("")) {
                winnerFound = true;
                showWinner(ButtonValue3);
            }

            if (winnerFound) {
                // Turn background green
                View rootView = findViewById(R.id.main);
                rootView.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));

                // Reset after delay
                rootView.postDelayed(() -> resetBoard(), 2000);
            } else if (count == 9) {
                // It's a draw
                Toast.makeText(this, "It's a Draw!", Toast.LENGTH_SHORT).show();
                View rootView = findViewById(R.id.main);
                rootView.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));

                rootView.postDelayed(() -> resetBoard(), 2000);
            }
        }
    }

    private void showWinner(String winner) {
        // Show toast
        Toast.makeText(this, "Winner is: " + winner, Toast.LENGTH_LONG).show();

        // Make the background green
        View rootView = findViewById(R.id.main);
        rootView.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));

        // Reset all after 2 seconds
        rootView.postDelayed(() -> {
            // Reset board buttons
            button1.setText("");
            button2.setText("");
            button3.setText("");
            button4.setText("");
            button5.setText("");
            button6.setText("");
            button7.setText("");
            button8.setText("");
            button9.setText("");

            // Reset background to white (or your original color)
            rootView.setBackgroundColor(getResources().getColor(android.R.color.background_light));

            // Reset game state
            count = 0;
            flag = 0;
        }, 3000); // 2 seconds delay
    }
    private void resetBoard() {
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");

        count = 0;
        flag = 0;

        View rootView = findViewById(R.id.main);
        rootView.setBackgroundColor(getResources().getColor(android.R.color.background_light));
    }

}

