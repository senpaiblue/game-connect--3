package com.example.gameconnect3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.file.Files;

public class MainActivity extends AppCompatActivity {
    // 0: grey , 1: black ,2: grey
    int[] gamestate={2,2,2,2,2,2,2,2,2};
    int[][] winningpoistions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int activeplayer =0;
    boolean gameactive = true;
    public void dropIn(View view) {
        ImageView counter = (ImageView) view;

        int tappedcounter= Integer.parseInt(counter.getTag().toString());
        if (gamestate[tappedcounter]==2 && gameactive) {
        gamestate[tappedcounter]=activeplayer;
        counter.setTranslationY(-1500);
        if (activeplayer==0) {
            counter.setImageResource(R.drawable.grey);
            activeplayer = 1;
        } else {
            counter.setImageResource(R.drawable.black);
            activeplayer = 0;
        }
        }
        counter.animate().translationYBy(1500).setDuration(300);
        for(int[]winningpoistion : winningpoistions){
            if (gamestate[winningpoistion[0]] == gamestate[winningpoistion[1]] && gamestate[winningpoistion[1]]==gamestate[winningpoistion[2]]&& gamestate[winningpoistion[0]]!=2){
                String winner="";
                if(activeplayer ==1 ){
                    winner = "grey";
                }else{
                    winner ="black";
                }

            //someone has won!

                Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
                TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
                winnerTextView.setText(winner + " has won!");
                playAgainButton.setVisibility(View.VISIBLE);
                winnerTextView.setVisibility(View.VISIBLE);
            }
        }
    }
  public void playAgain(View view){
    Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
    TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
    playAgainButton.setVisibility(View.VISIBLE);
    winnerTextView.setVisibility(View.VISIBLE);
    GridLayout gridLayout =(GridLayout) findViewById(R.id.gridLayout);

      for(int i=0; i<gridLayout.getChildCount();i++){
          ImageView counter = (ImageView) gridLayout.getChildAt(i);
          counter.setImageDrawable(null);
      }
      int[] gamestate={2,2,2,2,2,2,2,2,2};
      int activeplayer =0;
      boolean gameactive = true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
