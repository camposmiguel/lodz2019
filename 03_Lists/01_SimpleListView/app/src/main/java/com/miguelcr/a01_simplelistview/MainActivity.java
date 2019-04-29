package com.miguelcr.a01_simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    List<String> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Get the reference to the ListView
        lista = findViewById(R.id.listViewStudents);

        // 2. Create the list of elements
        // and add elements to the list
        studentList = new ArrayList<>();
        studentList.add("Krys " + "100 duck");
        studentList.add("Igor " + "84 ducks");
        studentList.add("Adam");
        studentList.add("Michal");
        studentList.add("Maciek");
        studentList.add("Dominik");
        studentList.add("Wiktor");
        studentList.add("Szymon");
        studentList.add("Mati");
        studentList.add("Krys II");
        studentList.add("Patryk");
        studentList.add("Adam II");
        studentList.add("Adrian");
        studentList.add("Dominik II");
        studentList.add("Filip");

        // 3. Adapt the list of student info
        // to the listView component
        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                studentList
        );

        // 4. connect the listview and the adapter
        lista.setAdapter(adapter);
    }
}
