package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    EditText password_text;
    TextView title_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click_confirm(View view){

        password_text = (EditText) findViewById(R.id.main_input);
        title_text = (TextView) findViewById(R.id.main_title);
        Intent intent_game = new Intent(this, GameActivity.class);

        if (password_text.getText().toString().equals("1234")) {
            title_text.setText("Correct!!");
            startActivity(intent_game);
        } else {
            title_text.setText("Wrong!!");
        }
    }
}