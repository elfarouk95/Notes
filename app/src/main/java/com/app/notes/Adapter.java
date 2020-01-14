package com.app.notes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<noteViewHolder> {
    ArrayList<Notes> notes = new ArrayList<>();
    Context mContext;

    Opreation p;

    public Adapter(ArrayList<Notes> notes, Context mContext) {
        this.notes = notes;
        this.mContext = mContext;
        p = Opreation.getOp(mContext);

    }

    public void setNotes(ArrayList<Notes> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public noteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.noteitem, viewGroup, false);
        return new noteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final noteViewHolder h, int i) {

        final Notes n = notes.get(i);
        h.name.setText(n.name);
        h.datee.setText(n.date.toString());
        h.fs.setText(n.f);
        h.sd.setText(n.s);
        h.th.setText(n.t);

        h.fs.setChecked(n.ff != 0);
        h.sd.setChecked(n.ss != 0);
        h.th.setChecked(n.tt != 0);


        h.fs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.checkout(n, 0, h.fs.isChecked());

            }
        });

        h.sd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.checkout(n, 1, h.sd.isChecked());

            }
        });

        h.th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.checkout(n, 2, h.th.isChecked());

            }
        });


        h.cls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notes.remove(n);
                notifyDataSetChanged();
            }
        });


    }

    @Override
    public int getItemCount() {
        return notes.size();
    }
}
