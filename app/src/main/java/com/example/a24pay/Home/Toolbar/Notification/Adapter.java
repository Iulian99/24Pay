package com.example.a24pay.Home.Toolbar.Notification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a24pay.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context context;
    private List<NotificationsList> notificationsList;

    public Adapter(Context context, List<NotificationsList> notificationsList) {
        this.context = context;
        this.notificationsList = notificationsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NotificationsList pairElementOfList = notificationsList.get(position); // Extragi elementul de pe prima poziție
        String titleElement = pairElementOfList.getTitle();
        String textElement = pairElementOfList.getText();
        String textDate = pairElementOfList.getPublicationDate();
//        String el = notificationsList.get(position);
        holder.headerText.setText(titleElement);
        holder.expandedText.setText(textElement);
        holder.publicationDate.setText(textDate);
//        System.out.println(el);
    }

    @Override
    public int getItemCount() {
        return notificationsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView headerText;
        TextView publicationDate;
        ImageView expandIcon;
        TextView expandedText;
        TextView link;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            headerText = itemView.findViewById(R.id.header_text);
            expandIcon = itemView.findViewById(R.id.expand_icon);
            expandedText = itemView.findViewById(R.id.expanded_text);
            publicationDate = itemView.findViewById(R.id.expanded_date_notification);
            expandIcon.setOnClickListener(toggleListener());
        }

        public View.OnClickListener toggleListener(){
            View.OnClickListener toggleListener = v -> {
                if (expandedText.getVisibility() == View.GONE) {
                    expandedText.setVisibility(View.VISIBLE);
                    publicationDate.setVisibility(View.VISIBLE);
                    expandIcon.setImageResource(R.drawable.icon_up);
                } else {
                    expandedText.setVisibility(View.GONE);
                    publicationDate.setVisibility(View.GONE);
                    expandIcon.setImageResource(R.drawable.icon_down);

                }
            };
            return toggleListener;
        }
    }
}
