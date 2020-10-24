package edu.temple.paletteactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements PaletteFragment.ColorSelectedInterface {

    CanvasFragment canvasFragment;
    FragmentManager fm;

    int[] colors;
    String[] colorNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get resources to use for color array and color names array
        Resources resources = this.getResources();
        this.colors = resources.getIntArray(R.array.colorPalette);
        this.colorNames = resources.getStringArray(R.array.colors);

        // Set Palette Activity label
        getSupportActionBar().setTitle(R.string.palette_name);
        Log.d("MainActivity", "Action Bar Set to Palette Activity: " + (getSupportActionBar() != null));

        fm = getSupportFragmentManager();
        canvasFragment = new CanvasFragment();

        if (!(fm.findFragmentById(R.id.container_1) instanceof CanvasFragment)) {
            fm.beginTransaction()
                    .add(R.id.container_1, PaletteFragment.newInstance(colors, colorNames))
                    .commit();
        }
        else {
            fm.beginTransaction()
                .add(R.id.container_2, canvasFragment).addToBackStack(null)
                .commit();
        }
    }

        // Display Background color when a selection is made (2 containers in activity)
        @Override
        public void colorSelected(int color, String colorName) {
            CanvasFragment canvasFragment = new CanvasFragment();
            Bundle args = new Bundle();
            args.putInt(CanvasFragment.COLORID_KEY, color);
            args.putString(CanvasFragment.COLORNAME_KEY, colorName);
            canvasFragment.setArguments(args);

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            fragmentTransaction.replace(R.id.container_2, canvasFragment);
            fragmentTransaction.addToBackStack(null);

            // Commit the transaction
            fragmentTransaction.commit();
            }
        }