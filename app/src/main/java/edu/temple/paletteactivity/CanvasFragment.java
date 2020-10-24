package edu.temple.paletteactivity;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

// This Fragment has the ability to change the background color and display name of color
public class CanvasFragment extends Fragment {

    public static final String COLORID_KEY = "color";
    public static final String COLORNAME_KEY = "colorName";

    TextView canvasTextView;
    View l;

    private int colorId;
    private String colorName;

    public CanvasFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            colorId = getArguments().getInt(COLORID_KEY);
            colorName = getArguments().getString(COLORNAME_KEY);
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

        // set canvas background color
        canvasTextView.setBackgroundColor(colorId);
        // set canvas text
        canvasTextView.setText(colorName);
        // set canvas text size
        canvasTextView.setTextSize(30);

        return l;
    }
}
