package com.example.mahadi.fullapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class EvenActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_even);
        initToolBar();
    }

    //  function:Custom Tool bar.
    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.even);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(EvenActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.miCompose:
                Toast.makeText(EvenActivity.this, "clicking on email", Toast.LENGTH_SHORT).show();
                //customToast("You clicked Email BTN");
                customDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    Customize toast function
    public void customToast(String msg){

        LayoutInflater inflater = getLayoutInflater();
        View customView = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.tst));

        TextView text = (TextView) customView.findViewById(R.id.tst_txt);
        text.setText(msg);


        Toast toast = new Toast(EvenActivity.this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setView(customView);
        toast.show();
    }

    public void customDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(EvenActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialog_signin,null))
                .setTitle("Custom Dialog Box")
                .setIcon(R.drawable.toast_icon)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        customToast("You Clicked Ok button");
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        customToast("You Clicked No button");
                    }
                })
                .setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        customToast("You Clicked Cancel button");
                    }
                })
                .create()
                .show();
    }

}
