package com.app.notes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ed = findViewById(R.id.Name);
    }

    public void AddNew(View view) {
        Opreation op = Opreation.getOp(this);
        Notes n = new Notes(ed.getText().toString());
        op.Add(n);
        finish();
    }
}
