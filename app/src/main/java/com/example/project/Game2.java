package com.example.project;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Game2 extends AppCompatActivity {

    private int r, i, count = 0, flipped=0;
    Timer timer;
    ProgressBar time;
    TextView msg, cd;
    boolean started = false, win=false;
    AppCompatButton again;
    AppCompatButton start;

    ArrayList<Integer> save = new ArrayList<Integer>(18);
    ArrayList<Integer> match = new ArrayList<Integer>(2);
    ArrayList<ImageView> cards = new ArrayList<ImageView>(2);


    public int random(){
        int x = (int) (Math.random() * 9);
        return x;
    }

    public void flip(){
        FrameLayout group = findViewById(R.id.grp);
        for (i = 0;i < group.getChildCount();i++) {
            ImageView child = (ImageView) group.getChildAt(i);
            child.setImageResource(Shared.cards[9].getImg());
        }
    }

    public void reflip(){
        cards.get(0).setImageResource(Shared.cards[9].getImg());
        cards.get(1).setImageResource(Shared.cards[9].getImg());
        match.clear();
        cards.clear();
        count = 0;
    }

    public void countDown(){
        TextView cd = findViewById(R.id.cd);
        int num = Integer.parseInt(cd.getText().toString());
        if(num==1) {
            cd.setText("");
        }
        else {
            num--;
            cd.setText("" + num);
        }
    }

    public void won(){
        match.clear();
        cards.clear();
        count = 0;
        flipped+=2;
        if(started && flipped==18) {
            FrameLayout group = findViewById(R.id.grp);
            msg.setText("YOU WON!");
            started=false;
            win=true;
            timer.cancel();
            again = findViewById(R.id.again);
            again.setVisibility(View.VISIBLE);
            again.setOnClickListener(view -> {
                startActivity(getIntent());
            });
        }
    }

    public void play(View v, FrameLayout group, ProgressBar time, TextView msg, AppCompatButton start) {

        time.setProgress(100);
        timer = new Timer(35000, 1);
        (new Handler()).postDelayed(this::flip, 5000);

        cd = findViewById(R.id.cd);
        cd.setText("5");
        (new Handler()).postDelayed(this::countDown, 1000);
        (new Handler()).postDelayed(this::countDown, 2000);
        (new Handler()).postDelayed(this::countDown, 3000);
        (new Handler()).postDelayed(this::countDown, 4000);
        (new Handler()).postDelayed(this::countDown, 5000);
        timer.start();
        started = true;
        start.setVisibility(View.GONE);

        for (i = 0; i < group.getChildCount(); i++) {
            r = random();
            ImageView child = (ImageView) group.getChildAt(i);
            if (Collections.frequency(save, r) >= 2) {
                while (Collections.frequency(save, r) >= 2)
                    r = random();
                save.add(r);
                child.setImageResource(Shared.cards[r].getImg());
            } else {
                save.add(r);
                child.setImageResource(Shared.cards[r].getImg());
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.memory_game);

        FrameLayout group = findViewById(R.id.grp);

        time =findViewById(R.id.time);
        msg = findViewById(R.id.msg);
        start = findViewById(R.id.start);

        start.setOnClickListener((view) -> {

            play(view, group, time, msg, start);

        });



        ImageView child1 = (ImageView) group.getChildAt(0);
        ImageView child2 = (ImageView) group.getChildAt(1);
        ImageView child3 = (ImageView) group.getChildAt(2);
        ImageView child4 = (ImageView) group.getChildAt(3);
        ImageView child5 = (ImageView) group.getChildAt(4);
        ImageView child6 = (ImageView) group.getChildAt(5);
        ImageView child7 = (ImageView) group.getChildAt(6);
        ImageView child8 = (ImageView) group.getChildAt(7);
        ImageView child9 = (ImageView) group.getChildAt(8);
        ImageView child10 = (ImageView) group.getChildAt(9);
        ImageView child11 = (ImageView) group.getChildAt(10);
        ImageView child12 = (ImageView) group.getChildAt(11);
        ImageView child13 = (ImageView) group.getChildAt(12);
        ImageView child14 = (ImageView) group.getChildAt(13);
        ImageView child15 = (ImageView) group.getChildAt(14);
        ImageView child16 = (ImageView) group.getChildAt(15);
        ImageView child17 = (ImageView) group.getChildAt(16);
        ImageView child18 = (ImageView) group.getChildAt(17);


        child1.setOnClickListener(view -> {
            if (started && count < 2) {
                child1.setImageResource(Shared.cards[save.get(0)].getImg());
                count++;
                match.add(save.get(0));
                cards.add(child1);
                if(count==2){
                    if(match.get(0) != match.get(1)) {
                        (new Handler()).postDelayed(this::reflip, 500);
                    }
                    else{
                        won();
                    }
                }
            }
        });

        child2.setOnClickListener(view -> {
            if (started && count < 2) {
                child2.setImageResource(Shared.cards[save.get(1)].getImg());
                count++;
                match.add(save.get(1));
                cards.add(child2);
                if(count==2){
                    if(match.get(0) != match.get(1)) {
                        (new Handler()).postDelayed(this::reflip, 500);
                    }
                    else{
                        won();
                    }
                }
            }
        });

        child3.setOnClickListener(view -> {
            if (started && count < 2) {
                child3.setImageResource(Shared.cards[save.get(2)].getImg());
                count++;
                match.add(save.get(2));
                cards.add(child3);
                if(count==2){
                    if(match.get(0) != match.get(1)) {
                        (new Handler()).postDelayed(this::reflip, 500);
                    }
                    else{
                        won();
                    }
                }
            }
        });

        child4.setOnClickListener(view -> {
            if (started && count < 2) {
                child4.setImageResource(Shared.cards[save.get(3)].getImg());
                count++;
                match.add(save.get(3));
                cards.add(child4);
                if(count==2){
                    if(match.get(0) != match.get(1)) {
                        (new Handler()).postDelayed(this::reflip, 500);
                    }
                    else{
                        won();
                    }
                }
            }
        });

        child5.setOnClickListener(view -> {
            if (started && count < 2) {
                child5.setImageResource(Shared.cards[save.get(4)].getImg());
                count++;
                match.add(save.get(4));
                cards.add(child5);
                if(count==2){
                    if(match.get(0) != match.get(1)) {
                        (new Handler()).postDelayed(this::reflip, 500);
                    }
                    else{
                        won();
                    }
                }
            }
        });

        child6.setOnClickListener(view -> {
            if (started && count < 2) {
                child6.setImageResource(Shared.cards[save.get(5)].getImg());
                count++;
                match.add(save.get(5));
                cards.add(child6);
                if(count==2){
                    if(match.get(0) != match.get(1)) {
                        (new Handler()).postDelayed(this::reflip, 500);
                    }
                    else{
                        won();
                    }
                }
            }
        });

        child7.setOnClickListener(view -> {
            if (started && count < 2) {
                child7.setImageResource(Shared.cards[save.get(6)].getImg());
                count++;
                match.add(save.get(6));
                cards.add(child7);
                if(count==2){
                    if(match.get(0) != match.get(1)) {
                        (new Handler()).postDelayed(this::reflip, 500);
                    }
                    else{
                        won();
                    }
                }
            }
        });

        child8.setOnClickListener(view -> {
            if (started && count < 2) {
                child8.setImageResource(Shared.cards[save.get(7)].getImg());
                count++;
                match.add(save.get(7));
                cards.add(child8);
                if(count==2){
                    if(match.get(0) != match.get(1)) {
                        (new Handler()).postDelayed(this::reflip, 500);
                    }
                    else{
                        won();
                    }
                }
            }
        });

        child9.setOnClickListener(view -> {
            if (started && count < 2) {
                child9.setImageResource(Shared.cards[save.get(8)].getImg());
                count++;
                match.add(save.get(8));
                cards.add(child9);
                if(count==2){
                    if(match.get(0) != match.get(1)) {
                        (new Handler()).postDelayed(this::reflip, 500);
                    }
                    else{
                        won();
                    }
                }
            }
        });

        child10.setOnClickListener(view -> {
            if (started && count < 2) {
                child10.setImageResource(Shared.cards[save.get(9)].getImg());
                count++;
                match.add(save.get(9));
                cards.add(child10);
                if(count==2){
                    if(match.get(0) != match.get(1)) {
                        (new Handler()).postDelayed(this::reflip, 500);
                    }
                    else{
                        won();
                    }
                }
            }
        });

        child11.setOnClickListener(view -> {
            if (started && count < 2) {
                child11.setImageResource(Shared.cards[save.get(10)].getImg());
                count++;
                match.add(save.get(10));
                cards.add(child11);
                if(count==2){
                    if(match.get(0) != match.get(1)) {
                        (new Handler()).postDelayed(this::reflip, 500);
                    }
                    else{
                        won();
                    }
                }
            }
        });

        child12.setOnClickListener(view -> {
            if (started && count < 2) {
                child12.setImageResource(Shared.cards[save.get(11)].getImg());
                count++;
                match.add(save.get(11));
                cards.add(child12);
                if(count==2){
                    if(match.get(0) != match.get(1)) {
                        (new Handler()).postDelayed(this::reflip, 500);
                    }
                    else{
                        won();
                    }
                }
            }
        });

        child13.setOnClickListener(view -> {
            if (started && count < 2) {
                child13.setImageResource(Shared.cards[save.get(12)].getImg());
                count++;
                match.add(save.get(12));
                cards.add(child13);
                if(count==2){
                    if(match.get(0) != match.get(1)) {
                        (new Handler()).postDelayed(this::reflip, 500);
                    }
                    else{
                        won();
                    }
                }
            }
        });

        child14.setOnClickListener(view -> {
            if (started && count < 2) {
                child14.setImageResource(Shared.cards[save.get(13)].getImg());
                count++;
                match.add(save.get(13));
                cards.add(child14);
                if(count==2){
                    if(match.get(0) != match.get(1)) {
                        (new Handler()).postDelayed(this::reflip, 500);
                    }
                    else{
                        won();
                    }
                }
            }
        });

        child15.setOnClickListener(view -> {
            if (started && count < 2) {
                child15.setImageResource(Shared.cards[save.get(14)].getImg());
                count++;
                match.add(save.get(14));
                cards.add(child15);
                if(count==2){
                    if(match.get(0) != match.get(1)) {
                        (new Handler()).postDelayed(this::reflip, 500);
                    }
                    else{
                        won();
                    }
                }
            }
        });

        child16.setOnClickListener(view -> {
            if (started && count < 2) {
                child16.setImageResource(Shared.cards[save.get(15)].getImg());
                count++;
                match.add(save.get(15));
                cards.add(child16);
                if(count==2){
                    if(match.get(0) != match.get(1)) {
                        (new Handler()).postDelayed(this::reflip, 500);
                    }
                    else{
                        won();
                    }
                }
            }
        });

        child17.setOnClickListener(view -> {
            if (started && count < 2) {
                child17.setImageResource(Shared.cards[save.get(16)].getImg());
                count++;
                match.add(save.get(16));
                cards.add(child17);
                if(count==2){
                    if(match.get(0) != match.get(1)) {
                        (new Handler()).postDelayed(this::reflip, 500);
                    }
                    else{
                        won();
                    }
                }
            }
        });

        child18.setOnClickListener(view -> {
            if (started && count < 2) {
                child18.setImageResource(Shared.cards[save.get(17)].getImg());
                count++;
                match.add(save.get(17));
                cards.add(child18);
                if(count==2){
                    if(match.get(0) != match.get(1)) {
                        (new Handler()).postDelayed(this::reflip, 500);
                    }
                    else{
                        won();
                    }
                }
            }
        });


    }

    public class Timer extends CountDownTimer {

        public Timer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
        @Override
        public void onTick(long millisUntilFinished) {
            int progress = (int) (millisUntilFinished/300);
            time.setProgress(progress);
        }

        @Override
        public void onFinish() {
            started=false;
            msg.setText("YOU LOST!");
            time.setProgress(0);
            again = findViewById(R.id.again);
            again.setVisibility(View.VISIBLE);
            again.setOnClickListener(view -> {
                startActivity(getIntent());
            });
        }


    }

}