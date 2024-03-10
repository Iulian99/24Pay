package com.example.a24pay.Services;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.a24pay.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ServicesFragment extends Fragment {

    private RecyclerView recyclerView;
    private ServicesAdapter adapter;
    private List<Integer> images;
    private List<String> imageTitles;
    private HashMap<String, List<ImageTitleList>> hashMap = new HashMap<>();
    List<ImageTitleList> dataList;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_services, container, false);
//        public list transport, train cfr, parking, plane tickets....
        dataList = new ArrayList<>();
        dataList = createList();

        recyclerView = view.findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 6);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch(adapter.getItemViewType(position)){
                    case ImageTitleList.TEXT_TYPE:
                        return 6; // textul va ocupa 3 coloane, adică întreaga lățime
                    case ImageTitleList.IMAGE_TYPE:
                        return 1; // imaginile vor ocupa 1 coloană
                    default:
                        return 2;
                }
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);

        adapter = new ServicesAdapter(dataList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    public List<ImageTitleList> createList(){
        dataList.add(new ImageTitleList(ImageTitleList.TEXT_TYPE, "Transport", 0));
        dataList.add(new ImageTitleList(ImageTitleList.IMAGE_TYPE, "", R.drawable.bus,"Public transport"));
        dataList.add(new ImageTitleList(ImageTitleList.IMAGE_TYPE, "", R.drawable.bus,"Train CFR"));
        dataList.add(new ImageTitleList(ImageTitleList.IMAGE_TYPE, "", R.drawable.bus,"Parking"));
        dataList.add(new ImageTitleList(ImageTitleList.IMAGE_TYPE, "", R.drawable.bus,"Plane tickets"));
        dataList.add(new ImageTitleList(ImageTitleList.TEXT_TYPE, "Payments", 0));
        dataList.add(new ImageTitleList(ImageTitleList.IMAGE_TYPE, "", R.drawable.bus,"Mobile Top Up"));
        dataList.add(new ImageTitleList(ImageTitleList.IMAGE_TYPE, "", R.drawable.bus,"Bill Payment"));
        dataList.add(new ImageTitleList(ImageTitleList.IMAGE_TYPE, "", R.drawable.bus,"eMoney"));
        dataList.add(new ImageTitleList(ImageTitleList.IMAGE_TYPE, "", R.drawable.bus,"Gaming"));
        dataList.add(new ImageTitleList(ImageTitleList.TEXT_TYPE, "Rca& auto taxes", 0));
        dataList.add(new ImageTitleList(ImageTitleList.IMAGE_TYPE, "", R.drawable.bus,"RCA"));
        dataList.add(new ImageTitleList(ImageTitleList.IMAGE_TYPE, "", R.drawable.bus,"Rovignette"));
        dataList.add(new ImageTitleList(ImageTitleList.TEXT_TYPE, "Utils", 0));
        dataList.add(new ImageTitleList(ImageTitleList.IMAGE_TYPE, "", R.drawable.bus,"SanoPass"));
        dataList.add(new ImageTitleList(ImageTitleList.IMAGE_TYPE, "", R.drawable.bus,"Car wash"));
        dataList.add(new ImageTitleList(ImageTitleList.TEXT_TYPE, "Entertaiment", 0));
        dataList.add(new ImageTitleList(ImageTitleList.IMAGE_TYPE, "", R.drawable.bus,"Kiddie rides"));
        dataList.add(new ImageTitleList(ImageTitleList.IMAGE_TYPE, "", R.drawable.bus,"Massage chairs"));
        dataList.add(new ImageTitleList(ImageTitleList.IMAGE_TYPE, "", R.drawable.bus,"Coffe/snack"));
        return dataList;
    }

}
