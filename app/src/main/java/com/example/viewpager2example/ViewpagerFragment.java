package com.example.viewpager2example;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewpagerFragment extends Fragment{

    TextView textView;
    Button btnView;

    //We set the UI of our dynamic fragments
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_viewpager, container, false);
        textView = view.findViewById(R.id.textView);
        btnView = view.findViewById(R.id.btnview);
        String data = getArguments().getString("key");
        String med_id = getArguments().getString("med_id");
        textView.setText(data);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Fragment: "+data+"MedID: "+med_id, Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }

}
