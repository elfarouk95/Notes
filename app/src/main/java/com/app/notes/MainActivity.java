package com.app.notes;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    RecyclerView ls;
    Adapter adapter;
    Opreation op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        op = Opreation.getOp(this);
        ls = findViewById(R.id.list);

        adapter = new Adapter(op.notes, this);
        op.changedData = new ChangedData() {
            @Override
            public void Change() {
                adapter.setNotes(Opreation.notes);
                adapter.notifyDataSetChanged();
            }
        };

        op.notfiyy();

        ls.setAdapter(adapter);
        GridLayoutManager grid = new GridLayoutManager(this, 2);
        ls.setLayoutManager(grid);


    }

    public void Add(View view) {
        Intent n = new Intent(this, AddActivity.class);
        startActivity(n);
    }

    public void Search(View view) {
        showCustomDialog();
    }

    public void CheckOut(View view) {
    }

    private void showCustomDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        dialog.setContentView(R.layout.activity_add);
        dialog.setCancelable(true);

        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        final EditText et_post = (EditText) dialog.findViewById(R.id.Name);
        final Button btn = dialog.findViewById(R.id.aa);
        btn.setText("Search");


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = et_post.getText().toString();
                op.Search(s);
                dialog.dismiss();
            }
        });


        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }

}
