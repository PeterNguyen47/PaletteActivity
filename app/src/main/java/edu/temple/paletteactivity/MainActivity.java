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

    int[] colorIds = {
                R.color.Green,
                R.color.White,
                R.color.Black,
                R.color.Cyan,
                R.color.Magenta,
                R.color.Yellow,
                R.color.Gray,
                R.color.Red,
                R.color.Blue,
        };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set Palette Activity label
        getSupportActionBar().setTitle(R.string.palette_name);
        Log.d("MainActivity", "Action Bar Set to Palette Activity: " + (getSupportActionBar() != null));

        fm = getSupportFragmentManager();
        canvasFragment = new CanvasFragment();

        if (!(fm.findFragmentById(R.id.container_1) instanceof CanvasFragment)) {
            fm.beginTransaction()
                    .add(R.id.container_1, PaletteFragment.newInstance(colorIds))
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
        public void colorSelected(int index) {
            CanvasFragment newFragment = new CanvasFragment();
            Bundle args = new Bundle();
            args.putInt(CanvasFragment.COLORID_KEY, index);
            newFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.container_2, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
            }
        }
