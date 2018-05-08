package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etNote;
    Button btnInsertNote, btnShowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNote = (EditText)findViewById(R.id.editTextNote);
        btnInsertNote = (Button)findViewById(R.id.buttonInsertNote);
        btnShowList = (Button)findViewById(R.id.buttonShowList);

        btnInsertNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroupStars);
                int selectedRB = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton)findViewById(selectedRB);
                DBHelper db = new DBHelper(MainActivity.this);
                if (selectedRB == R.id.radio1) {
                    db.insertNote(etNote.getText().toString(), 1);
                } else if (selectedRB == R.id.radio2) {
                    db.insertNote(etNote.getText().toString(), 2);
                } else if (selectedRB == R.id.radio3) {
                    db.insertNote(etNote.getText().toString(), 3);
                } else if (selectedRB == R.id.radio4) {
                    db.insertNote(etNote.getText().toString(), 4);
                } else if (selectedRB == R.id.radio5) {
                    db.insertNote(etNote.getText().toString(), 5);
                }
                Toast.makeText(MainActivity.this ,"Inserted", Toast.LENGTH_SHORT).show();
                db.close();
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(i);
            }
        });
    }
}
