package com.example.a24pay.Home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a24pay.R;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private final List<ListItem> list;

    public ImageAdapter(List<ListItem> list) {
        this.list = new ArrayList<>(list);
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_page_home, parent, false);
        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        ListItem currentItem = list.get(position);
        holder.imageView.setImageResource(currentItem.getIconId());
        holder.textViewTitle.setText(currentItem.getTitle());
        holder.textViewSubTitle.setText(currentItem.getSubtitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView textViewTitle;
        final TextView textViewSubTitle;


        ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewTitle = itemView.findViewById(R.id.title_textView);
            textViewSubTitle = itemView.findViewById(R.id.subtitle_textView);
        }
    }
}
