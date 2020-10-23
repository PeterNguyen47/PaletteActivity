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
    // Adding resources
    Resources resources;

    public CustomAdapter(Context context, int[] colors) {
        this.context = context;
        this.colors = colors;
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

        // String array (update), fills in String of color names into Grid View via resources
        resources = context.getResources();

        customTextView = new TextView(context);
        Log.d("MainActivity", "customTextView is found: " + true);

        // Set Back ground color into Grid View
        customTextView.setBackgroundResource(colors[position]);

        if (position == 2) {
            customTextView.setTextColor(Color.WHITE);
        }
        else if (position == 8) {
            customTextView.setTextColor(Color.WHITE);
        }

        // Set the text of color string array into Grid View
        customTextView.setText(resources.getResourceEntryName(colors[position]));

        // Set the padding to give space similar to assignment example
        // Set Text Size in Grid
        customTextView.setPadding(55,80,55,80);
        customTextView.setTextSize(20);

        return customTextView;
    }
}