package com.example.textadventuregame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class GameScreen extends AppCompatActivity {

    //these variables will hold the components from the Game Screen
    ImageView gameImage;
    TextView gameText;
    Button button1;
    Button button2;
    Button button3;
    Button button4;

    //keep track of which button clicked
    String action = "";

    //create a mystery object to start the story
    //pass in the current game screen and player
    Player player = new Player();
    Mystery mystery = new Mystery(this, player);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_game_screen);

        //instantiate the components
        gameImage = (ImageView)findViewById(R.id.gameImageView);
        gameText = (TextView)findViewById(R.id.gameTextView);
        button1 = (Button)findViewById(R.id.choiceButton1);
        button2 = (Button)findViewById(R.id.choiceButton2);
        button3 = (Button)findViewById(R.id.choiceButton3);
        button4 = (Button)findViewById(R.id.choiceButton4);

        //start the story
        mystery.initialStory();

    }

    //functions that trigger when buttons on the screen are clicked
    public void button1Clicked(View view){

        //get the string for button1 and call the selectAction method from the Mystery class
        action = mystery.getNextAction1();
        mystery.selectAction(action);

    }

    public void button2Clicked(View view){

        action = mystery.getNextAction2();
        mystery.selectAction(action);
    }

    public void button3Clicked(View view){

        action = mystery.getNextAction3();
        mystery.selectAction(action);
    }


    public void button4Clicked(View view){

        action = mystery.getNextAction4();
        mystery.selectAction(action);

    }

    //when users finish the game they have the ability to start over
    //this function thakes them back to the title screen
    public void startOver(){
        Intent titleScreen = new Intent(this, TitleScreen.class);
        startActivity(titleScreen);
    }
}