package edu.temple.paletteactivity;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import static edu.temple.paletteactivity.PaletteActivity.EXTRA_MESSAGE;

public class CanvasActivity extends AppCompatActivity {

    TextView canvasTextView;
    Bundle pnBundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        // Set Canvas Activity Label
        getSupportActionBar().setTitle(R.string.canvas_name);
        Log.d("CanvasActivity", "Action Bar Set to Canvas Activity: " + (getSupportActionBar() != null));

        canvasTextView = findViewById(R.id.canvasTextView);
        Log.d("CanvasActivity", "canvasTextView was found " + (canvasTextView != null));

        pnBundle = getIntent().getExtras();
        Log.d("CanvasActivity", "pnBundle was found: " + (pnBundle != null));

        int selection = pnBundle.getInt(EXTRA_MESSAGE);
        Log.d("CanvasActivity", "User selection was found: " + selection);

        // Sets respective background color when selection is made
        canvasTextView.setBackgroundColor(selection);

        // Sets the secondary activity text size
        canvasTextView.setTextSize(50);

        // Conditions for each grid selection
        if (selection == Color.GREEN ) {
            canvasTextView.setText(R.string.green);
        }
        else if(selection == Color.WHITE) {
            canvasTextView.setText(R.string.white);
        }
        else if(selection == Color.BLACK) {
            canvasTextView.setText((R.string.black));
            canvasTextView.setTextColor(Color.WHITE);
        }
        else if (selection == Color.CYAN) {
            canvasTextView.setText((R.string.cyan));
        }
        else if (selection == Color.MAGENTA) {
            canvasTextView.setText((R.string.magenta));
        }
        else if (selection == Color.YELLOW) {
            canvasTextView.setText((R.string.yellow));
        }
        else if (selection == Color.GRAY) {
            canvasTextView.setText((R.string.gray));
        }
        else if (selection == Color.RED) {
            canvasTextView.setText((R.string.red));
        }
        else if (selection == Color.BLUE) {
            canvasTextView.setText((R.string.blue));
        }
    }
}

