package com.example.a24pay.Home.Toolbar.Settings.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a24pay.Home.Toolbar.Notification.Adapter;
import com.example.a24pay.Home.Toolbar.Notification.NotificationsList;
import com.example.a24pay.R;

import java.util.ArrayList;
import java.util.List;


public class FAQFragment extends Fragment {
    private TextView textViewTitleFragment;
    private ImageButton imageButton;
    private RecyclerView recyclerView;
    private List<NotificationsList> list;
    private Adapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_f_a_q, container, false);
        textViewTitleFragment = view.findViewById(R.id.toolbar_title);//setez textul pe care il afisez din custom_toolbar.xml
        textViewTitleFragment.setText(getString(R.string.title_fragment_faq));
        imageButton = view.findViewById(R.id.back_button);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        });


        list = new ArrayList<>();
        list.add(new NotificationsList("How do I create an account?","Array1"));
        list.add(new NotificationsList("What information must I provide?","Array2"));
        list.add(new NotificationsList("How do I administer my personal information?","Array3"));
        list.add(new NotificationsList("How to I add a credit card","Array1"));
        list.add(new NotificationsList("What is 24payPIN code?","Array1"));
        list.add(new NotificationsList("If I forgot 24payPIN code?","Array1"));
        list.add(new NotificationsList("What should I do if I reinstalled the app or if I have a new device?","Array1"));
        list.add(new NotificationsList("What should I do if I changed my phone number","Array1"));
        list.add(new NotificationsList("How to I make a payment","Array1"));
        list.add(new NotificationsList("What is a QR code?","Array1"));
        list.add(new NotificationsList("What is a NFC tag?","Array1"));
        list.add(new NotificationsList("How do I scan a QR code?","Array1"));
        list.add(new NotificationsList("How do I scan an NFC tag","Array1"));
        list.add(new NotificationsList("Are my payments safe?","Array1"));
        list.add(new NotificationsList("Is my credit card information safe?","Array1"));
        list.add(new NotificationsList("How do I send feedback","Array1"));
        list.add(new NotificationsList("Validation SMS","Array1"));
        list.add(new NotificationsList("Scan","Array1"));


        recyclerView = view.findViewById(R.id.recyclerView);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new Adapter(getActivity(),list);
        recyclerView.setAdapter(adapter);

        return view;
    }
}