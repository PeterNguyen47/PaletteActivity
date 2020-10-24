package edu.temple.paletteactivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;

// This Fragment will allow user to pick a color
public class PaletteFragment extends Fragment {

    public static final String COLOR_KEY = "colors";
    public static final String COLORNAMES_KEY = "colorNames";

    private int[] colors;
    private String[] colorNames;

    View l;
    GridView paletteGridView;
    ColorSelectedInterface parentActivity;

    public PaletteFragment() {}

    // Factory Method, change of background color and display text, need 2 keys
    public static PaletteFragment newInstance(int[] colors, String[] colorNames) {
        PaletteFragment fragment = new PaletteFragment();
        Bundle args = new Bundle();
        args.putIntArray(COLOR_KEY, colors);
        args.putStringArray(COLORNAMES_KEY, colorNames);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof ColorSelectedInterface) {
            parentActivity = (ColorSelectedInterface) context;
        }
        else
            throw new RuntimeException("Please implement ColorSelectedInterface to attach this fragment");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            colors = getArguments().getIntArray(COLOR_KEY);
            colorNames = getArguments().getStringArray(COLORNAMES_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        l = inflater.inflate(R.layout.fragment_palette, container, false);

        paletteGridView = l.findViewById(R.id.paletteGridView);

        paletteGridView.setAdapter(new CustomAdapter((Context) parentActivity, colors, colorNames));

        paletteGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                parentActivity.colorSelected(colors[position], colorNames[position]);
            }
        });

        return l;
    }

    // interface to interact with Main Activity
    interface ColorSelectedInterface {
        void colorSelected(int color, String colorName);
    }
}