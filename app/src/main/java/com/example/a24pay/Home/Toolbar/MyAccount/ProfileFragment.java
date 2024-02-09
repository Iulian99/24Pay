package com.example.a24pay.Home.Toolbar.MyAccount;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.a24pay.R;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment {
    private ImageView closeImageView;
    private RecyclerView recyclerView2;
    private List<String> myAccounList;
    private Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        myAccounList = new ArrayList<>();
        myAccounList.add("Profile");
        myAccounList.add("vehicles");
        myAccounList.add("Associated persons");
        myAccounList.add("Logout");

        recyclerView2 = view.findViewById(R.id.recyclerView2);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1);
        recyclerView2.setLayoutManager(gridLayoutManager);

        adapter = new Adapter(getActivity(),myAccounList);
        recyclerView2.setAdapter(adapter);

        closeImageView = view.findViewById(R.id.closeImageView);

        closeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getParentFragmentManager().popBackStack();
            }
        });

        return view;
    }
}