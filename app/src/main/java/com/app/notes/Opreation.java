package com.app.notes;

import android.content.Context;

import java.util.ArrayList;

public class Opreation {

    ChangedData changedData;
    static DbHelper dbHelper;
    static ArrayList<Notes> notes = new ArrayList<>();
    private static Opreation op = new Opreation();

    static Context mContext;

    private Opreation() {

    }

    public static Opreation getOp(Context Context) {
        mContext = Context;
        dbHelper = new DbHelper(mContext);
        return op;
    }


    void notfiyy() {
        notes = dbHelper.notes();
        changedData.Change();
    }

    public void Add(Notes n) {
        dbHelper.Add(n);
        notfiyy();
    }

    public void checkout(Notes n, int id, boolean v) {

        if (id == 0) {
            n.ff = v ? 1 : 0;
        }
        if (id == 1) {
            n.ss = v ? 1 : 0;
        }
        if (id == 2) {
            n.tt = v ? 1 : 0;
        }
        dbHelper.Add(n);
        notfiyy();
    }

    public void Search(String s) {
        if (s.isEmpty()) {
            notes = dbHelper.notes();
            changedData.Change();
        }


        ArrayList<Notes> Rslt = new ArrayList<>();

        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).name.contains(s)) {
                Rslt.add(notes.get(i));
            }
        }
        notes = Rslt;
        changedData.Change();


    }
}
