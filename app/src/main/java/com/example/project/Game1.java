package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.atomic.AtomicBoolean;

public class Game1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dice_game);

        int[] diceImage =   {
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
        };

        Turn turn = new Turn(false);
        Player player1 = new Player();
        Player player2 = new Player();
        CardView card1 = findViewById(R.id.card1);
        CardView card2 = findViewById(R.id.card2);
        ImageView dice = findViewById(R.id.diceiv);
        Button roll = findViewById(R.id.rollbtn);
        Button hold = findViewById(R.id.holdbtn);
        Button reply = findViewById(R.id.replaybtn);
        Button newG = findViewById(R.id.nwg);
        Context context = getApplicationContext();
        TextView cur1 = findViewById(R.id.cur1);
        TextView cur2 = findViewById(R.id.cur2);
        TextView score1 = findViewById(R.id.score1);
        TextView score2 = findViewById(R.id.score2);
        TextView p1 = findViewById(R.id.p1);
        TextView p2 = findViewById(R.id.p2);
        roll.setOnClickListener(v -> {
            if(turn.isTurn()==false){
                card1.setCardBackgroundColor(ContextCompat.getColor(context, R.color.white));
                card2.setCardBackgroundColor(ContextCompat.getColor(context, R.color.trans_white));
                int diceNum = (int)(Math.random()*6)+1;
                dice.setImageResource(diceImage[diceNum-1]);
                if(diceNum!=1){
                    player1.setCurrent(player1.getCurrent()+diceNum);
                    cur1.setText(player1.getCurrent()+"");
                }else{
                    turn.setTurn(true);
                    player1.setCurrent(0);
                    card1.setCardBackgroundColor(ContextCompat.getColor(context, R.color.trans_white));
                    card2.setCardBackgroundColor(ContextCompat.getColor(context, R.color.white));
                    cur1.setText(player1.getCurrent()+"");
                }

            }
            if(turn.isTurn()==true){

                int diceNum = (int)(Math.random()*6)+1;
                dice.setImageResource(diceImage[diceNum-1]);
                if(diceNum!=1){
                    player2.setCurrent(player2.getCurrent()+diceNum);
                    cur2.setText(player2.getCurrent()+"");
                }else{
                    turn.setTurn(false);
                    player2.setCurrent(0);
                    card1.setCardBackgroundColor(ContextCompat.getColor(context, R.color.white));
                    card2.setCardBackgroundColor(ContextCompat.getColor(context, R.color.trans_white));
                    cur2.setText(player2.getCurrent()+" ");
                }
            }

        });
        hold.setOnClickListener(h ->{
            if(turn.isTurn()==false){
                player1.setScore(player1.getScore()+player1.getCurrent());
                player1.setCurrent(0);
                score1.setText(player1.getScore()+"");
                cur1.setText(player1.getCurrent()+"");
                card1.setCardBackgroundColor(ContextCompat.getColor(context, R.color.trans_white));
                card2.setCardBackgroundColor(ContextCompat.getColor(context, R.color.white));
                turn.setTurn(true);
                if(player1.getScore()>=100){
                    player1.setWins(player1.getWins()+1);
                    p1.setText("PLAYER 1: "+player1.getWins());
                    player1.setScore(0);
                    player2.setScore(0);
                    score1.setText(player1.getScore()+"");
                    score2.setText(player2.getScore()+"");
                    cur1.setText(player1.getCurrent()+"");
                    cur2.setText(player2.getCurrent()+"");
                    Toast.makeText(context, "Player 1 Won. Congrats!!", Toast.LENGTH_LONG).show();
                }

            }else if(turn.isTurn()){
                player2.setScore(player2.getScore()+player2.getCurrent());
                player2.setCurrent(0);
                score2.setText(player2.getScore()+"");
                cur2.setText(player2.getCurrent()+"");
                card1.setCardBackgroundColor(ContextCompat.getColor(context, R.color.white));
                card2.setCardBackgroundColor(ContextCompat.getColor(context, R.color.trans_white));
                turn.setTurn(false);
                if(player2.getScore()>=100){
                    player2.setWins(player2.getWins()+1);
                    p2.setText("PLAYER 2: "+player2.getWins());
                    player1.setScore(0);
                    player2.setScore(0);
                    score1.setText(player1.getScore()+"");
                    score2.setText(player2.getScore()+"");
                    cur1.setText(player1.getCurrent()+"");
                    cur2.setText(player2.getCurrent()+"");
                    Toast.makeText(context, "Player 2 Won. Congrats!!", Toast.LENGTH_LONG).show();
                }
            }
        });
        reply.setOnClickListener(r ->{
            player1.setScore(0);
            score1.setText(player1.getScore()+"");
            player2.setScore(0);
            score2.setText(player2.getScore()+"");
            player1.setCurrent(0);
            cur1.setText(player1.getCurrent()+"");
            player2.setCurrent(0);
            cur2.setText(player2.getCurrent()+"");
            turn.setTurn(false);
            card1.setCardBackgroundColor(ContextCompat.getColor(context, R.color.white));
            card2.setCardBackgroundColor(ContextCompat.getColor(context, R.color.white));
        });
        newG.setOnClickListener(n ->{
            player1.setScore(0);
            score1.setText(player1.getScore()+"");
            player2.setScore(0);
            score2.setText(player2.getScore()+"");
            player1.setCurrent(0);
            cur1.setText(player1.getCurrent()+"");
            player2.setCurrent(0);
            cur2.setText(player2.getCurrent()+"");
            player1.setWins(0);
            p1.setText("PLAYER 1");
            player2.setWins(0);
            p2.setText("PLAYER 2");
            turn.setTurn(false);
            card1.setCardBackgroundColor(ContextCompat.getColor(context, R.color.white));
            card2.setCardBackgroundColor(ContextCompat.getColor(context, R.color.white));
        });
    }
}