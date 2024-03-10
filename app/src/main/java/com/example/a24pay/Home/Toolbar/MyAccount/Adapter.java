package com.example.a24pay.Home.Toolbar.MyAccount;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a24pay.R;

import java.util.List;
import java.util.Objects;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context context;
    private List<String> list;
    private OnItemClickListener listener;
    private static final int TYPE_BIOMETRIC_AUTHENTIFICATION = 1;
    private static final int TYPE_ITEM = 2;
//    private List<String>

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public Adapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    public Adapter(Context context, List<String> list, OnItemClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

//    if postion ==3 adica Biometric authentification atunci in dreapta lui sa imi afiseze un switch
    @Override
    public int  getItemViewType(int position) {
        if(position==3){
            return TYPE_BIOMETRIC_AUTHENTIFICATION;
        }
        else return TYPE_ITEM;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        aici verifica sa faca schimbarea doar pentru biometric authentification adica sa adauge doar buttonul din dreapta

        if(viewType == TYPE_BIOMETRIC_AUTHENTIFICATION){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.settings_item_biometric_authentification,parent,false);
            return new ViewHolder(view);
        }else{
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.settings_item,parent,false);
            return new ViewHolder(view);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        set red color for "Logout"
        if(position == list.size()-1 && Objects.equals(list.get(position), "Logout")){
            holder.textView.setTextColor(ContextCompat.getColor(context, R.color.red));
        }

        String el = list.get(position);
        holder.textView.setText(el);
        System.out.println(el);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textItemSettings);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
