package edu.temple.paletteactivity;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    public static ArrayList<Integer> pnColors;
    Context context;
    TextView customTextView;

    public CustomAdapter(Context context, ArrayList<Integer> pnColors) {
        this.context = context;
        CustomAdapter.pnColors = pnColors;
    }

    @Override
    public int getCount() {
        Log.d("PaletteActivity", "pnColors size is: " + pnColors.size());
        return pnColors.size();

    }

    @Override
    public Object getItem(int position) {
        Log.d("PaletteActivity", "Color position is: " + position);
        return pnColors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // View seen on Palette Activity Screen
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        customTextView = new TextView(context);
        Log.d("PaletteActivity", "customTextView is found: " + true);

        // Fill in String of colors into Grid View of corresponding color
        final String[] pnColors = {"Green","White","Black","Cyan","Magenta","Yellow","Gray","Red","Blue"};

        // Set Black Grid Text to be visible
        if (position == 2){
            customTextView.setTextColor(Color.WHITE);
        }

        // Set the text of color string array into Grid View
        // Set the padding to give space similar to assignment example
        // Set Back ground color into Grid View
        // Set Text Size
        customTextView.setText(pnColors[position]);
        customTextView.setPadding(50,50,50,50);
        customTextView.setBackgroundColor(CustomAdapter.pnColors.get(position));
        customTextView.setTextSize(18);

        return customTextView;
    }
}