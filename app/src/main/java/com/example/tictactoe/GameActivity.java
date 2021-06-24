package com.example.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Array;
import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    TextView result_text;
    static String move;
    static String[][] btn_list = {{"", "", ""},{"", "", ""},{"", "", ""}};
    int x, y, counter;
    boolean gameIsEnd;
    Button b00, b01, b02, b10, b11, b12, b20, b21, b22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        b00 = (Button) findViewById(R.id.b00);
        b01 = (Button) findViewById(R.id.b01);
        b02 = (Button) findViewById(R.id.b02);
        b10 = (Button) findViewById(R.id.b10);
        b11 = (Button) findViewById(R.id.b11);
        b12 = (Button) findViewById(R.id.b12);
        b20 = (Button) findViewById(R.id.b20);
        b21 = (Button) findViewById(R.id.b21);
        b22 = (Button) findViewById(R.id.b22);

        result_text = (TextView) findViewById(R.id.result_text);
        result_text.setText("Next Move: X");
        counter = 0;
        move = "O";
        gameIsEnd = false;
    }

    public void click_btn_play_again(View view) {
        // reset array
        for (int i=0; i<=2; i++){
            for (int j=0; j<=2; j++){
                btn_list[i][j] = "";
            }
        }

        // reset button text
        b00.setText("");
        b01.setText("");
        b02.setText("");
        b10.setText("");
        b11.setText("");
        b12.setText("");
        b20.setText("");
        b21.setText("");
        b22.setText("");
        result_text.setText("Next Move: X");

        // reset symbol for the next move, reset counter and flag for if the game is ended.
        move = "O";
        counter = 0;
        gameIsEnd = false;
    }

    public void btn_clicked(View view) {
        Button btn = (Button) findViewById(view.getId());

        // safeguard one move on each button, and show toast for warnings
        if (!gameIsEnd) {
            if (btn.getText().toString().equals("")) {
                if (move.equals("X")) {
                    move = "O";
                    result_text.setText("Next Move: X");
                } else {
                    move = "X";
                    result_text.setText("Next Move: O");
                }
                btn.setText(move);
                counter++;

                // update btn_list with the current move

                switch (view.getId()) {
                    case R.id.b00:
                        btn_list[0][0] = move;
                        x = 0;
                        y = 0;
                        break;
                    case R.id.b01:
                        btn_list[0][1] = move;
                        x = 0;
                        y = 1;
                        break;
                    case R.id.b02:
                        btn_list[0][2] = move;
                        x = 0;
                        y = 2;
                        break;
                    case R.id.b10:
                        btn_list[1][0] = move;
                        x = 1;
                        y = 0;
                        break;
                    case R.id.b11:
                        btn_list[1][1] = move;
                        x = 1;
                        y = 1;
                        break;
                    case R.id.b12:
                        btn_list[1][2] = move;
                        x = 1;
                        y = 2;
                        break;
                    case R.id.b20:
                        btn_list[2][0] = move;
                        x = 2;
                        y = 0;
                        break;
                    case R.id.b21:
                        btn_list[2][1] = move;
                        x = 2;
                        y = 1;
                        break;
                    case R.id.b22:
                        btn_list[2][2] = move;
                        x = 2;
                        y = 2;
                        break;
                }

                // check if anyone wins or game ends with tie

                // check the same row
                if (btn_list[x][0].equals(btn_list[x][1]) &&
                        btn_list[x][0].equals(btn_list[x][2])) {
                    result_text.setText(btn_list[x][0]+" WIN");
                    gameIsEnd = true;
                }

                // check the same column
                else if (btn_list[0][y].equals(btn_list[1][y]) &&
                        btn_list[0][y].equals(btn_list[2][y])) {
                    result_text.setText(btn_list[0][y]+" WIN");
                    gameIsEnd = true;
                }

                // check diagonal
                else if (!btn_list[0][0].equals("") &&
                        btn_list[0][0].equals(btn_list[1][1]) &&
                        btn_list[0][0].equals(btn_list[2][2])) {
                    result_text.setText(btn_list[0][0]+" WIN");
                    gameIsEnd = true;
                }

                // check another diagonal
                else if (!btn_list[0][2].equals("") &&
                        btn_list[0][2].equals(btn_list[1][1]) &&
                        btn_list[0][2].equals(btn_list[2][0])) {
                    result_text.setText(btn_list[0][2]+" WIN");
                    gameIsEnd = true;
                }

                else if (counter == 9) {
                    result_text.setText("TIE, Game ended.");
                    gameIsEnd = true;
                }

            } else {
                Toast.makeText(getApplicationContext(), "already taken", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "GAME ENDED", Toast.LENGTH_SHORT).show();
        }

    }

}

