package com.example.a24pay.Home.Toolbar.Settings.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a24pay.R;


public class ContactUsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_us2, container, false);
//        clasa asta nu mai trebuie
//        exista un contactUsFragment in Toolbar -> Notification -> ContactUsFragment
    }
}