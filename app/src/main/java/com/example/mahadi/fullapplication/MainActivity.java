package com.example.mahadi.fullapplication;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    private DrawerLayout myDrawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolBar();

        myDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        drawerToggle = new ActionBarDrawerToggle(this, myDrawerLayout, R.string.open, R.string.close);
        myDrawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.toolbarTitle);
        setSupportActionBar(toolbar);
    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (drawerToggle.onOptionsItemSelected(item)) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
// Handle item selection
        switch (item.getItemId()) {
            case R.id.miCompose:
                Toast.makeText(MainActivity.this, "clicking on email", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.miProfile:
                Toast.makeText(MainActivity.this, "clicking on profile", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
