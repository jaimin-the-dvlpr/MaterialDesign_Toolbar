package com.jimmy.materialdesign_toolbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import static com.jimmy.materialdesign_toolbar.R.drawable.ic_favorite_black_24dp;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarcontent);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = findViewById(R.id.btnFav);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isFavourite = readState();

                if (isFavourite) {
                    fab.setImageResource(R.drawable.ic_favorite_border_black);
                Snackbar.make(view,"Bookmark Removed",Snackbar.LENGTH_LONG).show();
                isFavourite = false;
                    saveState(isFavourite);

                } else {

                    fab.setImageResource(R.drawable.ic_favorite_black_24dp);
                    Snackbar.make(view,"Bookmark Added",Snackbar.LENGTH_LONG).show();
                    isFavourite = true;
                    saveState(isFavourite);
                }
            }
        });
    }
    private void saveState(boolean isFavourite) {
        SharedPreferences aSharedPreferences = this.getSharedPreferences(
                "Favourite", Context.MODE_PRIVATE);
        SharedPreferences.Editor aSharedPreferencesEdit = aSharedPreferences
                .edit();
        aSharedPreferencesEdit.putBoolean("State", isFavourite);
        aSharedPreferencesEdit.commit();
    }
    private boolean readState() {
        SharedPreferences aSharedPreferences = this.getSharedPreferences("Favourite", Context.MODE_PRIVATE);
        return aSharedPreferences.getBoolean("State", true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
