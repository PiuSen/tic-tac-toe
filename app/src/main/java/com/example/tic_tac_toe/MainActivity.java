package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final List<int[]> combinationsList = new ArrayList<>();
    private int[] boxpositions = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int playerTurn = 1;
    private int totalselectedboxes = 1;
    private LinearLayout playeronenamelayout, playertwonamelayout;
    private TextView playeronename, playertwoname;
    private ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playeronename = findViewById(R.id.playeronename);
        playertwoname = findViewById(R.id.playertwoname);
        playeronenamelayout = findViewById(R.id.playeronenamelayout);
        playertwonamelayout = findViewById(R.id.playertwonamelayout);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);
        img7 = findViewById(R.id.img7);
        img8 = findViewById(R.id.img8);
        img9 = findViewById(R.id.img9);
        combinationsList.add(new int[]{0, 1, 2});
        combinationsList.add(new int[]{3, 4, 5});
        combinationsList.add(new int[]{6, 7, 8});
        combinationsList.add(new int[]{0, 3, 6});
        combinationsList.add(new int[]{1, 4, 7});
        combinationsList.add(new int[]{2, 5, 8});
        combinationsList.add(new int[]{2, 4, 6});
        combinationsList.add(new int[]{0, 4, 8});
        final String getplayeronename = getIntent().getStringExtra("playerone");
        final String getplayertwoname = getIntent().getStringExtra("playertwo");
        playeronename.setText(getplayeronename);
        playertwoname.setText(getplayertwoname);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isboxselected((0))) {
                    performAction((ImageView)view, 0);

                }




            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isboxselected(1)) {
                    performAction((ImageView)view, 1);

                }

            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isboxselected(2)) {
                    performAction((ImageView)view, 2);

                }

            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isboxselected(3)) {
                    performAction((ImageView)view, 3);

                }

            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isboxselected(4)) {
                    performAction((ImageView)view, 4);

                }
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isboxselected(5)) {
                    performAction((ImageView)view, 5);

                }

            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isboxselected(6)) {
                    performAction((ImageView)view, 6);

                }

            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isboxselected(7)) {
                    performAction((ImageView)view, 7);

                }
            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isboxselected(8)) {
                    performAction((ImageView)view, 8);

                }

            }
        });
    }

    private void performAction(ImageView img, int selectboxposition) {
        boxpositions[selectboxposition] = playerTurn;
        if (playerTurn == 1) {
            img.setImageResource(R.drawable.img_2);
            if (checkplayerwin()) {
                winDialog winDialog = new winDialog(MainActivity.this, playeronename.getText().toString() + "Has Won The Match", MainActivity.this);
               winDialog.setCancelable(false);
                winDialog.show();

            } else if (totalselectedboxes == 9) {
                winDialog winDialog = new winDialog(MainActivity.this, "It Is Draw", MainActivity.this);
              winDialog.setCancelable(false);
                winDialog.show();

            } else {
                changeplayerTurn(2);
                totalselectedboxes++;

            }
        }
            else{
                img.setImageResource(R.drawable.img_2);
                if(checkplayerwin()){
                    winDialog winDialog = new winDialog(MainActivity.this, playertwoname.getText().toString() + "Has Won The Match", MainActivity.this);
                    winDialog.setCancelable(false);
                    winDialog.show();

                }
                else if(selectboxposition==9){
                    winDialog winDialog = new winDialog(MainActivity.this, "It Is Draw", MainActivity.this);
                    winDialog.setCancelable(false);
                    winDialog.show();

                }
                else{
                    changeplayerTurn(1);
                    totalselectedboxes++;
                }
        }



            }





 private void changeplayerTurn(int currentplayerTurn){
        playerTurn=currentplayerTurn;
        if(playerTurn==1){
            playeronenamelayout.setBackgroundResource(R.drawable.round_back_blue_border);
            playertwonamelayout.setBackgroundResource(R.drawable.round_back_dark_blue);
        }
        else{
            playertwonamelayout.setBackgroundResource(R.drawable.round_back_blue_border);
            playeronenamelayout.setBackgroundResource(R.drawable.round_back_dark_blue);

        }
 }
    private  boolean checkplayerwin(){
        boolean response=false;
        for(int i=0;i<combinationsList.size();i++){
            final int[]combination=combinationsList.get(i);
            if(boxpositions[combination[0]]==playerTurn && boxpositions[combination[1]]==playerTurn&& boxpositions[combination[2]]==playerTurn){
                response=true;
            }
        }
        return  response;
    }
    private  boolean isboxselected(int  boxposition){
        boolean response=false;
        if (boxpositions[boxposition] == 0) {


            response = true;
        }

        return  response;
    }
    public void restartmatch(){
        boxpositions=new int[]{0,0,0,0,0,0,0,0,0};
        playerTurn=1;
        totalselectedboxes=1;
        img1.setImageResource(R.drawable.transparent_back);
        img2.setImageResource(R.drawable.transparent_back);
        img3.setImageResource(R.drawable.transparent_back);
        img4.setImageResource(R.drawable.transparent_back);
        img5.setImageResource(R.drawable.transparent_back);
        img6.setImageResource(R.drawable.transparent_back);
        img7.setImageResource(R.drawable.transparent_back);
        img8.setImageResource(R.drawable.transparent_back);
        img9.setImageResource(R.drawable.transparent_back);



    }

}




