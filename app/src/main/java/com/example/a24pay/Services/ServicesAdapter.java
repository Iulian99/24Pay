package com.example.a24pay.Services;

import android.content.Context;
import android.graphics.ColorSpace;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.a24pay.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ViewHolder> {

    private Context context;
//    private HashMap<String, List<ImageTitleList>> hashMap;
//    private List<String> categories; // aceasta lista va contine toate cheile (categorie)
    private List<ImageTitleList> dataList;

    public ServicesAdapter(List<ImageTitleList> list) {
        this.dataList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ImageTitleList.TEXT_TYPE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_type, parent, false);
            return new TextTypeViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_type, parent, false);
            return new ImageTypeViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageTitleList object = dataList.get(position);
        Log.d("ImageTitleList.TEXT_TYPE", "Object: " + ImageTitleList.TEXT_TYPE);
        Log.d("ImageTitleList.IMAGE_TYPE", "Type: " + ImageTitleList.IMAGE_TYPE);

        if (object.getType() ==ImageTitleList.TEXT_TYPE){
                if (holder instanceof TextTypeViewHolder) {
                    ((TextTypeViewHolder) holder).title.setText(object.getTitles());
                }
        }
        else if(object.getType()!=0) {

            System.out.println("AICI ESTE UN IMAGE_TYPE");
            if (holder instanceof ImageTypeViewHolder) {
                ((ImageTypeViewHolder) holder).cardView.setId(position);
                ((ImageTypeViewHolder) holder).imageType.setImageResource(object.getType());
                ((ImageTypeViewHolder) holder).transportTypeTextView.setText(object.getTransportTypeTextView());
                Log.d("ImageType", "Imaginea a fost luata");
            }
        }
    }

    @Override
    public int getItemCount() {
//        int count = 0;
//        for (List<ImageTitleList> list : hashMap.values()) {
//            count += list.size();
//        }
//        return count;

        if (dataList != null) {
            return dataList.size();
        } else {
            return 0; // sau orice alt număr care are sens în contextul tău
        }

//        return dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (dataList != null && position >= 0 && position < dataList.size()) {
            return dataList.get(position).getType();
        }
        return -1; // sau orice altă valoare de eroare adecvată
    }
    //    public static class ViewHolder extends RecyclerView.ViewHolder {
//        View itemView;
//
//        public ViewHolder(View view) {
//            super(view);
//            itemView = view.findViewById(R.id.itemView);
//        }
//    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public static class TextTypeViewHolder extends ViewHolder {
        TextView title;

        public TextTypeViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title); // înlocuiește 'textViewID' cu ID-ul real al TextView din layout

        }
    }

    public static class ImageTypeViewHolder extends ViewHolder {
        ImageView imageType;
        TextView transportTypeTextView;
        CardView cardView;

        public ImageTypeViewHolder(View itemView) {
            super(itemView);
            imageType = itemView.findViewById(R.id.imageView);
            transportTypeTextView = itemView.findViewById(R.id.transportTypeTextView);
            cardView = itemView.findViewById(R.id.cardView);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
