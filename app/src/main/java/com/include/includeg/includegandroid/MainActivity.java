package com.include.includeg.includegandroid;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        {
            ListView roomListView = (ListView) findViewById(R.id.roomList);
            ArrayList<Room> roomList = new ArrayList<>();
            roomList.add(new Room(Meal.Lunch,Location.North,1));
            roomList.add(new Room(Meal.Dinner,Location.East,2));
            roomList.add(new Room(Meal.Lunch,Location.North,1));
            RoomListAdapter roomListAdapter = new RoomListAdapter(this,R.layout.room_list_item,roomList);
            roomListView.setAdapter(roomListAdapter);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
//            System.out.println("settings");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class Room {
        Meal meal;
        Location location;
        int count;
        public Room(Meal _meal, Location _location, int _count) {
            meal=_meal;
            location=_location;
            count=_count;
        }
    }
    enum Meal {
        Lunch, Breakfast, Dinner, Yasik
    }
    enum Location {
        North, East, West
    }
}
