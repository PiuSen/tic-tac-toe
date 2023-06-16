package com.example.tic_tac_toe;
import android.app.Dialog;
import  android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;

public class windialog extends Dialog {
    private  final  String message;
    private  final  MainActivity mainActivity;



    public windialog(@NonNull Context context String message,MainActivity mainActivity) {

        super(context);
        this.message=message;
        this.mainActivity=mainActivity;

    }

    @Override
    protected void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_dialog_layout);
    }
}
