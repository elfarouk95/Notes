package com.app.notes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class noteViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView datee;
    CheckBox fs;
    CheckBox sd;
    CheckBox th;
    ImageView cls;

    public noteViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.PatientName);
        datee = itemView.findViewById(R.id.Datee);
        fs = itemView.findViewById(R.id.First);
        sd = itemView.findViewById(R.id.sd);
        th = itemView.findViewById(R.id.th);
        cls = itemView.findViewById(R.id.Close);
    }
}
