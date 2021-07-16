package com.example.textadventuregame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TitleScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);

    }

    //When the title screen button is clicked, it will take the user to the Game Screen
    public void titleButtonClicked(View view){

        //an Intent object stores information about which component to start
        //it stores information such as its name so in this cass the name of the GameScreen class
        Intent gameScreen = new Intent(this, GameScreen.class);
        startActivity(gameScreen);
    }
}