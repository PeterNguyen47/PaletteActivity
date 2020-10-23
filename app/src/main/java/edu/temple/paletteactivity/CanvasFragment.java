package edu.temple.paletteactivity;

import android.content.ClipData;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.jar.Attributes;

// This Fragment has the ability to change the background color and display name of color
public class CanvasFragment extends Fragment {

    public static final String COLORID_KEY = "colors";

    TextView canvasTextView;
    View l;
    Resources resources;
    Context context;
    String[] name;

    int colorId;

    public CanvasFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            colorId = getArguments().getInt(COLORID_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("CanvasFragment", "onCreateView is Called");
        // Inflate the layout for this fragment
        l = inflater.inflate(R.layout.fragment_canvas, container, false);

        canvasTextView = l.findViewById(R.id.canvasTextView);
        Log.d("CanvasFragment", "is canvasTextView is null " + (canvasTextView == null));

        canvasTextView.setBackgroundResource(colorId);
        canvasTextView.setTextSize(30);

        //TODO Change canvas text
        canvasTextView.setText(colorId);

        return l;
    }
}
