package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView a;
    ArrayList<String> b;
    ArrayAdapter<String> c;
    Button add_button;
    EditText new_item_edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = findViewById(R.id.list_view);
        add_button = findViewById(R.id.add_button);
        new_item_edit_text = findViewById(R.id.new_item_edit_text);

        b = new ArrayList<>();
        c = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_multiple_choice, b);
        a.setAdapter(c);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.add(new_item_edit_text.getText().toString());
                c.notifyDataSetChanged();
            }
        });

        a.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> d, View e, int f, long g) {
                CheckedTextView h = ((CheckedTextView) e);
                if(h.isChecked()){
                    h.setChecked(false);
                }else{
                    h.setChecked(true);
                }
            }
        });
    }
}
