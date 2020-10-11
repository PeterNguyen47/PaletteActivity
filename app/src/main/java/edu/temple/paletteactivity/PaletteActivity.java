package edu.temple.paletteactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import java.util.ArrayList;

public class PaletteActivity extends AppCompatActivity {

    // Easier reference, accessible by other activities (android developer - starting activity)
    public static final String EXTRA_MESSAGE = "edu.temple.paletteactivity.MESSAGE";

    // Objects list to use
    GridView pnColorGridView;
    Intent pnIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set Palette Activity label
        getSupportActionBar().setTitle(R.string.palette_name);
        Log.d("PaletteActivity", "Action Bar Set to Palette Activity: " + (getSupportActionBar() !=null));

        // Integer color array resource (update), gives grid boxes their background color via resources
        Resources resources = PaletteActivity.this.getResources();
        final int[] pnColors = PaletteActivity.this.getResources().getIntArray(R.array.colorPalette);

        // find Grid View of act main xml
        pnColorGridView = findViewById(R.id.pnColorGridView);
        Log.d("PaletteActivity", "pnColorGridView was found " + (pnColorGridView != null));

        // set up adapter (Universal Bridge of Connections)
        final BaseAdapter pnAdapter = new CustomAdapter(this, pnColors);
        pnColorGridView.setAdapter(pnAdapter);

        // Grid View listens for Click
        pnColorGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("PaletteActivity", "New item clicked... position = " + position + "...id = " + id);

                // used handler to access view and position
                sendClick(view, position);
            }

            // create handler constructor with Intent to go to secondary activity
            public void sendClick(View view, int position) {

                // Declaring an Intent to access the bundle in the secondary activity
                pnIntent = new Intent(getApplicationContext(), CanvasActivity.class);
                pnIntent.putExtra(EXTRA_MESSAGE, pnColors[position]);
                startActivity(pnIntent);
            }
        });
    }
}
