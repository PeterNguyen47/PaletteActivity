package edu.temple.paletteactivity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    int[] colors;
    Context context;
    TextView customTextView;
    String[] colorNames;

    public CustomAdapter(Context context, int[] colors, String[] colorNames) {
        this.context = context;
        this.colors = colors;
        this.colorNames = colorNames;
    }

    @Override
    public int getCount() {
            Log.d("MainActivity", "pnColors size is: " + colors.length);
            return colors.length;
    }

    @Override
    public Object getItem(int position) {
        Log.d("MainActivity", "Color position is: " + position);
        return colors[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // View seen on Palette Activity Screen
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        customTextView = new TextView(context);
        Log.d("MainActivity", "customTextView is found: " + true);

        // Set Back ground color into Grid View
        customTextView.setBackgroundColor(colors[position]);

        // Set the text of color string array into Grid View
        customTextView.setText(colorNames[position]);

        // Change text color of Grid for Black and Blue for better visual
        if (position == 2) {
            customTextView.setTextColor(Color.WHITE);
        }
        else if (position == 8) {
            customTextView.setTextColor(Color.WHITE);
        }

        // Set the padding to give space in each grid
        customTextView.setPadding(55,80,55,80);
        // Set text size in grid
        customTextView.setTextSize(20);

        return customTextView;
    }
}