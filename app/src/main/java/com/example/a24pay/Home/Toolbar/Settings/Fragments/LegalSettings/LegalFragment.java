package com.example.a24pay.Home.Toolbar.Settings.Fragments.LegalSettings;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.a24pay.Home.Toolbar.MyAccount.Adapter;

import com.example.a24pay.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LegalFragment extends Fragment implements Adapter.OnItemClickListener{
    private List<String> legalFragmentList;
    private RecyclerView recyclerView;
    private Adapter adapter;
    private ImageView closeImageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_legal, container, false);
        closeImageView = view.findViewById(R.id.closeImageView);

        legalFragmentList = new ArrayList<>();
        legalFragmentList.addAll(Arrays.asList(
                "Terms and conditions",
                "Privacy policy",
                "Marketing policy"
        ));

        recyclerView = view.findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),1);
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new Adapter(getActivity(),legalFragmentList,this);
        recyclerView.setAdapter(adapter);

        closeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Închide fragmentul curent și se întoarce la cel anterior
                getParentFragmentManager().popBackStack();
            }
        });
        return view;
    }

    @Override
    public void onItemClick(int position) {
        Fragment fragmentToDisplay = null;

        switch (position) {
            case 0:
                fragmentToDisplay = new LegalFragmentRules("https://www.google.com/");
                break;
            case 1:
                fragmentToDisplay = new LegalFragmentRules("");
                break;
            case 2:
                fragmentToDisplay = new LegalFragmentRules("");
                break;
            // ... și așa mai departe pentru fiecare opțiune din listă
        }
        //schimba activitatea catre un fragment de la fragment container(MAinActivity -> NotificationFragment)
        if (fragmentToDisplay != null) {
            requireActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragmentToDisplay) // presupunând că "container" este ID-ul FrameLayout sau al altui container în care dorești să afișezi fragmentul
                    .addToBackStack(null)
                    .commit();
        }
    }
}