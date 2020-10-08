package edu.temple.paletteactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    ArrayList<Integer> pnColors;
    Intent pnIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set Palette Activity label
        getSupportActionBar().setTitle("Palette Activity");
        Log.d("PaletteActivity", "Action Bar Set to Palette Activity: " + (getSupportActionBar() !=null));

        // Integer array list of colors, this gives the grid boxes their background color
        pnColors = new ArrayList<>();
        pnColors.add(Color.GREEN);
        pnColors.add(Color.WHITE);
        pnColors.add(Color.BLACK);
        pnColors.add(Color.CYAN);
        pnColors.add(Color.MAGENTA);
        pnColors.add(Color.YELLOW);
        pnColors.add(Color.GRAY);
        pnColors.add(Color.RED);
        pnColors.add(Color.BLUE);

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
                pnIntent.putExtra(EXTRA_MESSAGE, pnColors.get(position));
                startActivity(pnIntent);
            }
        });
    }
}
