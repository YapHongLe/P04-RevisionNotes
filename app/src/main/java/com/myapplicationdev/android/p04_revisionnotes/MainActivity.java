package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnShow;
    RadioGroup rgS;
    EditText etContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.buttonInsertNote);
        btnShow = findViewById(R.id.buttonShowList);
        rgS = findViewById(R.id.radioGroupStars);
        etContent = findViewById(R.id.editTextNote);


        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper db = new DBHelper(MainActivity.this);
                String content = etContent.getText().toString();
                int selected = rgS.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(selected);
                int stars = Integer.parseInt(rb.getText().toString());
                // Insert a task
                db = new DBHelper(MainActivity.this);
                db.insertNote(content, stars);
                db.close();
                Toast.makeText(MainActivity.this,"Added", Toast.LENGTH_LONG).show();
            }
        });

    }


}
