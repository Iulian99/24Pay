package com.example.a24pay.Home.Toolbar.Settings.Fragments;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.a24pay.R;

public class LanguageFragment extends Fragment {
    private RadioButton radioRomanian;
    private RadioButton radioEnglish;
    private ConstraintLayout constraintLayoutLanguageRomania;
    private ConstraintLayout constraintLayoutLanguageEnglish;
    private TextView textViewTitleFragment;
    private ImageButton imageButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_language, container, false);
        textViewTitleFragment = view.findViewById(R.id.toolbar_title);//setez textul pe care il afisez din custom_toolbar.xml
        textViewTitleFragment.setText(getString(R.string.title_fragment_language));

        radioRomanian = view.findViewById(R.id.radioRomanian);
        radioEnglish = view.findViewById(R.id.radioEnglish);
        constraintLayoutLanguageRomania = view.findViewById(R.id.constraintLayoutLanguageRomania);
        constraintLayoutLanguageEnglish = view.findViewById(R.id.constraintLayoutLanguageEnglish);

        constraintLayoutLanguageRomania.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioRomanian.setChecked(true);
                radioEnglish.setChecked(false);
                // Orice alt cod pe care dorești să-l rulezi atunci când este selectat RadioButton-ul Romanian
            }
        });

        constraintLayoutLanguageEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioRomanian.setChecked(false);
                radioEnglish.setChecked(true);
                // Orice alt cod pe care dorești să-l rulezi atunci când este selectat RadioButton-ul English
            }
        });

        imageButton = view.findViewById(R.id.back_button);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        });
        return view;
    }
}