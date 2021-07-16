package com.example.textadventuregame;

import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Mystery extends AppCompatActivity {
    //gs holds all the gui components such as the buttons and texts
    GameScreen gs;

    //for each of the buttons, create a string to keep track of what method to call
    String nextAction1, nextAction2, nextAction3, nextAction4;

    //the player instance holds the user's location
    Player player;

    //constructor
    public Mystery(GameScreen gs, Player player){

        this.gs = gs;
        this.player = player;
    }


    /**
     * Based on the nextAction string, the switch statement
     * decides the appropriate method to call
     *
     * @param nextAction
     */
    public void selectAction(String nextAction){

        switch(nextAction){
            case "Main Room":
                initialStory();
                break;
            case "Hallway":
                hallway();
                break;
            case "Library":
                library();
                break;
            case "Kitchen":
                kitchen();
                break;
            case "Garden":
                garden();
                break;
            case "Map":
                map(player.getLocation());
                break;
            case "Wendy's Room":
                wendyRoom();
                break;
            case "note":
                wendyNote();
                break;
            case "Solve":
                solveMystery();
                break;
            case "Game Over":
                gameOver();
                break;
            case "Correct":
                correct();
                break;
            case "Start Over":
                gs.startOver();
                break;
        }
    }


    /**
     * Call this method when all buttons should be displayed on the screen
     */
    public void showAllButtons(){

        gs.button1.setVisibility(View.VISIBLE);
        gs.button2.setVisibility(View.VISIBLE);
        gs.button3.setVisibility(View.VISIBLE);
        gs.button4.setVisibility(View.VISIBLE);
    }

    /**
     * Reset the changes made to the screen components back to their
     * original state (the components change when user views map)
     */
    public void defaultSizes(){

        gs.gameImage.getLayoutParams().height = 0;
        gs.gameText.getLayoutParams().height = 0;
        gs.button1.getLayoutParams().height = 0;
    }

    /**
     * This method sets the initial scene of the mystery in the
     * game screen class
     */
    public void initialStory(){

        //set the components to their default sizes
        defaultSizes();

        //set the image of the Game screen to the estate since this is the initial scene
        gs.gameText.setGravity(Gravity.LEFT);
        gs.gameImage.setImageResource(R.drawable.estate);

        //set the game text to the initial story where the mystery is introduced to the user
        gs.gameText.setText("Wendy, the owner of a very old and magnificent estate, has died yesterday!\n" +
                "But no one knows how. Luckily, you are a very famous detective.\n" +
                "Can you use your investigative skills to find the murderer? Visit the rooms of the estate to find clues.\n" +
                "Good luck!");

        //Set the text for each of the buttons
        gs.button1.setText("Go North");
        gs.button2.setText("Go West");
        gs.button3.setText("View Map");
        gs.button4.setText("Solve Mystery");

        //this initial screen requires all buttons to be shown on the screen
        showAllButtons();

        //Set the nextAction strings for each of the buttons
        //these will later be passed onto the selectAction method when each button
        //is clicked
        setNextAction1("Hallway");
        setNextAction2("Library");
        setNextAction3("Map");
        setNextAction4("Solve");

        //Set the player's location to the main room
        player.setLocation("Main Room");

    }


    /**
     * This method is called when the user is ready to solve the mystery
     */
    public void solveMystery(){

        defaultSizes();

        gs.gameImage.setImageResource(R.drawable.solve_mystery);
        gs.gameText.setText("So, detective, you've solved the mystery? Who is Wendy's murderer?");
        gs.gameText.setGravity(Gravity.CENTER_HORIZONTAL);

        gs.button1.setText("Librarian");
        gs.button2.setText("Gardener");
        gs.button3.setText("Cook");
        gs.button4.setText("Not a homicide");

        showAllButtons();

        setNextAction1("Game Over");
        setNextAction2("Game Over");
        setNextAction3("Correct");
        setNextAction4("Game Over");

        player.setLocation("Main Room");

    }


    /**
     * If the user comes to the wrong conclusion they see the
     * game over screen and there's a button that allows them to
     * start over. The button takes them to the title screen by
     * calling another method called startOver (called in the selectAction method)
     */
    public void gameOver(){

        defaultSizes();

        gs.gameImage.setImageResource(R.drawable.game_over);
        gs.gameText.setText("You're wrong Detective. Maybe try to look at clues more closely!");
        gs.gameText.setGravity(Gravity.CENTER_HORIZONTAL);


        //Set the initial text for the buttons
        gs.button1.setText("Start Over");
        gs.button2.setText("");
        gs.button3.setText("");
        gs.button4.setText("");
        gs.button1.setVisibility(View.VISIBLE);
        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        setNextAction1("Start Over");

        player.setLocation("");

    }


    /**
     * If the user comes to the correct conclusion, this method is called
     * User also has the ability to start over and play again
     */
    public void correct(){

        defaultSizes();

        gs.gameImage.setImageResource(R.drawable.correct);
        gs.gameText.setText("You're right, Detective! All signs point to the Cook poisoning Wendy " +
                        "with harmful plants. Great Work, Detective.");
        gs.gameText.setGravity(Gravity.CENTER_HORIZONTAL);


        //Set the initial text for the buttons
        gs.button1.setText("Start Over");
        gs.button2.setText("");
        gs.button3.setText("");
        gs.button4.setText("");
        gs.button1.setVisibility(View.VISIBLE);
        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        setNextAction1("Start Over");

        player.setLocation("");

    }


    /**
     * This method is called whenever the user is in the hallway
     */
    public void hallway(){

        defaultSizes();

        gs.gameImage.setImageResource(R.drawable.hallway);
        gs.gameText.setText("You enter the hallway. There's nothing to see.");
        gs.gameText.setGravity(Gravity.LEFT);


        //Set the initial text for the buttons
        gs.button1.setText("Go South");
        gs.button2.setText("Go Northwest");
        gs.button3.setText("Go Northeast");
        gs.button4.setText("View Map");

        showAllButtons();

        setNextAction1("Main Room");
        setNextAction2("Wendy's Room");
        setNextAction3("Kitchen");
        setNextAction4("Map");

        player.setLocation("Hallway");

    }

    /**
     * This method is called whenever the user is in the library
     */
    public void library(){

        defaultSizes();

        gs.gameImage.setImageResource(R.drawable.library);
        gs.gameText.setText("You enter the library; you spot the librarian. She says to you...\n" +
                "Hi there! You must be the detective working on Wendy's case. Poor Wendy! I loved her dearly! " +
                "The last time I saw her was in her room to drop off a book about dangerous plants." +
                "I don't know why she would need that...");
        gs.gameText.setGravity(Gravity.LEFT);


        //Set the initial text for the buttons
        gs.button1.setText("Go North");
        gs.button2.setText("Go West");
        gs.button3.setText("Go East");
        gs.button4.setText("View Map");

        showAllButtons();

        setNextAction1("Hallway");
        setNextAction2("Garden");
        setNextAction3("Main Room");
        setNextAction4("Map");

        player.setLocation("Library");

    }

    /**
     * This method is called whenever the user is in the kitchen
     */
    public void kitchen(){

        defaultSizes();

        gs.gameImage.setImageResource(R.drawable.kitchen);
        gs.gameText.setText("You enter the kitchen; you spot the cook. He says to you...\n" +
                "So you're the bloody detective trying to figure out Wendy's murderer. Well, let me tell ya " +
                "the gardener of this estate is the murderer. I've seen him work with dangerous plants that could" +
                " kill a man in seconds!");
        gs.gameText.setGravity(Gravity.LEFT);


        //Set the initial text for the buttons
        gs.button1.setText("Go West");
        gs.button2.setText("Go South");
        gs.button3.setText("View Map");
        gs.button4.setText("");
        gs.button1.setVisibility(View.VISIBLE);
        gs.button2.setVisibility(View.VISIBLE);
        gs.button3.setVisibility(View.VISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        setNextAction1("Wendy's Room");
        setNextAction2("Hallway");
        setNextAction3("Map");

        player.setLocation("Kitchen");

    }

    /**
     * This method is called whenever the user is in the garden
     */
    public void garden(){

        defaultSizes();

        gs.gameImage.setImageResource(R.drawable.garden);
        gs.gameText.setText("You enter the garden; you spot the gardener. He says to you...\n" +
                "Hi detective! Nice seeing you on this beautiful day. It's terrible what happened to Wendy. " +
                "Recently she's taken an interest in poisonous plants. Last week she came to me to inquire about " +
                "edible plants that could kill you...");
        gs.gameText.setGravity(Gravity.LEFT);


        //Set the initial text for the buttons
        gs.button1.setText("Go East");
        gs.button2.setText("View Map");
        gs.button3.setText("");
        gs.button4.setText("");
        gs.button1.setVisibility(View.VISIBLE);
        gs.button2.setVisibility(View.VISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        setNextAction1("Library");
        setNextAction2("Map");

        player.setLocation("Garden");

    }


    /**
     * This method is called whenever the user is in Wendy's Room
     */
    public void wendyRoom(){

        defaultSizes();

        gs.gameImage.setImageResource(R.drawable.wendy_room);
        gs.gameText.setText("You enter Wendy's room. While looking around you spot a note on Wendy's desk.\n" +
                "The note may have some clue to help you find the murderer.\n");
        gs.gameText.setGravity(Gravity.LEFT);


        //Set the initial text for the buttons
        gs.button1.setText("Read the Note");
        gs.button2.setText("Go East");
        gs.button3.setText("Go South");
        gs.button4.setText("View Map");

        showAllButtons();

        setNextAction1("note");
        setNextAction2("Kitchen");
        setNextAction3("Hallway");
        setNextAction4("Map");

        player.setLocation("Wendy's Room");

    }

    /**
     * This method is called whenever the user is reading wendy's note
     */
    public void wendyNote(){

        defaultSizes();

        gs.gameImage.getLayoutParams().height = 0;
        gs.gameImage.setImageResource(R.drawable.wendy_note);
        gs.gameText.setText("The note says...\n\n" +
                "I don't feel safe here. Just yesterday I found my dear cat Lucy butchered to death! " +
                "What cruel person would do that to a cat??!! " +
                "I believe that someone was sending me a message and they will come for me next!");
        gs.gameText.setGravity(Gravity.LEFT);


        //Set the initial text for the buttons
        gs.button1.setText("Done Reading");
        gs.button2.setText("");
        gs.button3.setText("");
        gs.button4.setText("");
        gs.button1.setVisibility(View.VISIBLE);
        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);

        setNextAction1("Wendy's Room");

    }

    /**
     * This method is called whenever the user wants to view the map
     * and check which room they are in in the estate
     */
    public void map(String location){

        //change the height of the imageView component so it's large
        //and clearly viewable by the user
        gs.gameImage.getLayoutParams().height = 500;
        gs.gameText.getLayoutParams().height = 0;
        gs.button1.getLayoutParams().height = 50;
        gs.gameText.setGravity(Gravity.CENTER_HORIZONTAL);

        //based on the user's location, change the image of the imageView component
        switch (location) {
            case "Main Room":
                gs.gameImage.setImageResource(R.drawable.estate_main);
                break;
            case "Kitchen":
                gs.gameImage.setImageResource(R.drawable.estate_kitchen);
                break;
            case "Library":
                gs.gameImage.setImageResource(R.drawable.estate_library);
                break;
            case "Garden":
                gs.gameImage.setImageResource(R.drawable.estate_garden);
                break;
            case "Wendy's Room":
                gs.gameImage.setImageResource(R.drawable.estate_wendy);
                break;
            case "Hallway":
                gs.gameImage.setImageResource(R.drawable.estate_hallway);
                break;

        }

        //set the text for the textView to be the user's location
        gs.gameText.setText("You are currently in: " + location);

        gs.button1.setText("Done Looking");
        gs.button2.setText("");
        gs.button3.setText("");
        gs.button4.setText("");
        gs.button1.setVisibility(View.VISIBLE);
        gs.button2.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);


        setNextAction1(location);

    }

    //setters and getters
    public String getNextAction1(){
        return nextAction1;
    }

    public void setNextAction1(String nextAction1) {
        this.nextAction1 = nextAction1;
    }

    public String getNextAction2(){
        return nextAction2;
    }

    public void setNextAction2(String nextAction2) {
        this.nextAction2 = nextAction2;
    }

    public String getNextAction3(){
        return nextAction3;
    }

    public void setNextAction3(String nextAction3) {
        this.nextAction3 = nextAction3;
    }

    public String getNextAction4(){
        return nextAction4;
    }

    public void setNextAction4(String nextAction4) {
        this.nextAction4 = nextAction4;
    }
}
