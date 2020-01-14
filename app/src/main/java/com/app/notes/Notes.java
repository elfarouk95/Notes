package com.app.notes;

import java.util.Date;

public class Notes {
    int id;
    String name;
    Date date;
    String f = "ضغط";
    String s = "سكر";
    String t = "درجة حرارة";

    int ff = 0;
    int ss = 0;

    public Notes(int id, String name, String date, int ff, int ss, int tt) {
        this.id = id;
        this.name = name;
        this.date = new Date(date);
        this.ff = ff;
        this.ss = ss;
        this.tt = tt;
    }

    int tt = 0;

    public Notes(String name) {
        this.name = name;
        this.date = new Date();
    }
}
