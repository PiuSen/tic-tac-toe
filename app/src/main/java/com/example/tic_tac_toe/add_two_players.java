package com.example.tic_tac_toe;

import static com.example.tic_tac_toe.R.id.playerone;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class add_two_players extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_two_players);
        final EditText playerone=findViewById(R.id.playerone);
        final EditText playertwo=findViewById(R.id.playertwo);
        final Button startgame=findViewById(R.id.startgame);
        startgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String getplayeronename=playerone.getText().toString();
                final String getplayertwoname=playertwo.getText().toString();
                if(getplayeronename.isEmpty() || getplayertwoname.isEmpty()){
                    Toast.makeText(add_two_players.this, "Please Enter Player Name", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent inext=new Intent(add_two_players.this,MainActivity.class);
                    Intent playerone = inext.putExtra("playerone", getplayeronename);
                    Intent playertwo= inext.putExtra("playertwo", getplayertwoname);
                   startActivity(inext);
                }

            }
        });

    }
}