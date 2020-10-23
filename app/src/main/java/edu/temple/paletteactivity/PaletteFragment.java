package edu.temple.paletteactivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;

// This Fragment will allow user to pick a color
public class PaletteFragment extends Fragment {

    private static final String COLOR_KEY = "colors";
    private static final String COLOR_KEY2 = "colors";

    private int[] colors;
    private static String[] colorNames;

    View l;
    Bundle bundle;

    public PaletteFragment() {}

    ColorSelectedInterface parentActivity;

    // Factory Method
    public static PaletteFragment newInstance(int[] colors) {
        PaletteFragment fragment = new PaletteFragment();
        Bundle args = new Bundle();
        args.putIntArray(COLOR_KEY, colors);
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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        l = inflater.inflate(R.layout.fragment_palette, container, false);

        final GridView paletteGridView = l.findViewById(R.id.paletteGridView);

        paletteGridView.setAdapter(new CustomAdapter((Context) parentActivity, colors));

        paletteGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                parentActivity.colorSelected(colors[position]);
            }
        });

        return l;
    }

    interface ColorSelectedInterface {
        void colorSelected(int index);
    }
}