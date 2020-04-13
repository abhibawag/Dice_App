package com.example.dicebyabhi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView diceImage1 = findViewById(R.id.imgDice1);
        final ImageView diceImage2 = findViewById(R.id.imgDice2);
        final int [] diceImages = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};


        int myBox = 10;
        float myFloatBox = 4.2f;
        double myDoubleBox = 3.34567892;
        final MediaPlayer mp= MediaPlayer.create(this, R.raw.dice_sound);
        Button btnRoll = findViewById(R.id.btnRollTheDice);

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



               Log.i("MyDiceApp", "btnRoll is tapped now!");
                Random rndObject = new Random();
               int myRandomNumber = rndObject.nextInt(6);
               int myRandomNumber1 = rndObject.nextInt(6);
               Log.i("MyDiceApp", "The generated number is" + myRandomNumber);
               diceImage1.setImageResource(diceImages[myRandomNumber]);
               diceImage2.setImageResource(diceImages[myRandomNumber1]);
               mp.start();

                YoYo.with(Techniques.Wave)
                        .duration(500)
                        .repeat(0)
                        .playOn(diceImage1);


                YoYo.with(Techniques.Wave)
                        .duration(500)
                        .repeat(0)
                        .playOn(diceImage2);
            }
        });




    }
}
