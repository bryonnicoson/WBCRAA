package com.example.bryon.wishbonecaninerescue;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FosterFragment extends Fragment {

    Button btnFoster;

    public static FosterFragment newInstance() {
        FosterFragment fragment = new FosterFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_foster, container, false);
        btnFoster = view.findViewById(R.id.button_foster);
        btnFoster.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.MULTIPLY);
        btnFoster.setTextColor(Color.WHITE);

        btnFoster.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intentApply = new Intent(Intent.ACTION_VIEW, Uri.parse("http://fs16.formsite.com/WishBoneCanineRescue/form15/index.html"));
                startActivity(intentApply);
            }
        });

        return view;
    }
}


