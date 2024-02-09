package com.example.a24pay.Home.Toolbar.Settings.Fragments.NotificationSettings;

import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a24pay.R;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context context;
    private List<NotificationList> notificationSettingsList;

    public Adapter(Context context, List<NotificationList> notificationSettingsList) {
        this.context = context;
        this.notificationSettingsList = notificationSettingsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_settings_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NotificationList list = notificationSettingsList.get(position);
        String title = list.getTitle();
        String text = list.getText();
        boolean aSwitch = list.isSwitchedOn();
        holder.title.setText(title);
        holder.text.setText(text);
        holder.aSwitch.setChecked(aSwitch);

        holder.aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Actualizează starea switch-ului în lista de date.
                list.setSwitchedOn(isChecked);

                // Salvează noua stare în SharedPreferences.
                SharedPreferences sharedPreferences = context.getSharedPreferences("your_pref", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(list.getTitle(), isChecked);
                editor.apply();
            }
        });
    }

    @Override
    public int getItemCount() {
        return notificationSettingsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView text;
        Switch aSwitch;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textView_title);
            text = itemView.findViewById(R.id.textView_content);
            aSwitch = itemView.findViewById(R.id.switch_button);
        }
    }
}
