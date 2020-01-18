package com.example.searchviewprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SearchView s;
    ListView lv1;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s=findViewById(R.id.searchview1);
        lv1=findViewById(R.id.listview1);
        list=new ArrayList<String>();


        list.add("Sunday");
        list.add("Monday");
        list.add("Tuesday");
        list.add("Monday");
        list.add("Wednesday");
        list.add("Thursday");
        list.add("Friday");
        list.add("Saturday");


        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        lv1.setAdapter(adapter);



        s.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query)
            {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query)
            {

                adapter.getFilter().filter(query);

                return false;

            }
        });

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position)
                {
                    case 0: Intent in= new Intent(MainActivity.this,Flower.class);
                             startActivity(in);
                            break;

                    case 1: Intent in1= new Intent(MainActivity.this,SearchResult.class);
                            startActivity(in1);
                        break;

                    case 2: Intent in2= new Intent(MainActivity.this,SearchResult1.class);
                               startActivity(in2);
                        break;

                    case 3: Intent in3= new Intent(MainActivity.this,Flower.class);
                        startActivity(in3);
                        break;

                        default:
                            Toast.makeText(MainActivity.this, "  no result found ", Toast.LENGTH_SHORT).show();


                }


            }
        });

    }

}

