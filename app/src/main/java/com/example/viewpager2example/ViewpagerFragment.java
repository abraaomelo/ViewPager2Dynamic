package com.example.viewpager2example;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ViewpagerFragment extends Fragment{

    TextView textView;

    //We set the UI of our dynamic fragments
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_viewpager, container, false);
        textView = view.findViewById(R.id.textView);
        String data = getArguments().getString("key");
        textView.setText(data);
        return view;
    }
}
