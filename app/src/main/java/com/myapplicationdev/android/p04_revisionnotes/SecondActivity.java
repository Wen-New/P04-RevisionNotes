package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Note> alNote;
    ArrayAdapter<Note> aaNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO implement the Custom ListView
        setContentView(R.layout.activity_second);

        lv = (ListView)findViewById(R.id.lv);

        Intent i = getIntent();
        DBHelper db = new DBHelper(SecondActivity.this);

        // Insert a task
        ArrayList<String> data = db.getNoteContent();
        db.close();

        DBHelper db2 = new DBHelper(SecondActivity.this);
        alNote = db2.getAllNotes();
        db2.close();

        aaNote = new RevisionNotesArrayAdapter(SecondActivity.this, R.layout.row, alNote);
        lv.setAdapter(aaNote);
    }


}
